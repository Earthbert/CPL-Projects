package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTWhile extends ASTExpression {

	private final ASTExpression condition;
	private final ASTExpression body;

	public ASTWhile(final Token token, final ASTExpression condition, final ASTExpression body) {
		super(token);
		this.condition = condition;
		this.body = body;
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTExpression getCondition() {
		return this.condition;
	}

	public ASTExpression getBody() {
		return this.body;
	}

}
