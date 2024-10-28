package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

public abstract class AST2OperandOp extends ASTExpression {

	protected ASTExpression left;
	protected ASTExpression right;
	protected String operator;

	public AST2OperandOp(Token token, ASTExpression left, ASTExpression right) {
		super(token);
		this.left = left;
		this.operator = token.getText();
		this.right = right;
	}

	public ASTExpression getLeft() {
		return left;
	}

	public ASTExpression getRight() {
		return right;
	}

	public String getOperator() {
		return operator;
	}
}
