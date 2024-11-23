
package cool.ast.visitors.semantic;

import cool.ast.ASTVisitor;
import cool.ast.nodes.ASTNode;
import cool.ast.nodes.ASTRoot;
import cool.parser.CoolParser.ClassContext;
import cool.semantic.symbol.SymbolTable;
import cool.utils.Utils;

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

		final String noMainError = "No method main in class Main";

		SymbolTable.getGlobals().lookup(Utils.MAIN)
				.ifPresentOrElse(c -> c.lookupMethod(Utils.MAIN_METHOD).ifPresentOrElse(m -> {
					if (m.getSymbols().size() != 0)
						SymbolTable.error(noMainError);
				}, () -> SymbolTable.error(noMainError)), () -> SymbolTable.error(noMainError));
	}
}