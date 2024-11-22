package cool.ast.nodes;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;
import cool.semantic.symbol.MethodSymbol;

public class ASTMethod extends ASTFeature {

	private final ASTId id;
	private final ASTType type;
	private final List<ASTFormal> args;
	private final ASTExpression body;

	private final Token token;

	private MethodSymbol symbol;

	public ASTMethod(final Token token, final ASTId id, final ASTType type, final List<ASTFormal> args,
			final ASTExpression body) {
		this.id = id;
		this.type = type;
		this.args = args;
		this.body = body;
		this.token = token;
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTId getId() {
		return this.id;
	}

	public ASTType getType() {
		return this.type;
	}

	public List<ASTFormal> getArguments() {
		return Collections.unmodifiableList(this.args);
	}

	public ASTExpression getBody() {
		return this.body;
	}

	public Token getToken() {
		return this.token;
	}

	public Optional<MethodSymbol> getSymbol() {
		return Optional.ofNullable(this.symbol);
	}

	public void setSymbol(final MethodSymbol symbol) {
		this.symbol = symbol;
	}

}
