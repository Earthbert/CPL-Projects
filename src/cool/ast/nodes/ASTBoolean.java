package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTBoolean extends ASTLiteral {

	private Boolean value;

	public ASTBoolean(Token token) {
		super(token);
		value = Boolean.parseBoolean(token.getText());
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Boolean getValue() {
		return value;
	}
}
