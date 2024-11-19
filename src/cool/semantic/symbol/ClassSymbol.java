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
		this.scope = new ClassScope(parent.getScope());
	}

	public ClassSymbol getParent() {
		return parent;
	}

	public boolean hasParent(ClassSymbol parent) {
		if (this.parent == null)
			return false;

		if (this.parent.equals(parent))
			return true;

		return this.parent.hasParent(parent);
	}
}
