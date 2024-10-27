package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTType extends ASTNode {

	private Token token;

	public ASTType(Token token) {
		this.token = token;
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Token getToken() {
		return token;
	}
}
