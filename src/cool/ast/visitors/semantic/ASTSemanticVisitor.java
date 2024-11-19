
package cool.ast.visitors.semantic;

import cool.ast.ASTVisitor;
import cool.ast.nodes.ASTNode;
import cool.ast.nodes.ASTRoot;
import cool.parser.CoolParser.ClassContext;
import cool.semantic.scope.Scope;
import cool.semantic.symbol.SymbolTable;

public abstract class ASTSemanticVisitor<T> implements ASTVisitor<T> {

	protected Scope currentScope;

	protected ClassContext ctx;

	public ASTSemanticVisitor(Scope currentScope) {
		this.currentScope = currentScope;
	}

	@Override
	public T visit(ASTRoot astRoot) {
		astRoot.getClasses().forEach(c -> c.accept(this));
		return null;
	}

	public static void applyVisitor(ASTNode astRoot) {
		astRoot.accept(new ASTClassDefinitionVisitor(SymbolTable.getGlobals()));

		astRoot.accept(new ASTClassParentVisitor(SymbolTable.getGlobals()));

		astRoot.accept(new ASTClassCycleVisitor(SymbolTable.getGlobals()));

		if (SymbolTable.hasSemanticErrors())
			return;
	}
}