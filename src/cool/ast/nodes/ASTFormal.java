package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;
import cool.semantic.symbol.IdSymbol;

public class ASTFormal extends ASTNode {

	private final ASTId id;
	private final ASTType type;

	private final Token token;

	private IdSymbol symbol;

	public ASTFormal(final Token token, final ASTId id, final ASTType type) {
		this.id = id;
		this.type = type;
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

	public Token getToken() {
		return this.token;
	}

	public IdSymbol getSymbol() {
		return this.symbol;
	}

	public void setSymbol(final IdSymbol symbol) {
		this.symbol = symbol;
	}
}
