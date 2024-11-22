
package cool.ast.visitors.semantic;

import cool.ast.ASTVisitor;
import cool.ast.nodes.ASTNode;
import cool.ast.nodes.ASTRoot;
import cool.parser.CoolParser.ClassContext;
import cool.semantic.symbol.SymbolTable;

public abstract class ASTSemanticVisitor<T> implements ASTVisitor<T> {

	protected ClassContext ctx;

	@Override
	public T visit(final ASTRoot astRoot) {
		astRoot.getClasses().forEach(c -> c.accept(this));
		return null;
	}

	public static void applyVisitor(final ASTNode astRoot) {
		astRoot.accept(new ASTClassDefinitionVisitor());

		astRoot.accept(new ASTClassParentVisitor());

		astRoot.accept(new ASTClassCycleVisitor());

		if (SymbolTable.hasSemanticErrors())
			return;

		astRoot.accept(new ASTDefinitionPassVisitor());

		astRoot.accept(new ASTResolutionPass());
	}
}