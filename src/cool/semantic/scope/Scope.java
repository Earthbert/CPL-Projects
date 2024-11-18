package cool.semantic.scope;

import java.util.*;

import cool.semantic.symbol.Symbol;

public class Scope {

	private Map<String, Symbol> symbols = new LinkedHashMap<>();

	protected Optional<Scope> parent;

	public Scope(Scope parent) {
		this.parent = Optional.ofNullable(parent);
	}

	public boolean add(Symbol sym) {
		return symbols.putIfAbsent(sym.getName(), sym) == null;
	}

	public Optional<Symbol> lookup(String name) {
		Symbol sym = symbols.get(name);

		if (sym != null)
			return Optional.of(sym);

		return parent.map(p -> p.lookup(name)).orElse(Optional.empty());
	}

	public Optional<Scope> getParent() {
		return parent;
	}

}
