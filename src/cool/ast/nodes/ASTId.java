package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;
import cool.semantic.symbol.IdSymbol;

public class ASTId extends ASTExpression {

	IdSymbol symbol;

	public ASTId(final Token token) {
		super(token);
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public IdSymbol getSymbol() {
		return this.symbol;
	}

	public void setSymbol(final IdSymbol symbol) {
		this.symbol = symbol;
	}
}
