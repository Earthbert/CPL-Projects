package cool.ast.visitors.mipsgen;

import org.stringtemplate.v4.ST;

import cool.ast.ASTVisitor;
import cool.ast.nodes.ASTClass;
import cool.ast.nodes.ASTField;
import cool.ast.nodes.ASTInteger;
import cool.ast.nodes.ASTMethod;
import cool.ast.nodes.ASTRoot;
import cool.mipsgen.MIPSGen;
import cool.semantic.symbol.ClassSymbol;
import cool.semantic.symbol.MethodSymbol;

public class MIPSGenVisitor implements ASTVisitor<ST> {

	private final MIPSGen mipsGen;

	public MIPSGenVisitor(final MIPSGen mipsGen) {
		this.mipsGen = mipsGen;
	}

	@Override
	public ST visit(final ASTRoot astRoot) {
		final ST compiledSequence = this.mipsGen.getProgramTemplate("sequence");

		astRoot.getClasses().forEach(astClass -> compiledSequence.add("e", astClass.accept(this)));

		return compiledSequence;
	}

	@Override
	public ST visit(final ASTClass astClass) {

		final ClassSymbol classSymbol = astClass.getSymbol().orElseThrow();

		final ST objectInit = this.mipsGen.getTextTemplate("initObject");
		objectInit.add("objectLabel", MIPSGen.createInitLabel(classSymbol.getName()));
		objectInit.add("parentInitLabel", classSymbol.getParent() == null ? null
				: MIPSGen.createInitLabel(classSymbol.getParent().getName()));
		objectInit.add("stackSize", 12);
		objectInit.add("fieldsInit", astClass.getFeatures().stream().filter(ASTField.class::isInstance)
				.map(feature -> feature.accept(this)).reduce(this.mipsGen.getProgramTemplate("sequence"),
						(accumulated, current) -> accumulated.add("e", current)));

		final ST methods = astClass.getFeatures().stream().anyMatch(ASTMethod.class::isInstance)
				? astClass.getFeatures().stream().filter(ASTMethod.class::isInstance)
						.map(feature -> feature.accept(this)).reduce(this.mipsGen.getProgramTemplate("sequence"),
								(accumulated, current) -> accumulated.add("e", current))
				: null;

		return this.mipsGen.getProgramTemplate("sequence").add("e", objectInit).add("e", methods);
	}

	@Override
	public ST visit(final ASTMethod astMethod) {

		final MethodSymbol methodSymbol = astMethod.getSymbol().orElseThrow();

		final ST method = this.mipsGen.getTextTemplate("methodDefinition")
				.add("methodLabel", MIPSGen.createMethodLabel(methodSymbol))
				.add("stackSize", 12)
				.add("methodBody", astMethod.getBody().accept(this));

		return method;
	}

	@Override
	public ST visit(final ASTField astField) {
		return this.mipsGen.getProgramTemplate("sequence");
	}

	@Override
	public ST visit(final ASTInteger node) {
		return this.mipsGen.getTextTemplate("loadAddress")
				.add("address", this.mipsGen.getIntLabel(node.getValue()));
	}
}
