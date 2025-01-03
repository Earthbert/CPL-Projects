package cool.ast.visitors.mipsgen;

import java.io.File;

import org.stringtemplate.v4.ST;

import cool.ast.ASTVisitor;
import cool.ast.nodes.*;
import cool.compiler.Compiler;
import cool.mipsgen.MIPSGen;
import cool.semantic.symbol.ClassSymbol;
import cool.semantic.symbol.IDSymbolType;
import cool.semantic.symbol.IdSymbol;
import cool.semantic.symbol.MethodSymbol;
import cool.utils.Utils;

public class MIPSGenVisitor implements ASTVisitor<ST> {

	private final MIPSGen mipsGen;

	private ASTClass currentClassNode;

	private ClassSymbol currentClass;
	private MethodSymbol currentMethod;

	private Integer dispatchCounter = 0;

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

		this.currentClassNode = astClass;
		this.currentClass = astClass.getSymbol().orElseThrow();

		final ST objectInit = this.mipsGen.getTextTemplate("initObject");
		objectInit.add("objectLabel", MIPSGen.createInitLabel(this.currentClass.getName()));
		objectInit.add("parentInitLabel", this.currentClass.getParent() == null ? null
				: MIPSGen.createInitLabel(this.currentClass.getParent().getName()));
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

		this.currentMethod = astMethod.getSymbol().orElseThrow();
		this.dispatchCounter = 0;

		final ST method = this.mipsGen.getTextTemplate("methodDefinition")
				.add("methodLabel", MIPSGen.createMethodLabel(this.currentMethod))
				.add("stackSize", 12)
				.add("methodBody", astMethod.getBody().accept(this))
				.add("paramsSize", astMethod.getArguments().size() > 0 ? astMethod.getArguments().size() * 4 : null);

		return method;
	}

	@Override
	public ST visit(final ASTField astField) {

		if (astField.getDef().getExpr().isPresent())
			return this.mipsGen.getProgramTemplate("sequence")
					.add("e", astField.getDef().getExpr().get().accept(this))
					.add("e", this.mipsGen.getTextTemplate("storeField").add("offset",
							astField.getSymbol().orElseThrow().getOffset() + 12));

		return this.mipsGen.getProgramTemplate("sequence");
	}

	@Override
	public ST visit(final ASTCall astCall) {

		final ST params = this.mipsGen.getProgramTemplate("sequence");
		params.add("e", this.mipsGen.getTextTemplate("reserveStack").add("size", astCall.getArguments().size() * 4));

		for (int i = 0; i < astCall.getArguments().size(); i++) {
			final var arg = astCall.getArguments().get(i);
			params.add("e", arg.accept(this));
			params.add("e", this.mipsGen.getTextTemplate("storeStack").add("offset", 4 + i * 4));
		}

		return this.mipsGen.getTextTemplate("methodCall")
				.add("params", astCall.getArguments().isEmpty() ? null : params)
				.add("methodLabel", MIPSGen.createMethodLabel(astCall.getSymbol().orElseThrow()))
				.add("dispatchLabel", this.computeDispatchLabel())
				.add("fileNameLabel",
						this.mipsGen.getStringLabel(
								new File(Compiler.fileNames.get(this.currentClassNode.getCtx())).getName()))
				.add("line", astCall.getToken().getLine())
				.add("methodOffset", this.mipsGen.getMethodOffset(astCall.getSymbol().orElseThrow()))
				.add("subject", astCall.getSubject().map(subject -> subject.accept(this))
						.orElse(this.mipsGen.getTextTemplate("evaluateSelf")));
	}

	@Override
	public ST visit(final ASTBlock astBlock) {
		return astBlock.getExpressions().stream().map(expr -> expr.accept(this))
				.reduce(this.mipsGen.getProgramTemplate("sequence"),
						(accumulated, current) -> accumulated.add("e", current));
	}

	@Override
	public ST visit(final ASTId astId) {
		if (Utils.SELF.equals(astId.getSymbol().getName()))
			return this.mipsGen.getTextTemplate("evaluateSelf");

		return switch (astId.getSymbol().getType()) {
			case FIELD -> this.mipsGen.getTextTemplate("loadField").add("offset", astId.getSymbol().getOffset() + 12);
			case FORMAL -> this.mipsGen.getTextTemplate("loadFormal").add("offset", astId.getSymbol().getOffset() + 12);
			case LOCAL -> this.mipsGen.getTextTemplate("loadLocal").add("offset", astId.getSymbol().getOffset());
		};
	}

	@Override
	public ST visit(final ASTAssignment astAssignment) {
		final IdSymbol symbol = astAssignment.getId().getSymbol();

		final ST storeID = switch (symbol.getType()) {
			case IDSymbolType.FIELD ->
				this.mipsGen.getTextTemplate("storeField").add("offset", symbol.getOffset() + 12);
			case IDSymbolType.FORMAL ->
				this.mipsGen.getTextTemplate("storeFormal").add("offset", symbol.getOffset() + 12);
			case IDSymbolType.LOCAL -> this.mipsGen.getTextTemplate("storeLocal").add("offset", symbol.getOffset());
		};

		return this.mipsGen.getProgramTemplate("sequence")
				.add("e", astAssignment.getExpr().accept(this))
				.add("e", storeID);
	}

	@Override
	public ST visit(final ASTInteger node) {
		return this.mipsGen.getTextTemplate("loadAddress")
				.add("address", this.mipsGen.getIntLabel(node.getValue()));
	}

	@Override
	public ST visit(final ASTString node) {
		return this.mipsGen.getTextTemplate("loadAddress")
				.add("address", this.mipsGen.getStringLabel(node.getValue()));
	}

	@Override
	public ST visit(final ASTBoolean node) {
		return this.mipsGen.getTextTemplate("loadAddress")
				.add("address", this.mipsGen.getBoolLabel(node.getValue()));
	}

	private String computeDispatchLabel() {
		return MIPSGen.createMethodLabel(this.currentMethod) + "_dispatch" + this.dispatchCounter++;
	}
}
