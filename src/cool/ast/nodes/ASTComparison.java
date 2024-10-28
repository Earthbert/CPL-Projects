package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTComparison extends AST2OperandOp {

	public ASTComparison(Token token, ASTExpression left, ASTExpression right) {
		super(token, left, right);
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
