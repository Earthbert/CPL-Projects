package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTAssignment extends ASTExpression {
	private final ASTId id;
	private final ASTExpression expr;

	public ASTAssignment(final Token token, final ASTId id, final ASTExpression expr) {
		super(token);
		this.id = id;
		this.expr = expr;
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTId getId() {
		return this.id;
	}

	public ASTExpression getExpr() {
		return this.expr;
	}
}
