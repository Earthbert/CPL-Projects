package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTBoolean extends ASTLiteral {

	private final Boolean value;

	public ASTBoolean(final Token token) {
		super(token);
		this.value = Boolean.parseBoolean(token.getText());
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Boolean getValue() {
		return this.value;
	}
}
