package cool.ast.visitors.semantic;

import cool.ast.nodes.ASTClass;
import cool.semantic.scope.Scope;
import cool.semantic.symbol.ClassSymbol;
import cool.semantic.symbol.SymbolTable;

public class ASTClassCycleVisitor extends ASTSemanticVisitor<Void> {

	ASTClassCycleVisitor(Scope currentScope) {
		super(currentScope);
	}

	@Override
	public Void visit(ASTClass astClass) {
		ctx = astClass.getCtx();

		ClassSymbol classSymbol = (ClassSymbol) currentScope.lookup(astClass.getType().getToken().getText())
				.orElseThrow();

		if (classSymbol.hasParent(classSymbol))
			SymbolTable.error(ctx, astClass.getType().getToken(),
					"Inheritance cycle for class " + classSymbol.getName());

		return null;
	}
}
