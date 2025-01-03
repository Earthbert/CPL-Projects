package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public abstract class ASTBinaryOp extends ASTExpression {

	protected ASTExpression left;
	protected ASTExpression right;
	protected String operator;

	public ASTBinaryOp(final Token token, final ASTExpression left, final ASTExpression right) {
		super(token);
		this.left = left;
		this.operator = token.getText();
		this.right = right;
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTExpression getLeft() {
		return this.left;
	}

	public ASTExpression getRight() {
		return this.right;
	}

	public void setLeft(final ASTExpression left) {
		this.left = left;
	}

	public void setRight(final ASTExpression right) {
		this.right = right;
	}

	public String getOperator() {
		return this.operator;
	}
}
