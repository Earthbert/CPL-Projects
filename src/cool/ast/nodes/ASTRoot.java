package cool.ast.nodes;

import java.util.Collections;
import java.util.List;

import cool.ast.ASTVisitor;
import cool.utils.Utils;

public class ASTRoot extends ASTNode {
	
	private List<ASTClass> classes;

	public ASTRoot(List<ASTNode> classes) {
		this.classes = Utils.castList(classes, ASTClass.class);
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public List<ASTClass> getClasses() {
		return Collections.unmodifiableList(classes);
	}
}
