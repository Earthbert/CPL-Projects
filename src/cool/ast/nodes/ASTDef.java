package cool.ast.nodes;

import java.util.Optional;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTDef extends ASTNode {

	private ASTId id;
	private ASTType type;
	private Optional<ASTExpression> expr;

	private Token token;

	public ASTDef(Token token, ASTId id, ASTType type, Optional<ASTExpression> expr) {
		this.id = id;
		this.type = type;
		this.expr = expr;
		this.token = token;
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTId getId() {
		return id;
	}

	public ASTType getType() {
		return type;
	}

	public Optional<ASTExpression> getExpr() {
		return expr;
	}

	public Token getToken() {
		return token;
	}
}
