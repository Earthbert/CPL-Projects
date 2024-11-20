package cool.ast.visitors.semantic;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import cool.ast.nodes.ASTClass;
import cool.ast.nodes.ASTField;
import cool.ast.nodes.ASTFormal;
import cool.ast.nodes.ASTMethod;
import cool.semantic.symbol.ClassSymbol;
import cool.semantic.symbol.IdSymbol;
import cool.semantic.symbol.MethodSymbol;
import cool.semantic.symbol.SymbolTable;
import cool.utils.Utils;

public class ASTDefinitionPassVisitor extends ASTSemanticVisitor<Void> {

	private ClassSymbol currentClass;

	private MethodSymbol currentMethod;

	private List<ASTClass> visitedClasses = new LinkedList<>();

	@Override
	public Void visit(ASTClass astClass) {
		if (visitedClasses.contains(astClass))
			return null;

		ClassSymbol parent = astClass.getSymbol().orElseThrow().getParent();
		ASTClassDefinitionVisitor.getASTClass(parent).ifPresent(p -> p.accept(this));

		ctx = astClass.getCtx();

		currentClass = astClass.getSymbol().orElseThrow();

		astClass.getFeatures().forEach(f -> f.accept(this));

		visitedClasses.add(astClass);

		return null;
	}

	@Override
	public Void visit(ASTField astField) {

		String fieldName = astField.getDef().getId().getToken().getText();

		if (fieldName.equals(Utils.SELF)) {
			SymbolTable.error(ctx, astField.getDef().getId().getToken(),
					"Class " + currentClass.getName() + " has attribute with illegal name " + Utils.SELF);
			return null;
		}

		if (currentClass.lookupCurrent(fieldName).isPresent()) {
			SymbolTable.error(ctx, astField.getDef().getId().getToken(),
					"Class " + currentClass.getName() + " redefines attribute " + fieldName);
			return null;
		}

		IdSymbol idSymbol = new IdSymbol(fieldName);

		if (!currentClass.add(idSymbol)) {
			SymbolTable.error(ctx, astField.getDef().getId().getToken(),
					"Class " + currentClass.getName() + " redefines inherited attribute " + fieldName);
			return null;
		}

		String typeName = astField.getDef().getType().getToken().getText();

		Optional<ClassSymbol> classSymbol = SymbolTable.getGlobals().lookup(typeName);

		if (!classSymbol.isPresent()) {
			SymbolTable.error(ctx, astField.getDef().getType().getToken(),
					"Class " + currentClass.getName() + " has attribute " + fieldName + " with undefined type "
							+ typeName);
			return null;
		}

		idSymbol.setType(classSymbol.get());
		astField.setSymbol(idSymbol);

		return null;

	}

	@Override
	public Void visit(ASTMethod astMethod) {

		String methodName = astMethod.getId().getToken().getText();

		if (currentClass.lookupCurrentMethod(methodName).isPresent()) {
			SymbolTable.error(ctx, astMethod.getId().getToken(),
					"Class " + currentClass.getName() + " redefines method " + methodName);
			return null;
		}

		Optional<ClassSymbol> returnType = SymbolTable.getGlobals()
				.lookup(astMethod.getType().getToken().getText());

		if (returnType.isEmpty()) {
			SymbolTable.error(ctx, astMethod.getType().getToken(),
					"Class " + currentClass.getName() + " has method " + methodName + " with undefined return type "
							+ astMethod.getType().getToken().getText());
			return null;
		}

		MethodSymbol methodSymbol = new MethodSymbol(methodName, returnType.get(), currentClass);
		currentMethod = methodSymbol;

		astMethod.getArguments().forEach(a -> a.accept(this));

		Optional<MethodSymbol> previous = currentClass.lookupMethod(methodName);

		if (previous.isPresent()) {

			if (previous.get().getSymbols().size() != methodSymbol.getSymbols().size()) {
				SymbolTable.error(ctx, astMethod.getId().getToken(),
						"Class " + currentClass.getName() + " overrides method " + methodName
								+ " with different number of formal parameters");
				return null;
			}

			List<IdSymbol> previousFormals = previous.get().getSymbols().values().stream().toList();
			List<IdSymbol> currentFormals = methodSymbol.getSymbols().values().stream().toList();

			for (int i = 0; i < previous.get().getSymbols().size(); i++) {
				IdSymbol previousFormal = previousFormals.get(i);
				IdSymbol currentFormal = currentFormals.get(i);

				if (!previousFormal.getType().equals(currentFormal.getType())) {
					SymbolTable.error(ctx, astMethod.getArguments().get(i).getType().getToken(),
							"Class " + currentClass.getName() + " overrides method " + methodName
									+ " but changes type of formal parameter " + currentFormal.getName()
									+ " from " + previousFormal.getType().getName() + " to "
									+ currentFormal.getType().getName());
				}
			}

			if (!previous.get().getType().equals(methodSymbol.getType())) {
				SymbolTable.error(ctx, astMethod.getType().getToken(),
						"Class " + currentClass.getName() + " overrides method " + methodName
								+ " but changes return type from " + previous.get().getType().getName()
								+ " to " + methodSymbol.getType().getName());
				return null;
			}
		}

		currentClass.addMethod(methodSymbol);

		return null;
	}

	@Override
	public Void visit(ASTFormal astFormal) {

		String formalName = astFormal.getId().getToken().getText();

		if (formalName.equals(Utils.SELF)) {
			SymbolTable.error(ctx, astFormal.getId().getToken(),
					"Method " + currentMethod.getName() + " of class " + currentClass.getName()
							+ " has formal parameter with illegal name " + Utils.SELF);
			return null;
		}

		if (currentMethod.lookupCurrent(formalName).isPresent()) {
			SymbolTable.error(ctx, astFormal.getId().getToken(),
					"Method " + currentMethod.getName() + " of class " + currentClass.getName()
							+ " redefines formal parameter " + formalName);
			return null;
		}

		String typeName = astFormal.getType().getToken().getText();

		if (typeName.equals(Utils.SELF_TYPE)) {
			SymbolTable.error(ctx, astFormal.getType().getToken(),
					"Method " + currentMethod.getName() + " of class " + currentClass.getName()
							+ " has formal parameter " + formalName + " with illegal type " + Utils.SELF_TYPE);
			return null;
		}

		Optional<ClassSymbol> classSymbol = SymbolTable.getGlobals()
				.lookup(typeName);

		if (classSymbol.isEmpty()) {
			SymbolTable.error(ctx, astFormal.getType().getToken(),
					"Method " + currentMethod.getName() + " of class " + currentClass.getName()
							+ " has formal parameter " + formalName + " with undefined type "
							+ typeName);
			return null;
		}

		IdSymbol idSymbol = new IdSymbol(formalName);
		idSymbol.setType(classSymbol.get());
		currentMethod.add(idSymbol);

		return null;
	}

}
