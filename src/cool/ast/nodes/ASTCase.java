package cool.ast.nodes;

import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;

public class ASTCase extends ASTExpression {

	private final ASTExpression value;
	private final List<ASTCaseBranch> branches = new java.util.ArrayList<>();

	public ASTCase(final Token token, final ASTExpression value, final List<ASTType> types, final List<ASTId> ids,
			final List<ASTExpression> bodies) {
		super(token);
		this.value = value;
		for (int i = 0; i < types.size(); i++) {
			this.branches.add(new ASTCaseBranch((ASTType) types.get(i), (ASTId) ids.get(i), bodies.get(i)));
		}
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTExpression getValue() {
		return this.value;
	}

	public List<ASTCaseBranch> getBranches() {
		return Collections.unmodifiableList(this.branches);
	}

	public static class ASTCaseBranch extends ASTNode {
		private final ASTType type;
		private final ASTId id;
		private final ASTExpression body;

		public ASTCaseBranch(final ASTType type, final ASTId id, final ASTExpression body) {
			this.type = type;
			this.id = id;
			this.body = body;
		}

		@Override
		public <T> T accept(final ASTVisitor<T> visitor) {
			return visitor.visit(this);
		}

		public ASTType getType() {
			return this.type;
		}

		public ASTId getId() {
			return this.id;
		}

		public ASTExpression getBody() {
			return this.body;
		}

	}
}
