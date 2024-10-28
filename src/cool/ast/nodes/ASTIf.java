package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTIf extends ASTExpression {

	private ASTExpression condition;
	private ASTExpression thenBranch;
	private ASTExpression elseBranch;

	public ASTIf(Token token, ASTExpression condition, ASTExpression thenBranch, ASTExpression elseBranch) {
		super(token);
		this.condition = condition;
		this.thenBranch = thenBranch;
		this.elseBranch = elseBranch;
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTExpression getCondition() {
		return condition;
	}

	public ASTExpression getThenBranch() {
		return thenBranch;
	}

	public ASTExpression getElseBranch() {
		return elseBranch;
	}

}
