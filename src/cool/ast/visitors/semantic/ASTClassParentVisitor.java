package cool.ast.visitors.semantic;

import java.util.List;

import cool.ast.nodes.ASTClass;
import cool.semantic.scope.Scope;
import cool.semantic.symbol.ClassSymbol;
import cool.semantic.symbol.SymbolTable;
import cool.utils.Utils;

public class ASTClassParentVisitor extends ASTSemanticVisitor<Void> {

	public ASTClassParentVisitor(Scope currentScope) {
		super(currentScope);
	}

	@Override
	public Void visit(ASTClass astClass) {
		ctx = astClass.getCtx();

		if (!astClass.getSymbol().isPresent())
			return null;

		ClassSymbol classSymbol = astClass.getSymbol().get();

		String parentName = astClass.getParent().isPresent() ? astClass.getParent().get().getToken().getText()
				: Utils.OBJECT;

		if (List.of(Utils.SELF_TYPE, Utils.INT, Utils.STRING, Utils.BOOL).contains(parentName))
			SymbolTable.error(ctx, astClass.getParent().get().getToken(),
					"Class " + classSymbol.getName() + " has illegal parent " + parentName);

		currentScope.lookup(parentName)
				.ifPresentOrElse(s -> classSymbol.setParent((ClassSymbol) s),
						() -> SymbolTable.error(ctx, astClass.getParent().get().getToken(),
								"Class " + classSymbol.getName() + " has undefined parent " + parentName));

		return null;
	}

}