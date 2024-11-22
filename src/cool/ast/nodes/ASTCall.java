package cool.ast.nodes;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTCall extends ASTExpression {

	private final ASTId method;
	private final Optional<ASTExpression> object;
	private final Optional<ASTType> staticDispatchType;
	private final List<ASTExpression> arguments;

	public ASTCall(final Token token, final ASTId id, final Optional<ASTExpression> object,
			final Optional<ASTType> staticDispatchType,
			final List<ASTExpression> arguments) {
		super(token);
		this.method = id;
		this.object = object;
		this.staticDispatchType = staticDispatchType;
		this.arguments = arguments;
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTId getMethod() {
		return this.method;
	}

	public Optional<ASTExpression> getObject() {
		return this.object;
	}

	public Optional<ASTType> getStaticDispatchType() {
		return this.staticDispatchType;
	}

	public List<ASTExpression> getArguments() {
		return Collections.unmodifiableList(this.arguments);
	}

}
