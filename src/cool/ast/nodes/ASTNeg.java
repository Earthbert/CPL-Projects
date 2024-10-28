package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTNeg extends AST1OperandOp {
	
	public ASTNeg(Token token, ASTExpression expression) {
		super(token, expression);
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
