package cool.ast.nodes;

import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTMethod extends ASTFeature {

	private ASTId id;
	private ASTType type;
	private List<ASTFormal> args;
	private ASTExpression body;

	private Token token;

	public ASTMethod(Token token, ASTId id, ASTType type, List<ASTFormal> args, ASTExpression body) {
		this.id = id;
		this.type = type;
		this.args = args;
		this.body = body;
		this.token = token;
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTId getId() {
		return id;
	}

	public ASTType getType() {
		return type;
	}

	public List<ASTFormal> getArguments() {
		return Collections.unmodifiableList(args);
	}

	public ASTExpression getBody() {
		return body;
	}

	public Token getToken() {
		return token;
	}

}
