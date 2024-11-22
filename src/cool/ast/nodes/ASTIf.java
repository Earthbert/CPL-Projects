package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTIf extends ASTExpression {

	private final ASTExpression condition;
	private final ASTExpression thenBranch;
	private final ASTExpression elseBranch;

	public ASTIf(final Token token, final ASTExpression condition, final ASTExpression thenBranch,
			final ASTExpression elseBranch) {
		super(token);
		this.condition = condition;
		this.thenBranch = thenBranch;
		this.elseBranch = elseBranch;
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTExpression getCondition() {
		return this.condition;
	}

	public ASTExpression getThenBranch() {
		return this.thenBranch;
	}

	public ASTExpression getElseBranch() {
		return this.elseBranch;
	}

}
