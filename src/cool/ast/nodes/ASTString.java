package cool.ast.nodes;


import org.antlr.v4.runtime.Token;
import cool.ast.ASTVisitor;


public class ASTString extends ASTExpression {
	private String value;

	public ASTString(Token token) {
		super(token);
		this.value = token.getText();
	}

	public String getValue() {
		return value;
	}

	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
