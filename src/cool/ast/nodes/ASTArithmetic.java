package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTArithmetic extends ASTBinaryOp {

	public ASTArithmetic(final Token token, final ASTExpression left, final ASTExpression right) {
		super(token, left, right);
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
