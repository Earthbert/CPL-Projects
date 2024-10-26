package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTBoolean extends ASTExpression {
	
	private boolean value;

	public ASTBoolean(Token token) {
		super(token);
		value = Boolean.parseBoolean(token.getText());
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
