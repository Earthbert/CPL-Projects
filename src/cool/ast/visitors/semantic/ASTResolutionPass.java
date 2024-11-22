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

		final Optional<ClassSymbol> bodyType = astMethod.getBody().accept(this);

		if (bodyType.isPresent() && !this.currentMethod.getType().isSuperClassOf(bodyType.orElseThrow())) {
			SymbolTable.error(this.ctx, astMethod.getBody().getToken(),
					"Type " + bodyType.get().getName() + " of the body of method "
							+ astMethod.getId().getToken().getText()
							+ " is incompatible with declared return type " + this.currentMethod.getType().getName());
		}

		return Optional.empty();
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTField astField) {

		final Optional<ClassSymbol> exprType = astField.getDef().getExpr().map(e -> e.accept(this))
				.orElse(Optional.empty());

		final var attrType = astField.getSymbol().map(IdSymbol::getType);

		if (exprType.isPresent() && attrType.isPresent()
				&& !attrType.orElseThrow().isSuperClassOf(exprType.orElseThrow())) {
			SymbolTable.error(this.ctx, astField.getDef().getExpr().get().getToken(),
					"Type " + exprType.get().getName() + " of initialization expression of attribute "
							+ astField.getDef().getId().getToken().getText() + " is incompatible with declared type "
							+ attrType.orElseThrow().getName());
		}

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

		final Optional<ClassSymbol> type = SymbolTable.getGlobals().lookup(typeName);

		if (type.isEmpty()) {
			SymbolTable.error(this.ctx, astLet.getDef().getType().getToken(),
					"Let variable " + variableName + " has undefined type " + typeName);
		}

		final LetSymbol letSymbol = new LetSymbol(variableName, this.currentScope);
		type.ifPresent(letSymbol::setType);
		this.currentScope = letSymbol;

		final Optional<ClassSymbol> defType = astLet.getDef().getExpr().map(e -> e.accept(this))
				.orElse(Optional.empty());

		if (defType.isPresent() && type.isPresent() && !type.orElseThrow().isSuperClassOf(defType.orElseThrow())) {
			SymbolTable.error(this.ctx, astLet.getDef().getExpr().get().getToken(),
					"Type " + defType.get().getName() + " of initialization expression of identifier " + variableName
							+ " is incompatible with declared type " + type.get().getName());
		}

		this.currentScope.add(letSymbol);

		final Optional<ClassSymbol> exprType = astLet.getExpr().accept(this);

		this.currentScope = letSymbol.getOuterScope().orElseThrow();

		return exprType;
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

		final Optional<ClassSymbol> type = SymbolTable.getGlobals().lookup(typeName);

		if (!type.isPresent()) {
			SymbolTable.error(this.ctx, astCaseBranch.getType().getToken(),
					"Case variable " + variableName + " has undefined type " + typeName);
			return Optional.empty();
		}

		final LetSymbol letSymbol = new LetSymbol(variableName, this.currentScope);
		letSymbol.setType(type.orElseThrow());
		letSymbol.add(letSymbol);

		this.currentScope = letSymbol;

		final Optional<ClassSymbol> exprType = astCaseBranch.getBody().accept(this);

		this.currentScope = letSymbol.getOuterScope().orElseThrow();

		return exprType;
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTCase astCase) {

		astCase.getValue().accept(this);

		final List<Optional<ClassSymbol>> caseBranchesTypes = astCase.getBranches().stream().map(b -> b.accept(this))
				.toList();

		return caseBranchesTypes.stream().skip(1).reduce(caseBranchesTypes.get(0),
				(t1, t2) -> t1.isPresent() && t2.isPresent() ? Optional.of(t1.get().join(t2.get())) : Optional.empty());
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTWhile astWhile) {

		final ClassSymbol boolType = SymbolTable.getGlobals().lookup(Utils.BOOL).orElseThrow();

		final Optional<ClassSymbol> conditionType = astWhile.getCondition().accept(this);
		astWhile.getBody().accept(this);

		conditionType.ifPresent(t -> {
			if (t != boolType) {
				SymbolTable.error(this.ctx, astWhile.getCondition().getToken(),
						"While condition has type " + t.getName() + " instead of " + boolType.getName());
			}
		});

		return SymbolTable.getGlobals().lookup(Utils.OBJECT);
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTIf astIf) {

		final ClassSymbol boolType = SymbolTable.getGlobals().lookup(Utils.BOOL).orElseThrow();

		final Optional<ClassSymbol> conditionType = astIf.getCondition().accept(this);
		final Optional<ClassSymbol> thenType = astIf.getThenBranch().accept(this);
		final Optional<ClassSymbol> elseType = astIf.getElseBranch().accept(this);

		conditionType.ifPresent(t -> {
			if (t != boolType) {
				SymbolTable.error(this.ctx, astIf.getCondition().getToken(),
						"If condition has type " + t.getName() + " instead of " + boolType.getName());
			}
		});

		final ClassSymbol commonType;

		if (thenType.isPresent() && elseType.isPresent()) {
			commonType = thenType.get().join(elseType.get());
		} else {
			commonType = SymbolTable.getGlobals().lookup(Utils.OBJECT).orElseThrow();
		}

		return Optional.of(commonType);
	}

	@Override
	public Optional<ClassSymbol> visit(final ASTBlock astBlock) {
		return astBlock.getExpressions().stream().map(e -> e.accept(this)).reduce(Optional.empty(),
				(t1, t2) -> t2);
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
