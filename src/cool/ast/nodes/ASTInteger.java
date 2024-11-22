package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTInteger extends ASTLiteral {

	private final Integer value;

	public ASTInteger(final Token token) {
		super(token);
		this.value = Integer.parseInt(token.getText());
	}

	public Integer getValue() {
		return this.value;
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
