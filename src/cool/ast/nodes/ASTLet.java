package cool.ast.nodes;

import java.util.List;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTLet extends ASTExpression {

	private List<ASTDef> def;
	private ASTExpression expr;

	public ASTLet(Token token, List<ASTDef> def, ASTExpression expr) {
		super(token);
		this.def = def;
		this.expr = expr;
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public List<ASTDef> getDefs() {
		return def;
	}

	public ASTExpression getExpr() {
		return expr;
	}

}
