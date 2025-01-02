package cool.ast.nodes;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;
import cool.semantic.symbol.MethodSymbol;

public class ASTCall extends ASTExpression {

	private final ASTId method;
	private final Optional<ASTExpression> subject;
	private final Optional<ASTType> staticDispatchType;
	private final List<ASTExpression> arguments;

	private MethodSymbol methodSymbol;

	public ASTCall(final Token token, final ASTId id, final Optional<ASTExpression> subject,
			final Optional<ASTType> staticDispatchType,
			final List<ASTExpression> arguments) {
		super(token);
		this.method = id;
		this.subject = subject;
		this.staticDispatchType = staticDispatchType;
		this.arguments = arguments;
	}

	public Optional<MethodSymbol> getSymbol() {
		return Optional.ofNullable(this.methodSymbol);
	}

	public void setMethodSymbol(final MethodSymbol methodSymbol) {
		this.methodSymbol = methodSymbol;
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTId getMethod() {
		return this.method;
	}

	public Optional<ASTExpression> getSubject() {
		return this.subject;
	}

	public Optional<ASTType> getStaticDispatchType() {
		return this.staticDispatchType;
	}

	public List<ASTExpression> getArguments() {
		return Collections.unmodifiableList(this.arguments);
	}

}
