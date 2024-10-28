package cool.ast.nodes;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTCall extends ASTExpression {

	private ASTId method;
	private Optional<ASTExpression> object;
	private Optional<ASTType> staticDispatchType;
	private List<ASTExpression> arguments;

	public ASTCall(Token token, ASTId id, Optional<ASTExpression> object, Optional<ASTType> staticDispatchType,
			List<ASTExpression> arguments) {
		super(token);
		this.method = id;
		this.object = object;
		this.staticDispatchType = staticDispatchType;
		this.arguments = arguments;
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTId getMethod() {
		return method;
	}

	public Optional<ASTExpression> getObject() {
		return object;
	}

	public Optional<ASTType> getStaticDispatchType() {
		return staticDispatchType;
	}

	public List<ASTExpression> getArguments() {
		return Collections.unmodifiableList(arguments);
	}

}
