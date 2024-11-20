package cool.ast.visitors.semantic;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import cool.ast.nodes.ASTClass;
import cool.ast.nodes.ASTRoot;
import cool.semantic.symbol.ClassSymbol;
import cool.semantic.symbol.SymbolTable;
import cool.utils.Utils;

public class ASTClassDefinitionVisitor extends ASTSemanticVisitor<Void> {

	private static Map<ClassSymbol, ASTClass> classMap = new HashMap<>();

	@Override
	public Void visit(ASTRoot astRoot) {
		classMap.clear();
		astRoot.getClasses().forEach(c -> c.accept(this));
		return null;
	}

	@Override
	public Void visit(ASTClass astClass) {
		ctx = astClass.getCtx();

		String className = astClass.getType().getToken().getText();

		if (className.equals(Utils.SELF_TYPE))
			SymbolTable.error(ctx, astClass.getType().getToken(), "Class has illegal name " + Utils.SELF_TYPE);

		ClassSymbol classSymbol = new ClassSymbol(className);

		if (!SymbolTable.getGlobals().add(classSymbol))
			SymbolTable.error(ctx, astClass.getType().getToken(), "Class " + classSymbol.getName() + " is redefined");
		else {
			astClass.setSymbol(classSymbol);
			classMap.put(classSymbol, astClass);
		}

		return null;
	}

	public static Optional<ASTClass> getASTClass(ClassSymbol classSymbol) {
		return Optional.ofNullable(classMap.get(classSymbol));
	}
}
