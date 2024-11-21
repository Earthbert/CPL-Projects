package cool.ast.nodes;

import java.util.List;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;
import cool.semantic.symbol.LetSymbol;

public class ASTLet extends ASTExpression {

	private ASTDef def;
	private ASTExpression expr;

	private LetSymbol symbol;

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

	public LetSymbol getSymbol() {
		return symbol;
	}

	public void setSymbol(LetSymbol symbol) {
		this.symbol = symbol;
	}
}
