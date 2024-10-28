package cool.ast;

import cool.ast.nodes.*;
import cool.lexer.CoolLexer;
import cool.utils.Utils;

public class ASTPrintVisitor implements ASTVisitor<Void> {

	private Integer indent = 0;

	private void printIndent(String str) {
		System.out.print(" ".repeat(indent));
		System.out.println(str);
	}

	private void increaseIndent() {
		indent += 2;
	}

	private void decreaseIndent() {
		indent -= 2;
	}

	@Override
	public Void visit(ASTAssignment astAssignment) {
		printIndent(astAssignment.getToken().getText());
		increaseIndent();
		astAssignment.getId().accept(this);
		astAssignment.getExpr().accept(this);
		decreaseIndent();
		return null;
	}

	@Override
	public Void visit(ASTInteger node) {
		printIndent(node.getValue().toString());
		return null;
	}

	@Override
	public Void visit(ASTString node) {
		printIndent(node.getValue());
		return null;
	}

	@Override
	public Void visit(ASTBoolean node) {
		printIndent(node.getValue().toString());
		return null;
	}

	@Override
	public Void visit(ASTSelf astSelf) {
		printIndent(astSelf.getToken().getText().toLowerCase());
		return null;
	}

	@Override
	public Void visit(ASTClass astClass) {
		printIndent("class");
		increaseIndent();
		printIndent(astClass.getType().getToken().getText());
		astClass.getParent().ifPresent(p -> printIndent(p.getToken().getText()));
		astClass.getFeatures().forEach(f -> f.accept(this));
		decreaseIndent();
		return null;
	}

	@Override
	public Void visit(ASTDef astDef) {
		printIndent(astDef.getId().getToken().getText());
		printIndent(astDef.getType().getToken().getText());
		astDef.getExpr().ifPresent(e -> e.accept(this));
		return null;
	}

	@Override
	public Void visit(ASTField astField) {
		printIndent("attribute");
		increaseIndent();
		astField.getDef().accept(this);
		decreaseIndent();
		return null;
	}

	@Override
	public Void visit(ASTType astType) {
		printIndent(astType.getToken().getText());
		return null;
	}

	@Override
	public Void visit(ASTMethod astMethod) {
		printIndent("method");
		increaseIndent();
		astMethod.getId().accept(this);
		astMethod.getArguments().forEach(f -> f.accept(this));
		astMethod.getType().accept(this);
		astMethod.getBody().accept(this);
		decreaseIndent();
		return null;
	}

	@Override
	public Void visit(ASTFormal astFormal) {
		printIndent("formal");
		increaseIndent();
		astFormal.getId().accept(this);
		astFormal.getType().accept(this);
		decreaseIndent();
		return null;
	}

	@Override
	public Void visit(ASTLet astLet) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public Void visit(ASTIf astIf) {
		printIndent(astIf.getToken().getText().toLowerCase());
		increaseIndent();
		astIf.getCondition().accept(this);
		astIf.getThenBranch().accept(this);
		astIf.getElseBranch().accept(this);
		decreaseIndent();
		return null;
	}

	@Override
	public Void visit(ASTWhile astWhile) {
		printIndent(astWhile.getToken().getText().toLowerCase());
		increaseIndent();
		astWhile.getCondition().accept(this);
		astWhile.getBody().accept(this);
		decreaseIndent();
		return null;
	}

	@Override
	public Void visit(ASTCase astCase) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public Void visit(ASTBlock astBlock) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public Void visit(ASTArithmetic astArithmetic) {
		printIndent(astArithmetic.getOperator());
		increaseIndent();
		astArithmetic.getLeft().accept(this);
		astArithmetic.getRight().accept(this);
		decreaseIndent();
		return null;
	}

	@Override
	public Void visit(ASTComparison astComparison) {
		printIndent(astComparison.getOperator());
		increaseIndent();
		astComparison.getLeft().accept(this);
		astComparison.getRight().accept(this);
		decreaseIndent();
		return null;
	}

	@Override
	public Void visit(ASTId astId) {
		printIndent(astId.getToken().getText());
		return null;
	}

	@Override
	public Void visit(ASTNot astNot) {
		printIndent(astNot.getToken().getText().toLowerCase());
		increaseIndent();
		astNot.getExpression().accept(this);
		decreaseIndent();
		return null;
	}

	@Override
	public Void visit(ASTNeg astNeg) {
		printIndent(astNeg.getToken().getText().toLowerCase());
		increaseIndent();
		astNeg.getExpression().accept(this);
		decreaseIndent();
		return null;
	}

	@Override
	public Void visit(ASTIsVoid astIsVoid) {
		printIndent(astIsVoid.getToken().getText().toLowerCase());
		increaseIndent();
		astIsVoid.getExpression().accept(this);
		decreaseIndent();
		return null;
	}

	@Override
	public Void visit(ASTNew astNew) {
		printIndent(astNew.getToken().getText().toLowerCase());
		increaseIndent();
		astNew.getType().accept(this);
		decreaseIndent();
		return null;
	}

	@Override
	public Void visit(ASTCall astCall) {
		astCall.getObject().ifPresentOrElse(p -> printIndent("."), () -> printIndent("implicit dispatch"));
		increaseIndent();
		astCall.getObject().ifPresent(o -> o.accept(this));
		astCall.getStaticDispatchType().ifPresent(t -> t.accept(this));
		astCall.getMethod().accept(this);
		astCall.getArguments().forEach(a -> a.accept(this));
		decreaseIndent();
		return null;
	}

	@Override
	public Void visit(ASTRoot astRoot) {
		printIndent("program");
		increaseIndent();
		astRoot.getClasses().forEach(c -> c.accept(this));
		decreaseIndent();
		return null;
	}

}
