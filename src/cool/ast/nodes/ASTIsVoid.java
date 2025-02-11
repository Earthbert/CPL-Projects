package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTIsVoid extends ASTUnaryOp {

	public ASTIsVoid(final Token token, final ASTExpression expression) {
		super(token, expression);
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
