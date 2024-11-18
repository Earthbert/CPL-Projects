package cool.semantic.symbol;

import cool.semantic.scope.Scope;

public class MethodSymbol extends IdSymbol {

	private Scope scope;

	public MethodSymbol(String name, ClassSymbol type, Scope outerScope) {
		super(name);
		setType(type);
		this.scope = new Scope(outerScope);
	}

	public Scope getScope() {
		return scope;
	}
}
