package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTNew extends ASTExpression {

	private ASTType type;

	public ASTNew(Token token, ASTType type) {
		super(token);
		this.type = type;
	}

	public ASTType getType() {
		return type;
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
