package cool.ast.nodes;

import java.util.List;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTLet extends ASTExpression {

	private ASTDef def;
	private ASTExpression expr;

	private boolean letRoot = false;

	public ASTLet(Token token, ASTDef def, ASTExpression expr) {
		super(token);
		this.def = def;
		this.expr = expr;
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTDef getDef() {
		return def;
	}

	public ASTExpression getExpr() {
		return expr;
	}

	public boolean isLetRoot() {
		return letRoot;
	}

	public void setLetRoot(boolean letRoot) {
		this.letRoot = letRoot;
	}
}
