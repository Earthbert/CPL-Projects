package cool.semantic.scope;

import java.util.Map;
import java.util.Optional;

import cool.semantic.symbol.Symbol;

public class GenericScope implements Scope<Symbol> {

	private Optional<Scope<Symbol>> parent;

	private Map<String, Symbol> symbols;

	public GenericScope(Scope<Symbol> parent) {
		this.parent = Optional.ofNullable(parent);
	}

	public boolean add(Symbol symbol) {
		return symbols.putIfAbsent(symbol.getName(), symbol) == null;
	}

	@Override
	public Optional<Symbol> lookup(String name) {
		Symbol symbol = symbols.get(name);

		if (symbol != null)
			return Optional.of(symbol);

		return parent.map(p -> p.lookup(name)).orElse(Optional.empty());
	}

	@Override
	public Optional<Symbol> lookupCurrent(String name) {
		return Optional.ofNullable(symbols.get(name));
	}
}
