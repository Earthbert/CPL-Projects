package cool.ast.visitors.semantic;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import cool.ast.nodes.ASTClass;
import cool.ast.nodes.ASTField;
import cool.ast.nodes.ASTFormal;
import cool.ast.nodes.ASTMethod;
import cool.semantic.symbol.ClassSymbol;
import cool.semantic.symbol.IDSymbolType;
import cool.semantic.symbol.IdSymbol;
import cool.semantic.symbol.MethodSymbol;
import cool.semantic.symbol.SymbolTable;
import cool.utils.Utils;

public class ASTDefinitionPassVisitor extends ASTSemanticVisitor<Void> {

	private ClassSymbol currentClass;

	private MethodSymbol currentMethod;

	private final List<ASTClass> visitedClasses = new LinkedList<>();

	@Override
	public Void visit(final ASTClass astClass) {
		if (this.visitedClasses.contains(astClass))
			return null;

		final ClassSymbol parent = astClass.getSymbol().orElseThrow().getParent();
		ASTClassDefinitionVisitor.getASTClass(parent).ifPresent(p -> p.accept(this));

		this.ctx = astClass.getCtx();

		this.currentClass = astClass.getSymbol().orElseThrow();

		astClass.getFeatures().forEach(f -> f.accept(this));

		this.visitedClasses.add(astClass);

		return null;
	}

	@Override
	public Void visit(final ASTField astField) {

		final String fieldName = astField.getDef().getId().getToken().getText();

		if (Utils.SELF.equals(fieldName)) {
			SymbolTable.error(this.ctx, astField.getDef().getId().getToken(),
					"Class " + this.currentClass.getName() + " has attribute with illegal name " + Utils.SELF);
			return null;
		}

		if (this.currentClass.lookupCurrent(fieldName).isPresent()) {
			SymbolTable.error(this.ctx, astField.getDef().getId().getToken(),
					"Class " + this.currentClass.getName() + " redefines attribute " + fieldName);
			return null;
		}

		final IdSymbol idSymbol = new IdSymbol(fieldName, IDSymbolType.FIELD);

		if (!this.currentClass.add(idSymbol)) {
			SymbolTable.error(this.ctx, astField.getDef().getId().getToken(),
					"Class " + this.currentClass.getName() + " redefines inherited attribute " + fieldName);
			return null;
		}

		final String typeName = astField.getDef().getType().getToken().getText();

		Optional<ClassSymbol> fieldType = SymbolTable.getGlobals().lookup(typeName);

		if (Utils.SELF_TYPE.equals(typeName)) {
			fieldType = Optional.of(SymbolTable.getSelfType());
		}

		if (!fieldType.isPresent()) {
			SymbolTable.error(this.ctx, astField.getDef().getType().getToken(),
					"Class " + this.currentClass.getName() + " has attribute " + fieldName + " with undefined type "
							+ typeName);
			return null;
		}

		idSymbol.setValueType(fieldType.orElseThrow());
		astField.setSymbol(idSymbol);

		return null;

	}

	@Override
	public Void visit(final ASTMethod astMethod) {

		final String methodName = astMethod.getId().getToken().getText();

		if (this.currentClass.lookupCurrentMethod(methodName).isPresent()) {
			SymbolTable.error(this.ctx, astMethod.getId().getToken(),
					"Class " + this.currentClass.getName() + " redefines method " + methodName);
			return null;
		}

		Optional<ClassSymbol> returnType = SymbolTable.getGlobals()
				.lookup(astMethod.getType().getToken().getText());

		if (Utils.SELF_TYPE.equals(astMethod.getType().getToken().getText())) {
			returnType = Optional.of(SymbolTable.getSelfType());
		}

		if (returnType.isEmpty()) {
			SymbolTable.error(this.ctx, astMethod.getType().getToken(),
					"Class " + this.currentClass.getName() + " has method " + methodName
							+ " with undefined return type "
							+ astMethod.getType().getToken().getText());
			return null;
		}

		final MethodSymbol methodSymbol = new MethodSymbol(methodName, returnType.orElseThrow(), this.currentClass);
		this.currentMethod = methodSymbol;
		astMethod.setSymbol(methodSymbol);

		astMethod.getArguments().forEach(a -> a.accept(this));

		final Optional<MethodSymbol> previous = this.currentClass.lookupMethod(methodName);

		if (previous.isPresent()) {

			if (previous.orElseThrow().getSymbols().size() != methodSymbol.getSymbols().size()) {
				SymbolTable.error(this.ctx, astMethod.getId().getToken(),
						"Class " + this.currentClass.getName() + " overrides method " + methodName
								+ " with different number of formal parameters");
				return null;
			}

			final List<IdSymbol> previousFormals = previous.orElseThrow().getSymbols().values().stream().toList();
			final List<IdSymbol> currentFormals = methodSymbol.getSymbols().values().stream().toList();

			for (int i = 0; i < previous.orElseThrow().getSymbols().size(); i++) {
				final IdSymbol previousFormal = previousFormals.get(i);
				final IdSymbol currentFormal = currentFormals.get(i);

				if (!previousFormal.getValueType().equals(currentFormal.getValueType())) {
					SymbolTable.error(this.ctx, astMethod.getArguments().get(i).getType().getToken(),
							"Class " + this.currentClass.getName() + " overrides method " + methodName
									+ " but changes type of formal parameter " + currentFormal.getName()
									+ " from " + previousFormal.getValueType().getName() + " to "
									+ currentFormal.getValueType().getName());
				}
			}

			if (!previous.orElseThrow().getReturnType().equals(methodSymbol.getReturnType())) {
				SymbolTable.error(this.ctx, astMethod.getType().getToken(),
						"Class " + this.currentClass.getName() + " overrides method " + methodName
								+ " but changes return type from " + previous.orElseThrow().getReturnType().getName()
								+ " to " + methodSymbol.getReturnType().getName());
				return null;
			}
		}

		this.currentClass.addMethod(methodSymbol);

		return null;
	}

	@Override
	public Void visit(final ASTFormal astFormal) {

		final String formalName = astFormal.getId().getToken().getText();

		if (Utils.SELF.equals(formalName)) {
			SymbolTable.error(this.ctx, astFormal.getId().getToken(),
					"Method " + this.currentMethod.getName() + " of class " + this.currentClass.getName()
							+ " has formal parameter with illegal name " + Utils.SELF);
			return null;
		}

		if (this.currentMethod.lookupCurrent(formalName).isPresent()) {
			SymbolTable.error(this.ctx, astFormal.getId().getToken(),
					"Method " + this.currentMethod.getName() + " of class " + this.currentClass.getName()
							+ " redefines formal parameter " + formalName);
			return null;
		}

		final String typeName = astFormal.getType().getToken().getText();

		if (Utils.SELF_TYPE.equals(typeName)) {
			SymbolTable.error(this.ctx, astFormal.getType().getToken(),
					"Method " + this.currentMethod.getName() + " of class " + this.currentClass.getName()
							+ " has formal parameter " + formalName + " with illegal type " + Utils.SELF_TYPE);
			return null;
		}

		final Optional<ClassSymbol> classSymbol = SymbolTable.getGlobals()
				.lookup(typeName);

		if (classSymbol.isEmpty()) {
			SymbolTable.error(this.ctx, astFormal.getType().getToken(),
					"Method " + this.currentMethod.getName() + " of class " + this.currentClass.getName()
							+ " has formal parameter " + formalName + " with undefined type "
							+ typeName);
			return null;
		}

		final IdSymbol idSymbol = new IdSymbol(formalName, IDSymbolType.FORMAL);
		idSymbol.setValueType(classSymbol.orElseThrow());
		this.currentMethod.add(idSymbol);
		astFormal.setSymbol(idSymbol);

		return null;
	}
}
