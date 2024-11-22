package cool.semantic.scope;

import java.util.Map;
import java.util.Optional;

import cool.semantic.symbol.Symbol;

public class GenericScope implements Scope<Symbol> {

	private final Optional<Scope<Symbol>> parent;

	private Map<String, Symbol> symbols;

	public GenericScope(final Scope<Symbol> parent) {
		this.parent = Optional.ofNullable(parent);
	}

	@Override
	public boolean add(final Symbol symbol) {
		return this.symbols.putIfAbsent(symbol.getName(), symbol) == null;
	}

	@Override
	public Optional<Symbol> lookup(final String name) {
		final Symbol symbol = this.symbols.get(name);

		if (symbol != null)
			return Optional.of(symbol);

		return this.parent.map(p -> p.lookup(name)).orElse(Optional.empty());
	}

	@Override
	public Optional<Symbol> lookupCurrent(final String name) {
		return Optional.ofNullable(this.symbols.get(name));
	}
}
