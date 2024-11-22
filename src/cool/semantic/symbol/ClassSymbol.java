package cool.semantic.symbol;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import cool.semantic.scope.Scope;

public class ClassSymbol extends Symbol implements Scope<IdSymbol> {

	private ClassSymbol parent;

	private final Map<String, IdSymbol> symbols = new LinkedHashMap<>();
	private final Map<String, MethodSymbol> methods = new LinkedHashMap<>();

	public ClassSymbol(final String name) {
		super(name);
	}

	public ClassSymbol(final String name, final ClassSymbol parent) {
		this(name);
		this.parent = parent;
	}

	public void setParent(final ClassSymbol parent) {
		this.parent = parent;
	}

	public ClassSymbol getParent() {
		return this.parent;
	}

	public boolean hasParent(final ClassSymbol parent) {
		if (this.parent == null)
			return false;

		if (this.parent.equals(parent))
			return true;

		return this.parent.hasParent(parent);
	}

	@Override
	public boolean add(final IdSymbol sym) {
		final Optional<IdSymbol> symbol = this.lookup(sym.getName());
		return symbol.isEmpty() && this.symbols.putIfAbsent(sym.getName(), sym) == null;
	}

	public boolean addMethod(final MethodSymbol method) {
		final Optional<MethodSymbol> symbol = this.lookupMethod(method.getName());
		return symbol.isEmpty() && this.methods.putIfAbsent(method.getName(), method) == null;
	}

	@Override
	public Optional<IdSymbol> lookup(final String name) {
		final IdSymbol symbol = this.symbols.get(name);

		if (symbol != null)
			return Optional.of(symbol);

		if (this.parent != null)
			return this.parent.lookup(name);

		return Optional.empty();
	}

	@Override
	public Optional<IdSymbol> lookupCurrent(final String name) {
		return Optional.ofNullable(this.symbols.get(name));
	}

	public Optional<MethodSymbol> lookupMethod(final String name) {
		final MethodSymbol method = this.methods.get(name);

		if (method != null)
			return Optional.of(method);

		if (this.parent != null)
			return this.parent.lookupMethod(name);

		return Optional.empty();
	}

	public Optional<MethodSymbol> lookupCurrentMethod(final String name) {
		return Optional.ofNullable(this.methods.get(name));
	}
}
