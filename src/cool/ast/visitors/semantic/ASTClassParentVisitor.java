package cool.ast.visitors.semantic;

import java.util.List;

import cool.ast.nodes.ASTClass;
import cool.semantic.symbol.ClassSymbol;
import cool.semantic.symbol.SymbolTable;
import cool.utils.Utils;

public class ASTClassParentVisitor extends ASTSemanticVisitor<Void> {

	@Override
	public Void visit(final ASTClass astClass) {
		this.ctx = astClass.getCtx();

		if (!astClass.getSymbol().isPresent())
			return null;

		final ClassSymbol classSymbol = astClass.getSymbol().get();

		final String parentName = astClass.getParent().isPresent() ? astClass.getParent().get().getToken().getText()
				: Utils.OBJECT;

		if (List.of(Utils.SELF_TYPE, Utils.INT, Utils.STRING, Utils.BOOL).contains(parentName))
			SymbolTable.error(this.ctx, astClass.getParent().get().getToken(),
					"Class " + classSymbol.getName() + " has illegal parent " + parentName);

		SymbolTable.getGlobals().lookup(parentName)
				.ifPresentOrElse(s -> classSymbol.setParent((ClassSymbol) s),
						() -> SymbolTable.error(this.ctx, astClass.getParent().get().getToken(),
								"Class " + classSymbol.getName() + " has undefined parent " + parentName));

		return null;
	}

}