package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTNew extends ASTExpression {

	private final ASTType type;

	public ASTNew(final Token token, final ASTType type) {
		super(token);
		this.type = type;
	}

	public ASTType getType() {
		return this.type;
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
