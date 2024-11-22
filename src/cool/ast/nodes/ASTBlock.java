package cool.ast.nodes;

import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTBlock extends ASTExpression {

	private final List<ASTExpression> expressions;

	public ASTBlock(final Token token, final List<ASTExpression> expressions) {
		super(token);
		this.expressions = expressions;
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public List<ASTExpression> getExpressions() {
		return Collections.unmodifiableList(this.expressions);
	}
}
