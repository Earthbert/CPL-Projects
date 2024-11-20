package cool.semantic.symbol;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import cool.semantic.scope.Scope;

public class ClassSymbol extends Symbol implements Scope<IdSymbol> {

	private ClassSymbol parent;

	private Map<String, IdSymbol> symbols = new LinkedHashMap<>();
	private Map<String, MethodSymbol> methods = new LinkedHashMap<>();

	public ClassSymbol(String name) {
		super(name);
	}

	public ClassSymbol(String name, ClassSymbol parent) {
		this(name);
		this.parent = parent;
	}

	public void setParent(ClassSymbol parent) {
		this.parent = parent;
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

	@Override
	public boolean add(IdSymbol sym) {
		Optional<IdSymbol> symbol = lookup(sym.getName());
		return symbol.isEmpty() && symbols.putIfAbsent(sym.getName(), sym) == null;
	}

	public boolean addMethod(MethodSymbol method) {
		return methods.putIfAbsent(method.getName(), method) == null;
	}

	@Override
	public Optional<IdSymbol> lookup(String name) {
		IdSymbol symbol = symbols.get(name);

		if (symbol != null)
			return Optional.of(symbol);

		if (parent != null)
			return parent.lookup(name);

		return Optional.empty();
	}

	@Override
	public Optional<IdSymbol> lookupCurrent(String name) {
		return Optional.ofNullable(symbols.get(name));
	}

	public Optional<MethodSymbol> lookupMethod(String name) {
		MethodSymbol method = methods.get(name);

		if (method != null)
			return Optional.of(method);

		if (parent != null)
			return parent.lookupMethod(name);

		return Optional.empty();
	}
}
