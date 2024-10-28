package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTWhile extends ASTExpression {

	private ASTExpression condition;
	private ASTExpression body;

	public ASTWhile(Token token, ASTExpression condition, ASTExpression body) {
		super(token);
		this.condition = condition;
		this.body = body;
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTExpression getCondition() {
		return condition;
	}

	public ASTExpression getBody() {
		return body;
	}

	
}
