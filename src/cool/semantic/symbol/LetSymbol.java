package cool.semantic.symbol;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import cool.semantic.scope.Scope;

public class LetSymbol extends IdSymbol implements Scope<IdSymbol> {

	private Scope<IdSymbol> outerScope;

	private Map<String, IdSymbol> symbols = new LinkedHashMap<>();

	public LetSymbol(String name, Scope<IdSymbol> outerScope) {
		super(name);
		this.outerScope = outerScope;
	}

	@Override
	public boolean add(IdSymbol sym) {
		return symbols.putIfAbsent(sym.getName(), sym) == null;
	}

	@Override
	public Optional<IdSymbol> lookup(String name) {
		IdSymbol symbol = symbols.get(name);

		if (symbol != null)
			return Optional.of(symbol);

		return outerScope.lookup(name);
	}

	@Override
	public Optional<IdSymbol> lookupCurrent(String name) {
		return Optional.ofNullable(symbols.get(name));
	}

}
