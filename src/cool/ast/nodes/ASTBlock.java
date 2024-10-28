package cool.ast.nodes;

import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTBlock extends ASTExpression {

	private List<ASTExpression> expressions;

	public ASTBlock(Token token, List<ASTExpression> expressions) {
		super(token);
		this.expressions = expressions;
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public List<ASTExpression> getExpressions() {
		return Collections.unmodifiableList(expressions);
	}
}
