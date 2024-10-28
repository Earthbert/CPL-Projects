package cool.ast;

import cool.ast.nodes.*;

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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public Void visit(ASTMethod astMethod) {
		printIndent("method");
		increaseIndent();
		printIndent(astMethod.getId().getToken().getText());
		astMethod.getArgs().forEach(f -> f.accept(this));
		printIndent(astMethod.getType().getToken().getText());
		astMethod.getBody().accept(this);
		decreaseIndent();
		return null;
	}

	@Override
	public Void visit(ASTFormal astFormal) {
		printIndent("formal");
		increaseIndent();
		printIndent(astFormal.getId().getToken().getText());
		printIndent(astFormal.getType().getToken().getText());
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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public Void visit(ASTWhile astWhile) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public Void visit(ASTComparison astComparison) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public Void visit(ASTId astId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public Void visit(ASTNot astNot) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public Void visit(ASTNeg astNeg) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public Void visit(ASTIsVoid astIsVoid) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public Void visit(ASTNew astNew) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	@Override
	public Void visit(ASTCall astCall) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
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
