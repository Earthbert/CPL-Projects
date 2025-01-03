package cool.ast.visitors.mipsgen;

import cool.ast.ASTVisitor;
import cool.ast.nodes.*;
import cool.semantic.symbol.ClassSymbol;
import cool.semantic.symbol.MethodSymbol;
import cool.semantic.symbol.Symbol;

public class NTVisitor implements ASTVisitor<Integer> {

	private Integer letOffset = 0;
	private Symbol currentSymbol;

	@Override
	public Integer visit(final ASTRoot astRoot) {
		astRoot.getClasses().forEach(astClass -> astClass.accept(this));
		return 0;
	}

	@Override
	public Integer visit(final ASTClass astClass) {
		final ClassSymbol classSymbol = astClass.getSymbol().orElseThrow();

		this.currentSymbol = classSymbol;

		classSymbol.setInitTempLocations(astClass.getFeatures().stream().filter(ASTField.class::isInstance)
				.map(feature -> feature.accept(this)).max(Integer::compare).orElse(0));

		astClass.getFeatures().stream().filter(ASTMethod.class::isInstance).forEach(feature -> feature.accept(this));

		return 0;
	}

	@Override
	public Integer visit(final ASTMethod astMethod) {

		this.currentSymbol = astMethod.getSymbol().orElseThrow();

		for (int i = 0; i < astMethod.getArguments().size(); i++)
			astMethod.getArguments().get(i).getSymbol().orElseThrow().setOffset(i * 4);
		astMethod.getSymbol().orElseThrow().setTempLocations(astMethod.getBody().accept(this));
		return 0;
	}

	@Override
	public Integer visit(final ASTLet astLet) {

		final Integer init = astLet.getDef().getExpr().map(expr -> expr.accept(this)).orElse(0);

		this.letOffset += 4;
		astLet.getDef().getId().getSymbol().setOffset(this.letOffset);
		switch (this.currentSymbol) {
			case final ClassSymbol classSymbol ->
				classSymbol.setInitLocals(Math.max(classSymbol.getInitLocals(), this.letOffset));
			case final MethodSymbol methodSymbol ->
				methodSymbol.setLocals(Math.max(methodSymbol.getLocals(), this.letOffset));
			default ->
				throw new RuntimeException("Invalid symbol type: " + this.currentSymbol);
		}
		final Integer expr = astLet.getExpr().accept(this);

		this.letOffset -= 4;
		return Math.max(init, expr);
	}

	@Override
	public Integer visit(final ASTField astField) {
		return astField.getDef().getExpr().map(expr -> expr.accept(this)).orElse(0);
	}

	@Override
	public Integer visit(final ASTCall astCall) {
		return astCall.getArguments().stream().map(arg -> arg.accept(this)).max(Integer::compare).orElse(0);
	}

	@Override
	public Integer visit(final ASTBlock astBlock) {
		return astBlock.getExpressions().stream().map(expr -> expr.accept(this)).max(Integer::compare).orElse(0);
	}

	@Override
	public Integer visit(final ASTId astId) {
		return 0;
	}

	@Override
	public Integer visit(final ASTAssignment astAssignment) {
		return astAssignment.getExpr().accept(this);
	}

	@Override
	public Integer visit(final ASTString node) {
		return 0;
	}

	@Override
	public Integer visit(final ASTInteger node) {
		return 0;
	}

	@Override
	public Integer visit(final ASTBoolean node) {
		return 0;
	}
}
