package cool.ast.visitors.semantic;

import cool.ast.nodes.ASTClass;
import cool.semantic.scope.Scope;
import cool.semantic.symbol.ClassSymbol;
import cool.semantic.symbol.SymbolTable;
import cool.utils.Utils;

public class ASTClassDefinitionVisitor extends ASTSemanticVisitor<Void> {

	public ASTClassDefinitionVisitor(Scope currentScope) {
		super(currentScope);
	}

	@Override
	public Void visit(ASTClass astClass) {
		ctx = astClass.getCtx();

		if (astClass.getType().getToken().getText().equals(Utils.SELF_TYPE))
			SymbolTable.error(ctx, astClass.getType().getToken(), "Class has illegal name " + Utils.SELF_TYPE);

		ClassSymbol classSymbol = new ClassSymbol(astClass.getType().getToken().getText(), currentScope);
		if (!currentScope.add(classSymbol))
			SymbolTable.error(ctx, astClass.getType().getToken(), "Class " + classSymbol.getName() + " is redefined");
		else
			astClass.setSymbol(classSymbol);

		return null;
	}
}
