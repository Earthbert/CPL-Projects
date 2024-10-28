package cool.ast.nodes;

import java.util.List;
import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTCase extends ASTExpression {

	private ASTExpression value;
	private List<ASTCaseBranch> branches;

	public ASTCase(Token token, ASTExpression value, List<ASTType> types, List<ASTId> ids, List<ASTExpression> bodies) {
		super(token);
		this.value = value;
		for (int i = 0; i < types.size(); i++) {
			branches.add(new ASTCaseBranch((ASTType) types.get(i), (ASTId) ids.get(i), bodies.get(i)));
		}
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTExpression getValue() {
		return value;
	}

	public List<ASTCaseBranch> getBranches() {
		return branches;
	}

	public static class ASTCaseBranch {
		private ASTType type;
		private ASTId id;
		private ASTExpression body;

		public ASTCaseBranch(ASTType type, ASTId id, ASTExpression body) {
			this.type = type;
			this.id = id;
			this.body = body;
		}

		public ASTType getType() {
			return type;
		}

		public ASTId getId() {
			return id;
		}

		public ASTExpression getBody() {
			return body;
		}

	}
}
