package cool.ast.nodes;

import org.antlr.v4.runtime.Token;

public class ASTDef extends ASTNode {

	public String name;
	public String type;
	public ASTExpression expr;

	public ASTDef(Token token) {
	}
}
