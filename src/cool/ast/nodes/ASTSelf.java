package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;


public class ASTSelf extends ASTExpression {

	public ASTSelf(Token token) {
		super(token);
	}
	
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
