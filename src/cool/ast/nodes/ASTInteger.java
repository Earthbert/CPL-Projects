package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTInteger extends ASTExpression {
	private int value;

	public ASTInteger(Token token) {
		super(token);
		this.value = Integer.parseInt(token.getText());
	}

	public int getValue() {
		return value;
	}

	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
