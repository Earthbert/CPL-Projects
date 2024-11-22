package cool.ast.visitors;

import cool.ast.ASTVisitor;
import cool.ast.nodes.*;
import cool.ast.nodes.ASTCase.ASTCaseBranch;

public class ASTPrintVisitor implements ASTVisitor<Void> {

	private Integer indent = 0;

	private void printIndent(final String str) {
		System.out.print(" ".repeat(this.indent));
		System.out.println(str);
	}

	private void increaseIndent() {
		this.indent += 2;
	}

	private void decreaseIndent() {
		this.indent -= 2;
	}

	@Override
	public Void visit(final ASTAssignment astAssignment) {
		this.printIndent(astAssignment.getToken().getText());
		this.increaseIndent();
		astAssignment.getId().accept(this);
		astAssignment.getExpr().accept(this);
		this.decreaseIndent();
		return null;
	}

	@Override
	public Void visit(final ASTInteger node) {
		this.printIndent(node.getValue().toString());
		return null;
	}

	@Override
	public Void visit(final ASTString node) {
		this.printIndent(node.getValue());
		return null;
	}

	@Override
	public Void visit(final ASTBoolean node) {
		this.printIndent(node.getValue().toString());
		return null;
	}

	@Override
	public Void visit(final ASTClass astClass) {
		this.printIndent("class");
		this.increaseIndent();
		this.printIndent(astClass.getType().getToken().getText());
		astClass.getParent().ifPresent(p -> this.printIndent(p.getToken().getText()));
		astClass.getFeatures().forEach(f -> f.accept(this));
		this.decreaseIndent();
		return null;
	}

	@Override
	public Void visit(final ASTDef astDef) {
		this.printIndent(astDef.getId().getToken().getText());
		this.printIndent(astDef.getType().getToken().getText());
		astDef.getExpr().ifPresent(e -> e.accept(this));
		return null;
	}

	@Override
	public Void visit(final ASTField astField) {
		this.printIndent("attribute");
		this.increaseIndent();
		astField.getDef().accept(this);
		this.decreaseIndent();
		return null;
	}

	@Override
	public Void visit(final ASTType astType) {
		this.printIndent(astType.getToken().getText());
		return null;
	}

	@Override
	public Void visit(final ASTMethod astMethod) {
		this.printIndent("method");
		this.increaseIndent();
		astMethod.getId().accept(this);
		astMethod.getArguments().forEach(f -> f.accept(this));
		astMethod.getType().accept(this);
		astMethod.getBody().accept(this);
		this.decreaseIndent();
		return null;
	}

	@Override
	public Void visit(final ASTFormal astFormal) {
		this.printIndent("formal");
		this.increaseIndent();
		astFormal.getId().accept(this);
		astFormal.getType().accept(this);
		this.decreaseIndent();
		return null;
	}

	@Override
	public Void visit(final ASTLet astLet) {
		if (astLet.isLetRoot()) {
			this.printIndent("let");
			this.increaseIndent();
		}

		this.printIndent("local");
		this.increaseIndent();
		astLet.getDef().accept(this);
		this.decreaseIndent();
		astLet.getExpr().accept(this);

		if (astLet.isLetRoot()) {
			this.decreaseIndent();
		}
		return null;
	}

	@Override
	public Void visit(final ASTIf astIf) {
		this.printIndent(astIf.getToken().getText().toLowerCase());
		this.increaseIndent();
		astIf.getCondition().accept(this);
		astIf.getThenBranch().accept(this);
		astIf.getElseBranch().accept(this);
		this.decreaseIndent();
		return null;
	}

	@Override
	public Void visit(final ASTWhile astWhile) {
		this.printIndent(astWhile.getToken().getText().toLowerCase());
		this.increaseIndent();
		astWhile.getCondition().accept(this);
		astWhile.getBody().accept(this);
		this.decreaseIndent();
		return null;
	}

	@Override
	public Void visit(final ASTCase astCase) {
		this.printIndent("case");
		this.increaseIndent();
		astCase.getValue().accept(this);
		astCase.getBranches().forEach(b -> b.accept(this));
		this.decreaseIndent();
		return null;
	}

	@Override
	public Void visit(final ASTBlock astBlock) {
		this.printIndent("block");
		this.increaseIndent();
		astBlock.getExpressions().forEach(e -> e.accept(this));
		this.decreaseIndent();
		return null;
	}

	@Override
	public Void visit(final ASTArithmetic astArithmetic) {
		this.visit((AST2OperandOp) astArithmetic);
		return null;
	}

	@Override
	public Void visit(final ASTComparison astComparison) {
		this.visit((AST2OperandOp) astComparison);
		return null;
	}

	@Override
	public Void visit(final AST2OperandOp ast2OperandOp) {
		this.printIndent(ast2OperandOp.getOperator());
		this.increaseIndent();
		ast2OperandOp.getLeft().accept(this);
		ast2OperandOp.getRight().accept(this);
		this.decreaseIndent();
		return null;
	}

	@Override
	public Void visit(final ASTId astId) {
		this.printIndent(astId.getToken().getText());
		return null;
	}

	@Override
	public Void visit(final ASTNot astNot) {
		this.printIndent(astNot.getToken().getText().toLowerCase());
		this.increaseIndent();
		astNot.getExpression().accept(this);
		this.decreaseIndent();
		return null;
	}

	@Override
	public Void visit(final ASTNeg astNeg) {
		this.printIndent(astNeg.getToken().getText().toLowerCase());
		this.increaseIndent();
		astNeg.getExpression().accept(this);
		this.decreaseIndent();
		return null;
	}

	@Override
	public Void visit(final ASTIsVoid astIsVoid) {
		this.printIndent(astIsVoid.getToken().getText().toLowerCase());
		this.increaseIndent();
		astIsVoid.getExpression().accept(this);
		this.decreaseIndent();
		return null;
	}

	@Override
	public Void visit(final ASTNew astNew) {
		this.printIndent(astNew.getToken().getText().toLowerCase());
		this.increaseIndent();
		astNew.getType().accept(this);
		this.decreaseIndent();
		return null;
	}

	@Override
	public Void visit(final ASTCall astCall) {
		astCall.getObject().ifPresentOrElse(p -> this.printIndent("."), () -> this.printIndent("implicit dispatch"));
		this.increaseIndent();
		astCall.getObject().ifPresent(o -> o.accept(this));
		astCall.getStaticDispatchType().ifPresent(t -> t.accept(this));
		astCall.getMethod().accept(this);
		astCall.getArguments().forEach(a -> a.accept(this));
		this.decreaseIndent();
		return null;
	}

	@Override
	public Void visit(final ASTRoot astRoot) {
		this.printIndent("program");
		this.increaseIndent();
		astRoot.getClasses().forEach(c -> c.accept(this));
		this.decreaseIndent();
		return null;
	}

	@Override
	public Void visit(final ASTCaseBranch astCaseBranch) {
		this.printIndent("case branch");
		this.increaseIndent();
		astCaseBranch.getId().accept(this);
		astCaseBranch.getType().accept(this);
		astCaseBranch.getBody().accept(this);
		this.decreaseIndent();
		return null;
	}

}
