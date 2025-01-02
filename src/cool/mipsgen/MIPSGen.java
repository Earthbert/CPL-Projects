package cool.mipsgen;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import cool.ast.nodes.ASTNode;
import cool.ast.visitors.mipsgen.MIPSGenVisitor;
import cool.ast.visitors.mipsgen.NTVisitor;
import cool.semantic.symbol.IdSymbol;
import cool.semantic.symbol.MethodSymbol;
import cool.semantic.symbol.SymbolTable;
import cool.utils.Utils;

public class MIPSGen {

	private final Map<String, List<MethodSymbol>> disptachTables = new LinkedHashMap<>();

	private final Map<String, Integer> classTags = new LinkedHashMap<>();

	private final Map<String, Integer> constStrings = new LinkedHashMap<>();
	private final Map<Integer, Integer> constInts = new LinkedHashMap<>();

	private final STGroupFile programTemplates = new STGroupFile(Utils.stTemplatesPath + "/program.stg");
	private final STGroupFile dataTemplates = new STGroupFile(Utils.stTemplatesPath + "/data.stg");
	private final STGroupFile textTemplates = new STGroupFile(Utils.stTemplatesPath + "/text.stg");

	public ST generateProgram(final ASTNode astRoot) {
		final var program = this.programTemplates.getInstanceOf("program");

		this.getStringLabel("");
		for (final var classSymbol : SymbolTable.getGlobals().getClasses().values()) {
			this.getStringLabel(classSymbol.getName());
			this.disptachTables.put(classSymbol.getName(), classSymbol.getDispatchTable());
		}

		program.add("text", this.generateTextSection(astRoot));
		program.add("data", this.generateDataSection());

		return program;
	}

	public ST generateTextSection(final ASTNode astRoot) {
		final ST textSection = this.programTemplates.getInstanceOf("sequence");

		textSection.add("e", this.textTemplates.getInstanceOf("prologue"));

		for (final var classSymbol : SymbolTable.getGlobals().getClasses().values()) {
			if (List.of(Utils.OBJECT, Utils.IO, Utils.INT, Utils.STRING, Utils.BOOL).contains(classSymbol.getName())) {
				textSection.add("e", this.textTemplates.getInstanceOf("initObject")
						.add("objectLabel", createInitLabel(classSymbol.getName()))
						.add("parentInitLabel", classSymbol.getParent() == null ? null
								: createInitLabel(classSymbol.getParent().getName()))
						.add("stackSize", 12));
			}

			classSymbol.computeFieldsOffsets();
		}
		astRoot.accept(new NTVisitor());
		textSection.add("e", astRoot.accept(new MIPSGenVisitor(this)));

		return textSection;
	}

	public ST generateDataSection() {
		final ST dataSection = this.programTemplates.getInstanceOf("sequence");

		dataSection.add("e", this.dataTemplates.getInstanceOf("prologue"));

		final ST classNamesTable = this.programTemplates.getInstanceOf("sequence");
		final ST classObjTable = this.programTemplates.getInstanceOf("sequence");

		for (final var classSymbol : SymbolTable.getGlobals().getClasses().values()) {
			this.classTags.put(classSymbol.getName(), this.classTags.size());
			if (List.of(Utils.INT, Utils.STRING, Utils.BOOL).contains(classSymbol.getName())) {
				dataSection.add("e",
						this.dataTemplates.getInstanceOf("classTag")
								.add("name", classSymbol.getName().toLowerCase())
								.add("tag", this.classTags.get(classSymbol.getName())));
			}
			classNamesTable
					.add("e", this.dataTemplates.getInstanceOf("word").add("value",
							this.getStringLabel(classSymbol.getName())));
			classObjTable
					.add("e", this.dataTemplates.getInstanceOf("word").add("value",
							createProtObjLabel(classSymbol.getName())))
					.add("e", this.dataTemplates.getInstanceOf("word").add("value",
							createInitLabel(classSymbol.getName())));
		}

		dataSection.add("e",
				this.dataTemplates.getInstanceOf("classNamesTable").add("classNamesTable", classNamesTable));
		dataSection.add("e", this.dataTemplates.getInstanceOf("classObjTable").add("classObjTable", classObjTable));

		this.generateStringConsts(dataSection);
		this.generateIntConsts(dataSection);
		this.generateBoolConsts(dataSection);
		this.generateProtoObjects(dataSection);
		this.generateDispatchTables(dataSection);

		return dataSection;
	}

	private void generateProtoObjects(final ST dataSection) {
		for (final var classSymbol : SymbolTable.getGlobals().getClasses().values()) {

			final ST metadata = this.dataTemplates.getInstanceOf("metadata")
					.add("label", createProtObjLabel(classSymbol.getName()))
					.add("className", classSymbol.getName())
					.add("tag", this.classTags.get(classSymbol.getName()));

			final ST data = this.programTemplates.getInstanceOf("sequence");

			final Integer fieldsCount;
			if (Utils.STRING.equals(classSymbol.getName())) {
				fieldsCount = 2;
				data.add("e", this.dataTemplates.getInstanceOf("word")
						.add("value", this.getIntLabel(0)))
						.add("e", this.dataTemplates.getInstanceOf("ascii")
								.add("value", ""));
			} else if (List.of(Utils.INT, Utils.BOOL).contains(classSymbol.getName())) {
				fieldsCount = 1;
				data.add("e", this.dataTemplates.getInstanceOf("word")
						.add("value", 0));
			} else {
				final List<IdSymbol> fields = classSymbol.getFields();
				fieldsCount = fields.size();
				for (final IdSymbol field : fields) {
					data.add("e", this.dataTemplates.getInstanceOf("word")
							.add("value", switch (field.getValueType().getName()) {
								case Utils.INT -> this.getIntLabel(0);
								case Utils.STRING -> this.getStringLabel("");
								case Utils.BOOL -> this.getBoolLabel(false);
								default -> 0;
							}));
				}
			}

			metadata.add("size", 3 + fieldsCount);

			dataSection.add("e",
					this.dataTemplates.getInstanceOf("prototype").add("metadata", metadata).add("data",
							fieldsCount == 0 ? null : data));
		}

	}

	private void generateStringConsts(final ST dataSection) {
		for (final var entry : this.constStrings.entrySet()) {
			final String value = entry.getKey();
			final Integer index = entry.getValue();

			final ST metadata = this.dataTemplates.getInstanceOf("metadata")
					.add("label", createConstLabel(Utils.STRING, index))
					.add("className", Utils.STRING)
					.add("tag", this.classTags.get(Utils.STRING))
					.add("size", 5 + value.length() / 4);

			final ST data = this.programTemplates.getInstanceOf("sequence")
					.add("e", this.dataTemplates.getInstanceOf("word")
							.add("value", this.getIntLabel(value.length())))
					.add("e", this.dataTemplates.getInstanceOf("ascii")
							.add("value", value));

			final ST stringConst = this.dataTemplates.getInstanceOf("prototype")
					.add("metadata", metadata)
					.add("data", data);

			dataSection.add("e", stringConst);
		}
	}

	private void generateIntConsts(final ST dataSection) {
		for (final var entry : this.constInts.entrySet()) {
			final Integer value = entry.getKey();
			final Integer index = entry.getValue();

			final ST metadata = this.dataTemplates.getInstanceOf("metadata")
					.add("label", createConstLabel(Utils.INT, index))
					.add("className", Utils.INT)
					.add("tag", this.classTags.get(Utils.INT))
					.add("size", 4);

			final ST intConst = this.dataTemplates.getInstanceOf("prototype")
					.add("metadata", metadata)
					.add("data", this.dataTemplates.getInstanceOf("word")
							.add("value", value));

			dataSection.add("e", intConst);
		}
	}

	private void generateBoolConsts(final ST dataSection) {
		for (int i = 0; i < 2; i++) {
			final ST metadata = this.dataTemplates.getInstanceOf("metadata")
					.add("label", createConstLabel(Utils.BOOL, i))
					.add("className", Utils.BOOL)
					.add("tag", this.classTags.get(Utils.BOOL))
					.add("size", 4);

			final ST boolConst = this.dataTemplates.getInstanceOf("prototype")
					.add("metadata", metadata)
					.add("data", this.dataTemplates.getInstanceOf("word")
							.add("value", i));

			dataSection.add("e", boolConst);
		}
	}

	private void generateDispatchTables(final ST dataSection) {
		for (final var entry : this.disptachTables.entrySet()) {
			final String name = entry.getKey();
			final List<MethodSymbol> dispatchTable = entry.getValue();

			final ST dispatchTableContent = this.programTemplates.getInstanceOf("sequence");

			for (final MethodSymbol method : dispatchTable) {
				dispatchTableContent.add("e", this.dataTemplates.getInstanceOf("word")
						.add("value", method.getClassSymbol().getName() + "." + method.getName()));
			}

			dataSection.add("e", this.dataTemplates.getInstanceOf("classDispTable")
					.add("label", createDispatchTableLabel(name))
					.add("classDispTable", dispatchTableContent));
		}
	}

	public Integer getMethodOffset(final MethodSymbol method) {
		return this.disptachTables.get(method.getClassSymbol().getName()).indexOf(method) * 4;
	}

	public ST getProgramTemplate(final String name) {
		return this.programTemplates.getInstanceOf(name);
	}

	public ST getTextTemplate(final String name) {
		return this.textTemplates.getInstanceOf(name);
	}

	public String getStringLabel(final String str) {
		return "string_const" + this.constStrings.computeIfAbsent(str, k -> this.constStrings.size());
	}

	public String getIntLabel(final Integer i) {
		return "int_const" + this.constInts.computeIfAbsent(i, k -> this.constInts.size());
	}

	public String getBoolLabel(final Boolean b) {
		return "bool_const" + (b ? "1" : "0");
	}

	public static String createConstLabel(final String type, final int index) {
		return type.toLowerCase() + "_const" + index;
	}

	public static String createProtObjLabel(final String className) {
		return className + "_protObj";
	}

	public static String createInitLabel(final String className) {
		return className + "_init";
	}

	public static String createDispatchTableLabel(final String className) {
		return className + "_dispTable";
	}

	public static String createMethodLabel(final MethodSymbol method) {
		return method.getClassSymbol().getName() + "." + method.getName();
	}
}
