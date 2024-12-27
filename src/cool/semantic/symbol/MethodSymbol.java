package cool.semantic.symbol;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import cool.semantic.scope.Scope;

public class MethodSymbol extends Symbol implements Scope<IdSymbol> {

	private final ClassSymbol returnType;

	private final Scope<IdSymbol> outerScope;

	private final Map<String, IdSymbol> symbols = new LinkedHashMap<>();

	public MethodSymbol(final String name, final ClassSymbol returnType, final Scope<IdSymbol> outerScope) {
		super(name);
		this.returnType = returnType;
		this.outerScope = outerScope;
	}

	@Override
	public boolean add(final IdSymbol sym) {
		return this.symbols.putIfAbsent(sym.getName(), sym) == null;
	}

	@Override
	public Optional<IdSymbol> lookup(final String name) {
		final IdSymbol symbol = this.symbols.get(name);

		if (symbol != null)
			return Optional.of(symbol);

		return this.outerScope.lookup(name);
	}

	@Override
	public Optional<IdSymbol> lookupCurrent(final String name) {
		return Optional.ofNullable(this.symbols.get(name));
	}

	public Map<String, IdSymbol> getSymbols() {
		return this.symbols;
	}

	public ClassSymbol getReturnType() {
		return this.returnType;
	}
}
