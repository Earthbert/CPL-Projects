package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

public abstract class ASTExpression extends ASTNode {

	protected Token token;

	public ASTExpression(final Token token) {
		this.token = token;
	}

	public Token getToken() {
		return this.token;
	}
}
