package cool.ast.visitors.semantic;

import java.util.LinkedList;
import java.util.List;

import cool.ast.nodes.ASTClass;
import cool.ast.nodes.ASTField;
import cool.ast.nodes.ASTMethod;
import cool.semantic.symbol.ClassSymbol;
import cool.semantic.symbol.IdSymbol;
import cool.semantic.symbol.SymbolTable;
import cool.utils.Utils;

public class ASTDefinitionPassVisitor extends ASTSemanticVisitor<Void> {

	private ClassSymbol currentClass;

	private List<ASTClass> visitedClasses = new LinkedList<>();

	@Override
	public Void visit(ASTClass astClass) {
		if (visitedClasses.contains(astClass))
			return null;

		ClassSymbol parent = astClass.getSymbol().orElseThrow().getParent();
		ASTClassDefinitionVisitor.getASTClass(parent).ifPresent(p -> p.accept(this));

		ctx = astClass.getCtx();
		if (!astClass.getSymbol().isPresent())
			return null;
		currentClass = astClass.getSymbol().get();

		astClass.getFeatures().forEach(f -> f.accept(this));

		visitedClasses.add(astClass);

		return null;
	}

	@Override
	public Void visit(ASTField astField) {

		if (astField.getDef().getId().getToken().getText().equals(Utils.SELF))
			SymbolTable.error(ctx, astField.getDef().getId().getToken(),
					"Class " + currentClass.getName() + " has attribute with illegal name " + Utils.SELF);

		IdSymbol idSymbol = new IdSymbol(astField.getDef().getId().getToken().getText());

		if (currentClass.lookupCurrent(idSymbol.getName()).isPresent()) {
			SymbolTable.error(ctx, astField.getDef().getId().getToken(),
					"Class " + currentClass.getName() + " redefines attribute " + idSymbol.getName());
			return null;
		}

		if (!currentClass.add(idSymbol)) {
			SymbolTable.error(ctx, astField.getDef().getId().getToken(),
					"Class " + currentClass.getName() + " redefines inherited attribute " + idSymbol.getName());
			return null;
		}

		String typeName = astField.getDef().getType().getToken().getText();

		if (!SymbolTable.getGlobals().lookup(typeName).isPresent())
			SymbolTable.error(ctx, astField.getDef().getType().getToken(),
					"Class " + currentClass.getName() + " has attribute " + idSymbol.getName() + " with undefined type "
							+ typeName);

		astField.setSymbol(idSymbol);

		return null;

	}

	@Override
	public Void visit(ASTMethod astMethod) {
		return null;
	}

}
