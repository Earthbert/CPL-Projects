package cool.ast.visitors.semantic;

import cool.ast.nodes.ASTClass;
import cool.semantic.symbol.ClassSymbol;
import cool.semantic.symbol.SymbolTable;

public class ASTClassCycleVisitor extends ASTSemanticVisitor<Void> {

	@Override
	public Void visit(ASTClass astClass) {
		ctx = astClass.getCtx();

		if (!astClass.getSymbol().isPresent())
			return null;

		ClassSymbol classSymbol = astClass.getSymbol().get();

		if (classSymbol.hasParent(classSymbol))
			SymbolTable.error(ctx, astClass.getType().getToken(),
					"Inheritance cycle for class " + classSymbol.getName());

		return null;
	}
}
