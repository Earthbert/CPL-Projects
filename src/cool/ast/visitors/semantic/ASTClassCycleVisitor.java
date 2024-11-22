package cool.ast.visitors.semantic;

import cool.ast.nodes.ASTClass;
import cool.semantic.symbol.ClassSymbol;
import cool.semantic.symbol.SymbolTable;

public class ASTClassCycleVisitor extends ASTSemanticVisitor<Void> {

	@Override
	public Void visit(final ASTClass astClass) {
		this.ctx = astClass.getCtx();

		if (!astClass.getSymbol().isPresent())
			return null;

		final ClassSymbol classSymbol = astClass.getSymbol().get();

		if (classSymbol.hasParent(classSymbol))
			SymbolTable.error(this.ctx, astClass.getType().getToken(),
					"Inheritance cycle for class " + classSymbol.getName());

		return null;
	}
}
