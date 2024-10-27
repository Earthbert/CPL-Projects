package cool.ast.nodes;

import java.util.Collections;
import java.util.List;
import cool.utils.Utils;

public class ASTRoot extends ASTNode {
	
	private List<ASTClass> classes;

	public ASTRoot(List<ASTNode> classes) {
		this.classes = Utils.castList(classes, ASTClass.class);
	}

	public List<ASTClass> getClasses() {
		return Collections.unmodifiableList(classes);
	}
}
