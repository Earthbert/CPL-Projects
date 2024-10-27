package cool.ast.nodes;

import cool.ast.ASTVisitor;

public class ASTField extends ASTFeature {

	private ASTDef def;

	public ASTField(ASTDef def) {
		this.def = def;
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTDef getDef() {
		return def;
	}
}
