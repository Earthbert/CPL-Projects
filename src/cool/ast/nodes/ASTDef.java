package cool.ast.nodes;

import java.util.Optional;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTDef extends ASTNode {

	private final ASTId id;
	private final ASTType type;
	private final Optional<ASTExpression> expr;

	private final Token token;

	public ASTDef(final Token token, final ASTId id, final ASTType type, final Optional<ASTExpression> expr) {
		this.id = id;
		this.type = type;
		this.expr = expr;
		this.token = token;
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTId getId() {
		return this.id;
	}

	public ASTType getType() {
		return this.type;
	}

	public Optional<ASTExpression> getExpr() {
		return this.expr;
	}

	public Token getToken() {
		return this.token;
	}
}
