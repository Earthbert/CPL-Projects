package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTString extends ASTLiteral {

	private final String value;

	public ASTString(final Token token) {
		super(token);
		this.value = token.getText();
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public String getValue() {
		return this.value;
	}
}
