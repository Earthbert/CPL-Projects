package cool.semantic.symbol;

import cool.semantic.scope.ClassScope;
import cool.semantic.scope.Scope;

public class ClassSymbol extends Symbol {

	private ClassSymbol parent;

	private ClassScope scope;

	public ClassSymbol(String name, Scope outerScope) {
		super(name);
		this.scope = new ClassScope(outerScope);
	}

	public ClassScope getScope() {
		return scope;
	}

	public void setParent(ClassSymbol parent) {
		this.parent = parent;
	}

	public ClassSymbol getParent() {
		return parent;
	}
}
