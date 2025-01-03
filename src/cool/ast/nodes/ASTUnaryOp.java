package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

public abstract class ASTUnaryOp extends ASTExpression {

	protected ASTExpression expression;

	public ASTUnaryOp(final Token token, final ASTExpression expression) {
		super(token);
		this.expression = expression;
	}

	public ASTExpression getExpression() {
		return this.expression;
	}
}
