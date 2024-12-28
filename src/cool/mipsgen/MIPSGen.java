package cool.mipsgen;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import cool.ast.nodes.ASTNode;
import cool.semantic.symbol.SymbolTable;
import cool.utils.Utils;

public class MIPSGen {

	Map<String, Integer> classTags = new LinkedHashMap<>();

	Map<String, Integer> constStrings = new LinkedHashMap<>();
	Map<Integer, Integer> constInts = new LinkedHashMap<>();

	STGroupFile programTemplates = new STGroupFile(Utils.stTemplatesPath + "/program.stg");
	STGroupFile dataTemplates = new STGroupFile(Utils.stTemplatesPath + "/data.stg");

	public ST generateProgram(final ASTNode root) {
		final var program = this.programTemplates.getInstanceOf("program");

		for (final var classSymbol : SymbolTable.getGlobals().getClasses().values()) {
			this.getStringLabel(classSymbol.getName());
		}

		program.add("data", this.generateDataSection());
		return program;
	}

	public ST generateDataSection() {
		final var dataSection = this.programTemplates.getInstanceOf("sequence");

		dataSection.add("e", this.dataTemplates.getInstanceOf("prologue"));

		final ST classNamesTable = this.dataTemplates.getInstanceOf("classNamesTable");

		for (final var classSymbol : SymbolTable.getGlobals().getClasses().values()) {
			this.classTags.put(classSymbol.getName(), this.classTags.size());
			if (List.of(Utils.INT, Utils.STRING, Utils.BOOL).contains(classSymbol.getName())) {
				dataSection.add("e",
						this.dataTemplates.getInstanceOf("classTag")
								.add("name", classSymbol.getName().toLowerCase())
								.add("tag", this.classTags.get(classSymbol.getName())));
			}
			classNamesTable.add("classNameLabel", this.getStringLabel(classSymbol.getName()));
		}

		this.generateStringConsts(dataSection);
		this.generateIntConsts(dataSection);
		this.generateBoolConsts(dataSection);
		this.generateProtoObjects(dataSection);

		dataSection.add("e", classNamesTable);

		return dataSection;
	}

	private void generateProtoObjects(final ST dataSection) {
		for (final var classSymbol : SymbolTable.getGlobals().getClasses().values()) {
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

			final ST stringConst = this.dataTemplates.getInstanceOf("string")
					.add("metadata", metadata)
					.add("length", this.getIntLabel(value.length()))
					.add("value", value);

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

			final ST intConst = this.dataTemplates.getInstanceOf("int")
					.add("metadata", metadata)
					.add("value", value);

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

			final ST boolConst = this.dataTemplates.getInstanceOf("int")
					.add("metadata", metadata)
					.add("value", i);

			dataSection.add("e", boolConst);
		}
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

	private static String createConstLabel(final String type, final int index) {
		return type.toLowerCase() + "_const" + index;
	}

	private static String createProtObjLabel(final String className) {
		return className.toLowerCase() + "_protObj";
	}
}
