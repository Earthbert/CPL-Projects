package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTLet extends ASTExpression {

	private final ASTDef def;
	private final ASTExpression expr;

	private boolean letRoot = false;

	public ASTLet(final Token token, final ASTDef def, final ASTExpression expr) {
		super(token);
		this.def = def;
		this.expr = expr;
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTDef getDef() {
		return this.def;
	}

	public ASTExpression getExpr() {
		return this.expr;
	}

	public boolean isLetRoot() {
		return this.letRoot;
	}

	public void setLetRoot(final boolean letRoot) {
		this.letRoot = letRoot;
	}
}
