package cool.ast.nodes;

import java.util.Collections;
import java.util.List;

import cool.ast.ASTVisitor;
import cool.utils.Utils;

public class ASTRoot extends ASTNode {

	private final List<ASTClass> classes;

	public ASTRoot(final List<ASTNode> classes) {
		this.classes = Utils.castList(classes, ASTClass.class);
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public List<ASTClass> getClasses() {
		return Collections.unmodifiableList(this.classes);
	}
}
