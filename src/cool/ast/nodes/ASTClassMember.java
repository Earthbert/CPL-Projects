package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

public class ASTClassMember {
	
	protected Token token;

	public ASTClassMember(Token token) {
		this.token = token;
	}

	public Token getToken() {
		return token;
	}
}
