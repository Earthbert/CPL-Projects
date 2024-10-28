package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTAssignment extends ASTExpression {
	private ASTId id;
	private ASTExpression expr;

	public ASTAssignment(Token token, ASTId id, ASTExpression expr) {
		super(token);
		this.id = id;
		this.expr = expr;
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTId getId() {
		return id;
	}

	public ASTExpression getExpr() {
		return expr;
	}
}
