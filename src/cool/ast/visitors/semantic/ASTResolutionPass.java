package cool.ast.visitors.semantic;

import java.util.List;
import java.util.Optional;

import cool.ast.nodes.*;
import cool.ast.nodes.ASTCase.ASTCaseBranch;
import cool.lexer.CoolLexer;
import cool.semantic.scope.Scope;
import cool.semantic.symbol.ClassSymbol;
import cool.semantic.symbol.IdSymbol;
import cool.semantic.symbol.LetSymbol;
import cool.semantic.symbol.MethodSymbol;
import cool.semantic.symbol.SymbolTable;
import cool.utils.Utils;

public class ASTResolutionPass extends ASTSemanticVisitor<Optional<ClassSymbol>> {

	private ClassSymbol currentClass;

	private MethodSymbol currentMethod;

	private Scope<IdSymbol> currentScope;

	@Override
	public Optional<ClassSymbol> visit(final ASTClass astClass) {

		this.ctx = astClass.getCtx();

		this.currentClass = astClass.getSymbol().orElseThrow();
		this.currentScope = this.currentClass;

		astClass.getFeatures().forEach(f -> f.accept(this));

		return Optional.empty();
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTMethod astMethod) {

		if (!astMethod.getSymbol().isPresent())
			return null;

		this.currentMethod = astMethod.getSymbol().orElseThrow();
		this.currentScope = this.currentMethod;

		astMethod.getBody().accept(this);

		return Optional.empty();
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTField astField) {

		astField.getDef().getExpr().ifPresent(e -> e.accept(this));

		return Optional.empty();
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTLet astLet) {

		final String variableName = astLet.getDef().getId().getToken().getText();
		final String typeName = astLet.getDef().getType().getToken().getText();

		if (Utils.SELF.equals(variableName)) {
			SymbolTable.error(this.ctx, astLet.getDef().getId().getToken(),
					"Let variable has illegal name " + Utils.SELF);
		}

		if (SymbolTable.getGlobals().lookup(typeName).isEmpty()) {
			SymbolTable.error(this.ctx, astLet.getDef().getType().getToken(),
					"Let variable " + variableName + " has undefined type " + typeName);
		}

		final LetSymbol letSymbol = new LetSymbol(variableName, this.currentScope);
		this.currentScope = letSymbol;

		astLet.getDef().getExpr().ifPresent(e -> e.accept(this));

		this.currentScope.add(letSymbol);

		astLet.getExpr().accept(this);

		return Optional.empty();
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTId astId) {
		final String idName = astId.getToken().getText();

		final Optional<IdSymbol> idSymbol = this.currentScope.lookup(idName);

		if (idSymbol.isEmpty() && !Utils.SELF.equals(idName)) {
			SymbolTable.error(this.ctx, astId.getToken(), "Undefined identifier " + idName);
			return Optional.empty();
		}

		if (Utils.SELF.equals(idName)) {
			return Optional.of(this.currentClass);
		}

		return Optional.ofNullable(idSymbol.orElseThrow().getType());
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTCaseBranch astCaseBranch) {

		final String variableName = astCaseBranch.getId().getToken().getText();
		final String typeName = astCaseBranch.getType().getToken().getText();

		if (Utils.SELF.equals(variableName)) {
			SymbolTable.error(this.ctx, astCaseBranch.getId().getToken(),
					"Case variable has illegal name " + Utils.SELF);
		}

		if (Utils.SELF_TYPE.equals(typeName)) {
			SymbolTable.error(this.ctx, astCaseBranch.getType().getToken(),
					"Case variable " + variableName + " has illegal type " + Utils.SELF_TYPE);
			return Optional.empty();
		}

		if (!SymbolTable.getGlobals().lookup(typeName).isPresent()) {
			SymbolTable.error(this.ctx, astCaseBranch.getType().getToken(),
					"Case variable " + variableName + " has undefined type " + typeName);
		}

		return Optional.empty();
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTCase astCase) {

		astCase.getValue().accept(this);

		astCase.getBranches().forEach(b -> b.accept(this));

		return Optional.empty();
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTArithmetic astArithmetic) {
		return this.visit((AST2OperandOp) astArithmetic);
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTComparison astComparison) {
		return this.visit((AST2OperandOp) astComparison);
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTNot astNot) {

		final ClassSymbol boolType = SymbolTable.getGlobals().lookup(Utils.BOOL).orElseThrow();

		final Optional<ClassSymbol> type = astNot.getExpression().accept(this);

		type.ifPresent(t -> {
			if (t != boolType) {
				SymbolTable.error(this.ctx, astNot.getExpression().getToken(),
						"Operand of " + astNot.getToken().getText() + " has type " + t.getName() + " instead of "
								+ boolType.getName());
			}
		});

		return Optional.of(boolType);
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTNeg astNeg) {

		final ClassSymbol intType = SymbolTable.getGlobals().lookup(Utils.INT).orElseThrow();

		final Optional<ClassSymbol> type = astNeg.getExpression().accept(this);

		type.ifPresent(t -> {
			if (t != intType) {
				SymbolTable.error(this.ctx, astNeg.getExpression().getToken(),
						"Operand of " + astNeg.getToken().getText() + " has type " + t.getName() + " instead of "
								+ intType.getName());
			}
		});

		return Optional.of(intType);
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTIsVoid astIsVoid) {
		return SymbolTable.getGlobals().lookup(Utils.BOOL);
	}

	@Override
	public Optional<ClassSymbol> visit(final AST2OperandOp ast2OperandOp) {

		final ClassSymbol intType = SymbolTable.getGlobals().lookup(Utils.INT).orElseThrow();
		final ClassSymbol boolType = SymbolTable.getGlobals().lookup(Utils.BOOL).orElseThrow();
		final ClassSymbol stringType = SymbolTable.getGlobals().lookup(Utils.STRING).orElseThrow();

		final Optional<ClassSymbol> leftType = ast2OperandOp.getLeft().accept(this);
		final Optional<ClassSymbol> rightType = ast2OperandOp.getRight().accept(this);

		if (ast2OperandOp.getToken().getType() != CoolLexer.EQ) {
			List.of(leftType, rightType).forEach(t -> {
				t.ifPresent(lt -> {
					if (lt != intType) {
						SymbolTable.error(this.ctx,
								((t == leftType) ? ast2OperandOp.getLeft() : ast2OperandOp.getRight()).getToken(),
								"Operand of " + ast2OperandOp.getOperator() + " has type " + lt.getName()
										+ " instead of " + intType.getName());
					}
				});
			});
		} else {
			if (leftType.isPresent() && rightType.isPresent()) {
				if (leftType.get() != rightType.get()
						&& (List.of(intType, boolType, stringType).contains(leftType.get()) ||
								List.of(intType, boolType, stringType).contains(rightType.get()))) {
					SymbolTable.error(this.ctx, ast2OperandOp.getToken(),
							"Cannot compare " + leftType.get().getName()
									+ " with " + rightType.get().getName());
				}
			}
		}

		return Optional.of(List.of(CoolLexer.LE, CoolLexer.LT, CoolLexer.EQ)
				.contains(ast2OperandOp.getToken().getType()) ? boolType : intType);
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTAssignment astAssignment) {

		final String variableString = astAssignment.getId().getToken().getText();

		if (Utils.SELF.equals(variableString)) {
			SymbolTable.error(this.ctx, astAssignment.getId().getToken(),
					"Cannot assign to " + Utils.SELF);
		}

		final Optional<ClassSymbol> variableType = astAssignment.getId().accept(this);
		final Optional<ClassSymbol> exprType = astAssignment.getExpr().accept(this);

		if (variableType.isPresent() && exprType.isPresent()) {
			if (!variableType.get().isSuperClassOf(exprType.get())) {
				SymbolTable.error(this.ctx, astAssignment.getExpr().getToken(),
						"Type " + exprType.get().getName()
								+ " of assigned expression is incompatible with declared type "
								+ variableType.get().getName() + " of identifier " + variableString);
			}
			return Optional.of(exprType.get());
		}

		return Optional.empty();
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTNew astNew) {

		final String typeName = astNew.getType().getToken().getText();

		final Optional<ClassSymbol> type = SymbolTable.getGlobals().lookup(typeName);

		if (type.isEmpty()) {
			SymbolTable.error(this.ctx, astNew.getType().getToken(), "new is used with undefined type " + typeName);
			return Optional.empty();
		}

		return Optional.of(type.orElseThrow());
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTInteger node) {
		return Optional.of(SymbolTable.getGlobals().lookup(Utils.INT).orElseThrow());
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTBoolean node) {
		return Optional.of(SymbolTable.getGlobals().lookup(Utils.BOOL).orElseThrow());
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTString node) {
		return Optional.of(SymbolTable.getGlobals().lookup(Utils.STRING).orElseThrow());
	}

}
