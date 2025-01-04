package cool.mipsgen;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import cool.ast.nodes.ASTNode;
import cool.ast.visitors.mipsgen.MIPSGenVisitor;
import cool.ast.visitors.mipsgen.NTVisitor;
import cool.mipsgen.TemplatesStrings.D;
import cool.mipsgen.TemplatesStrings.P;
import cool.mipsgen.TemplatesStrings.T;
import cool.semantic.symbol.IdSymbol;
import cool.semantic.symbol.MethodSymbol;
import cool.semantic.symbol.SymbolTable;
import cool.utils.Utils;

public class MIPSGen {

	private final Map<String, List<MethodSymbol>> disptachTables = new LinkedHashMap<>();

	private final Map<String, Integer> classTags = new LinkedHashMap<>();

	private final Map<String, Integer> constStrings = new LinkedHashMap<>();
	private final Map<Integer, Integer> constInts = new LinkedHashMap<>();

	private final STGroupFile programTemplates = new STGroupFile(this.getClass().getResource("templates/program.stg").getPath());
	private final STGroupFile dataTemplates = new STGroupFile(this.getClass().getResource("templates/data.stg").getPath());
	private final STGroupFile textTemplates = new STGroupFile(this.getClass().getResource("templates/text.stg").getPath());

	public ST generateProgram(final ASTNode astRoot) {
		final var program = this.programTemplates.getInstanceOf(P.PROGRAM);

		this.getStringLabel("");
		for (final var classSymbol : SymbolTable.getGlobals().getClasses().values()) {
			this.getStringLabel(classSymbol.getName());
			this.disptachTables.put(classSymbol.getName(), classSymbol.getDispatchTable());
		}

		program.add(P.TEXT, this.generateTextSection(astRoot));
		program.add(P.DATA, this.generateDataSection());

		return program;
	}

	public ST generateTextSection(final ASTNode astRoot) {
		final ST textSection = this.programTemplates.getInstanceOf(P.SEQUENCE);

		textSection.add(P.E, this.textTemplates.getInstanceOf(T.PROLOGUE));

		for (final var classSymbol : SymbolTable.getGlobals().getClasses().values()) {
			if (List.of(Utils.OBJECT, Utils.IO, Utils.INT, Utils.STRING, Utils.BOOL).contains(classSymbol.getName())) {
				textSection.add(P.E, this.textTemplates.getInstanceOf(T.INIT_OBJECT)
						.add(T.OBJECT_LABEL, createInitLabel(classSymbol.getName()))
						.add(T.PARENT_INIT_LABEL, classSymbol.getParent() == null ? null
								: createInitLabel(classSymbol.getParent().getName()))
						.add(T.STACK_SIZE, new CustomSTValue("0")));
			}

			classSymbol.computeFieldsOffsets();
		}
		astRoot.accept(new NTVisitor());
		textSection.add(P.E, astRoot.accept(new MIPSGenVisitor(this)));

		return textSection;
	}

	public ST generateDataSection() {
		final ST dataSection = this.programTemplates.getInstanceOf(P.SEQUENCE);

		dataSection.add(P.E, this.dataTemplates.getInstanceOf(D.PROLOGUE));

		final ST classNamesTable = this.programTemplates.getInstanceOf(P.SEQUENCE);
		final ST classObjTable = this.programTemplates.getInstanceOf(P.SEQUENCE);

		for (final var classSymbol : SymbolTable.getGlobals().getClasses().values()) {
			this.classTags.put(classSymbol.getName(), this.classTags.size());
			if (List.of(Utils.INT, Utils.STRING, Utils.BOOL).contains(classSymbol.getName())) {
				dataSection.add(P.E,
						this.dataTemplates.getInstanceOf(D.CLASS_TAG)
								.add(D.NAME, classSymbol.getName().toLowerCase())
								.add(D.TAG, this.classTags.get(classSymbol.getName())));
			}
			classNamesTable
					.add(P.E, this.dataTemplates.getInstanceOf(D.WORD).add(D.VALUE,
							this.getStringLabel(classSymbol.getName())));
			classObjTable
					.add(P.E, this.dataTemplates.getInstanceOf(D.WORD).add(D.VALUE,
							createProtObjLabel(classSymbol.getName())))
					.add(P.E, this.dataTemplates.getInstanceOf(D.WORD).add(D.VALUE,
							createInitLabel(classSymbol.getName())));
		}

		dataSection.add(P.E,
				this.dataTemplates.getInstanceOf(D.CLASS_NAMES_TABLE).add(D.CLASS_NAMES_TABLE, classNamesTable));
		dataSection.add(P.E, this.dataTemplates.getInstanceOf(D.CLASS_OBJ_TABLE).add(D.CLASS_OBJ_TABLE, classObjTable));

		this.generateStringConsts(dataSection);
		this.generateIntConsts(dataSection);
		this.generateBoolConsts(dataSection);
		this.generateProtoObjects(dataSection);
		this.generateDispatchTables(dataSection);

		return dataSection;
	}

	private void generateProtoObjects(final ST dataSection) {
		for (final var classSymbol : SymbolTable.getGlobals().getClasses().values()) {

			final ST metadata = this.dataTemplates.getInstanceOf(D.METADATA)
					.add(D.LABEL, createProtObjLabel(classSymbol.getName()))
					.add(D.CLASS_NAME, classSymbol.getName())
					.add(D.TAG, this.classTags.get(classSymbol.getName()));

			final ST data = this.programTemplates.getInstanceOf(P.SEQUENCE);

			final Integer fieldsCount;
			if (Utils.STRING.equals(classSymbol.getName())) {
				fieldsCount = 2;
				data.add(P.E, this.dataTemplates.getInstanceOf(D.WORD)
						.add(D.VALUE, this.getIntLabel(0)))
						.add(P.E, this.dataTemplates.getInstanceOf(D.ASCII)
								.add(D.VALUE, ""));
			} else if (List.of(Utils.INT, Utils.BOOL).contains(classSymbol.getName())) {
				fieldsCount = 1;
				data.add(P.E, this.dataTemplates.getInstanceOf(D.WORD)
						.add(D.VALUE, 0));
			} else {
				final List<IdSymbol> fields = classSymbol.getFields();
				fieldsCount = fields.size();
				for (final IdSymbol field : fields) {
					data.add(P.E, this.dataTemplates.getInstanceOf(D.WORD)
							.add(D.VALUE, switch (field.getValueType().getName()) {
								case Utils.INT -> this.getIntLabel(0);
								case Utils.STRING -> this.getStringLabel("");
								case Utils.BOOL -> this.getBoolLabel(false);
								default -> 0;
							}));
				}
			}

			metadata.add(D.SIZE, 3 + fieldsCount);

			dataSection.add(P.E,
					this.dataTemplates.getInstanceOf(D.PROTOTYPE).add(D.METADATA, metadata).add(D.DATA,
							fieldsCount == 0 ? null : data));
		}

	}

	private void generateStringConsts(final ST dataSection) {
		for (final var entry : this.constStrings.entrySet()) {
			final String value = entry.getKey();
			final Integer index = entry.getValue();

			final ST metadata = this.dataTemplates.getInstanceOf(D.METADATA)
					.add(D.LABEL, createConstLabel(Utils.STRING, index))
					.add(D.CLASS_NAME, Utils.STRING)
					.add(D.TAG, this.classTags.get(Utils.STRING))
					.add(D.SIZE, 5 + value.length() / 4);

			final ST data = this.programTemplates.getInstanceOf(P.SEQUENCE)
					.add(P.E, this.dataTemplates.getInstanceOf(D.WORD)
							.add(D.VALUE, this.getIntLabel(value.length())))
					.add(P.E, this.dataTemplates.getInstanceOf(D.ASCII)
							.add(D.VALUE, value));

			final ST stringConst = this.dataTemplates.getInstanceOf(D.PROTOTYPE)
					.add(D.METADATA, metadata)
					.add(D.DATA, data);

			dataSection.add(P.E, stringConst);
		}
	}

	private void generateIntConsts(final ST dataSection) {
		for (final var entry : this.constInts.entrySet()) {
			final Integer value = entry.getKey();
			final Integer index = entry.getValue();

			final ST metadata = this.dataTemplates.getInstanceOf(D.METADATA)
					.add(D.LABEL, createConstLabel(Utils.INT, index))
					.add(D.CLASS_NAME, Utils.INT)
					.add(D.TAG, this.classTags.get(Utils.INT))
					.add(D.SIZE, 4);

			final ST intConst = this.dataTemplates.getInstanceOf(D.PROTOTYPE)
					.add(D.METADATA, metadata)
					.add(D.DATA, this.dataTemplates.getInstanceOf(D.WORD)
							.add(D.VALUE, value));

			dataSection.add(P.E, intConst);
		}
	}

	private void generateBoolConsts(final ST dataSection) {
		for (int i = 0; i < 2; i++) {
			final ST metadata = this.dataTemplates.getInstanceOf(D.METADATA)
					.add(D.LABEL, createConstLabel(Utils.BOOL, i))
					.add(D.CLASS_NAME, Utils.BOOL)
					.add(D.TAG, this.classTags.get(Utils.BOOL))
					.add(D.SIZE, 4);

			final ST boolConst = this.dataTemplates.getInstanceOf(D.PROTOTYPE)
					.add(D.METADATA, metadata)
					.add(D.DATA, this.dataTemplates.getInstanceOf(D.WORD)
							.add(D.VALUE, i));

			dataSection.add(P.E, boolConst);
		}
	}

	private void generateDispatchTables(final ST dataSection) {
		for (final var entry : this.disptachTables.entrySet()) {
			final String name = entry.getKey();
			final List<MethodSymbol> dispatchTable = entry.getValue();

			final ST dispatchTableContent = this.programTemplates.getInstanceOf(P.SEQUENCE);

			for (final MethodSymbol method : dispatchTable) {
				dispatchTableContent.add(P.E, this.dataTemplates.getInstanceOf(D.WORD)
						.add(D.VALUE, method.getClassSymbol().getName() + "." + method.getName()));
			}

			dataSection.add(P.E, this.dataTemplates.getInstanceOf(D.CLASS_DISP_TABLE)
					.add(D.LABEL, createDispatchTableLabel(name))
					.add(D.CLASS_DISP_TABLE, dispatchTableContent));
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
