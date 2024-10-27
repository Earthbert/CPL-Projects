package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTFormal extends ASTNode {
	
	private ASTId id;
	private ASTType type;

	private Token token;
	
	public ASTFormal(Token token, ASTId id, ASTType type) {
		this.id = id;
		this.type = type;
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

	public Token getToken() {
		return token;
	}
}
