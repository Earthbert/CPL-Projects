package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;
import cool.semantic.symbol.IdSymbol;

public class ASTFormal extends ASTNode {

	private ASTId id;
	private ASTType type;

	private Token token;

	private IdSymbol symbol;

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

	public IdSymbol getSymbol() {
		return symbol;
	}

	public void setSymbol(IdSymbol symbol) {
		this.symbol = symbol;
	}
}
