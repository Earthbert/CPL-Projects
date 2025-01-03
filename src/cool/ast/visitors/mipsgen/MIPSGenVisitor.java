package cool.ast.visitors.mipsgen;

import java.io.File;

import org.stringtemplate.v4.ST;

import cool.ast.ASTVisitor;
import cool.ast.nodes.*;
import cool.compiler.Compiler;
import cool.mipsgen.CustomSTValue;
import cool.mipsgen.MIPSGen;
import cool.mipsgen.TemplatesStrings.P;
import cool.mipsgen.TemplatesStrings.T;
import cool.semantic.symbol.ClassSymbol;
import cool.semantic.symbol.IDSymbolType;
import cool.semantic.symbol.IdSymbol;
import cool.utils.Utils;

public class MIPSGenVisitor implements ASTVisitor<ST> {

	private final MIPSGen mipsGen;

	private String fileName;

	private ClassSymbol currentClass;
	private String labelPrefix;

	private Integer offset = 0;

	private Integer labelCounter = 0;

	public MIPSGenVisitor(final MIPSGen mipsGen) {
		this.mipsGen = mipsGen;
	}

	@Override
	public ST visit(final ASTRoot astRoot) {
		final ST compiledSequence = this.mipsGen.getProgramTemplate(P.SEQUENCE);

		astRoot.getClasses().forEach(astClass -> compiledSequence.add(P.E, astClass.accept(this)));

		return compiledSequence;
	}

	@Override
	public ST visit(final ASTClass astClass) {

		this.fileName = new File(Compiler.fileNames.get(astClass.getCtx())).getName();
		this.currentClass = astClass.getSymbol().orElseThrow();

		this.labelPrefix = MIPSGen.createInitLabel(this.currentClass.getName());
		this.labelCounter = 0;
		this.offset = this.currentClass.getInitLocals();

		final ST objectInit = this.mipsGen.getTextTemplate(T.INIT_OBJECT)
				.add(T.OBJECT_LABEL, MIPSGen.createInitLabel(this.currentClass.getName()))
				.add(T.PARENT_INIT_LABEL, this.currentClass.getParent() == null ? null
						: MIPSGen.createInitLabel(this.currentClass.getParent().getName()))
				.add(T.STACK_SIZE,
						new CustomSTValue(String
								.valueOf(this.currentClass.getInitLocals() + this.currentClass.getInitTempLocations())))
				.add(T.FIELDS_INIT, astClass.getFeatures().stream().filter(ASTField.class::isInstance)
						.map(feature -> feature.accept(this)).reduce(this.mipsGen.getProgramTemplate(P.SEQUENCE),
								(accumulated, current) -> accumulated.add(P.E, current)));

		final ST methods = astClass.getFeatures().stream().anyMatch(ASTMethod.class::isInstance)
				? astClass.getFeatures().stream().filter(ASTMethod.class::isInstance)
						.map(feature -> feature.accept(this)).reduce(this.mipsGen.getProgramTemplate(P.SEQUENCE),
								(accumulated, current) -> accumulated.add(P.E, current))
				: null;

		return this.mipsGen.getProgramTemplate(P.SEQUENCE).add(P.E, objectInit).add(P.E, methods);
	}

	@Override
	public ST visit(final ASTMethod astMethod) {

		final var methodSymbol = astMethod.getSymbol().orElseThrow();
		this.labelPrefix = MIPSGen.createMethodLabel(methodSymbol);
		this.labelCounter = 0;
		this.offset = methodSymbol.getLocals();

		final ST method = this.mipsGen.getTextTemplate(T.METHOD_DEFINITION)
				.add(T.METHOD_LABEL, MIPSGen.createMethodLabel(methodSymbol))
				.add(T.STACK_SIZE, new CustomSTValue(String.valueOf(methodSymbol.getLocals() + methodSymbol.getTempLocations())))
				.add(T.METHOD_BODY, astMethod.getBody().accept(this))
				.add(T.PARAMS_SIZE, new CustomSTValue(String.valueOf(astMethod.getArguments().size() * 4)));

		return method;
	}

	@Override
	public ST visit(final ASTField astField) {

		if (astField.getDef().getExpr().isPresent())
			return this.mipsGen.getProgramTemplate(P.SEQUENCE)
					.add(P.E, astField.getDef().getExpr().get().accept(this))
					.add(P.E, this.mipsGen.getTextTemplate(T.STORE_FIELD).add(T.OFFSET,
							astField.getSymbol().orElseThrow().getOffset() + 12));

		return this.mipsGen.getProgramTemplate(P.SEQUENCE);
	}

	@Override
	public ST visit(final ASTCall astCall) {

		final ST params = this.mipsGen.getProgramTemplate(P.SEQUENCE);
		params.add(P.E, this.mipsGen.getTextTemplate(T.RESERVE_STACK).add(T.SIZE, astCall.getArguments().size() * 4));

		for (int i = 0; i < astCall.getArguments().size(); i++) {
			final var arg = astCall.getArguments().get(i);
			params.add(P.E, arg.accept(this));
			params.add(P.E, this.mipsGen.getTextTemplate(T.STORE_STACK).add(T.OFFSET, 4 + i * 4));
		}

		return this.mipsGen.getTextTemplate(T.METHOD_CALL)
				.add(T.PARAMS, astCall.getArguments().isEmpty() ? null : params)
				.add(T.DISPATCH_LABEL, this.createDispatchLabel())
				.add(T.FILE_NAME_LABEL, this.mipsGen.getStringLabel(this.fileName))
				.add(T.LINE, astCall.getToken().getLine())
				.add(T.METHOD_OFFSET, this.mipsGen.getMethodOffset(astCall.getSymbol().orElseThrow()))
				.add(T.STATIC_TYPE, astCall.getStaticDispatchType().map(type -> type.getToken().getText()).orElse(null))
				.add(T.SUBJECT, astCall.getSubject().map(subject -> subject.accept(this))
						.orElse(this.mipsGen.getTextTemplate(T.EVALUATE_SELF)));
	}

	@Override
	public ST visit(final ASTNew astNew) {
		return Utils.SELF_TYPE.equals(astNew.getType().getToken().getText()) ? this.mipsGen.getTextTemplate(T.NEW_SELF)
				: this.mipsGen.getTextTemplate(T.NEW).add(T.CLASS_NAME, astNew.getType().getToken().getText());
	}

	@Override
	public ST visit(final ASTLet astLet) {

		final ST initValue = astLet.getDef().getExpr().map(expr -> expr.accept(this))
				.orElse(switch (astLet.getDef().getId().getSymbol().getValueType().getName()) {
					case Utils.STRING -> this.mipsGen.getTextTemplate(T.LOAD_ADDRESS)
							.add(T.ADDRESS, this.mipsGen.getStringLabel(""));
					case Utils.INT -> this.mipsGen.getTextTemplate(T.LOAD_ADDRESS)
							.add(T.ADDRESS, this.mipsGen.getIntLabel(0));
					case Utils.BOOL -> this.mipsGen.getTextTemplate(T.LOAD_ADDRESS)
							.add(T.ADDRESS, this.mipsGen.getBoolLabel(false));
					default -> this.mipsGen.getTextTemplate(T.LOAD_IMMEDIATE).add(T.VALUE, 0);
				});

		return this.mipsGen.getTextTemplate(T.LET)
				.add(T.INIT_EXPR, initValue)
				.add(T.OFFSET, astLet.getDef().getId().getSymbol().getOffset())
				.add(T.EXPR, astLet.getExpr().accept(this));
	}

	@Override
	public ST visit(final ASTBlock astBlock) {
		return astBlock.getExpressions().stream().map(expr -> expr.accept(this))
				.reduce(this.mipsGen.getProgramTemplate(P.SEQUENCE),
						(accumulated, current) -> accumulated.add(P.E, current));
	}

	@Override
	public ST visit(final ASTId astId) {
		if (Utils.SELF.equals(astId.getSymbol().getName()))
			return this.mipsGen.getTextTemplate(T.EVALUATE_SELF);

		return switch (astId.getSymbol().getType()) {
			case FIELD -> this.mipsGen.getTextTemplate(T.LOAD_FIELD).add(T.OFFSET, astId.getSymbol().getOffset() + 12);
			case FORMAL ->
				this.mipsGen.getTextTemplate(T.LOAD_FORMAL).add(T.OFFSET, astId.getSymbol().getOffset() + 12);
			case LOCAL -> this.mipsGen.getTextTemplate(T.LOAD_LOCAL).add(T.OFFSET, astId.getSymbol().getOffset());
		};
	}

	@Override
	public ST visit(final ASTIf astIf) {
		return this.mipsGen.getTextTemplate(T.IF)
				.add(T.CONDITION, astIf.getCondition().accept(this))
				.add(T.THEN_BRANCH, astIf.getThenBranch().accept(this))
				.add(T.ELSE_BRANCH, astIf.getElseBranch().accept(this))
				.add(T.ELSE_LABEL, this.createElseLabel())
				.add(T.END_LABEL, this.createEndLabel());
	}

	@Override
	public ST visit(final ASTArithmetic astArithmetic) {

		final var st = this.mipsGen.getTextTemplate(T.BINARY_ARITHM_OP);

		final ST left = astArithmetic.getLeft().accept(this);
		this.offset += 4;
		final ST right = astArithmetic.getRight().accept(this);
		this.offset -= 4;

		return st.add(T.OFFSET, this.offset + 4)
				.add(T.LEFT, left)
				.add(T.RIGHT, right)
				.add(T.OP, new CustomSTValue(astArithmetic.getToken().getText()));
	}

	@Override
	public ST visit(final ASTNeg astNeg) {
		return this.mipsGen.getTextTemplate(T.NEG)
				.add(T.EXPR, astNeg.getExpression().accept(this));
	}

	@Override
	public ST visit(final ASTComparison astComparison) {
		return null;
	}

	@Override
	public ST visit(final ASTAssignment astAssignment) {
		final IdSymbol symbol = astAssignment.getId().getSymbol();

		final ST storeID = switch (symbol.getType()) {
			case IDSymbolType.FIELD ->
				this.mipsGen.getTextTemplate(T.STORE_FIELD).add(T.OFFSET, symbol.getOffset() + 12);
			case IDSymbolType.FORMAL ->
				this.mipsGen.getTextTemplate(T.STORE_FORMAL).add(T.OFFSET, symbol.getOffset() + 12);
			case IDSymbolType.LOCAL -> this.mipsGen.getTextTemplate(T.STORE_LOCAL).add(T.OFFSET, symbol.getOffset());
		};

		return this.mipsGen.getProgramTemplate(P.SEQUENCE)
				.add(P.E, astAssignment.getExpr().accept(this))
				.add(P.E, storeID);
	}

	@Override
	public ST visit(final ASTIsVoid astIsVoid) {
		return this.mipsGen.getTextTemplate(T.ISVOID)
				.add(T.EXPR, astIsVoid.getExpression().accept(this))
				.add(T.TRUE_LABEL, this.mipsGen.getBoolLabel(true))
				.add(T.FALSE_LABEL, this.mipsGen.getBoolLabel(false))
				.add(T.END_LABEL, this.createIsVoidLabel());
	}

	@Override
	public ST visit(final ASTNot astNot) {
		return this.mipsGen.getTextTemplate(T.NOT)
				.add(T.EXPR, astNot.getExpression().accept(this))
				.add(T.TRUE_LABEL, this.mipsGen.getBoolLabel(true))
				.add(T.FALSE_LABEL, this.mipsGen.getBoolLabel(false))
				.add(T.END_LABEL, this.createNotLabel());
	}

	@Override
	public ST visit(final ASTInteger node) {
		return this.mipsGen.getTextTemplate(T.LOAD_ADDRESS)
				.add(T.ADDRESS, this.mipsGen.getIntLabel(node.getValue()));
	}

	@Override
	public ST visit(final ASTString node) {
		return this.mipsGen.getTextTemplate(T.LOAD_ADDRESS)
				.add(T.ADDRESS, this.mipsGen.getStringLabel(node.getValue()));
	}

	@Override
	public ST visit(final ASTBoolean node) {
		return this.mipsGen.getTextTemplate(T.LOAD_ADDRESS)
				.add(T.ADDRESS, this.mipsGen.getBoolLabel(node.getValue()));
	}

	private String createDispatchLabel() {
		return this.labelPrefix + "_dispatch_" + this.labelCounter++;
	}

	private String createElseLabel() {
		return this.labelPrefix + "_else_" + this.labelCounter++;
	}

	private String createEndLabel() {
		return this.labelPrefix + "_endif_" + this.labelCounter++;
	}

	private String createIsVoidLabel() {
		return this.labelPrefix + "_endIsVoid_" + this.labelCounter++;
	}

	private String createNotLabel() {
		return this.labelPrefix + "_endNot_" + this.labelCounter++;
	}
}
