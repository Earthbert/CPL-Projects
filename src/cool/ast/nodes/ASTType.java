package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTType extends ASTNode {

	private final Token token;

	public ASTType(final Token token) {
		this.token = token;
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Token getToken() {
		return this.token;
	}
}
