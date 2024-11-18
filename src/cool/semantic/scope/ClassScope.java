package cool.semantic.scope;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import cool.semantic.symbol.Symbol;

public class ClassScope extends Scope {

	Map<String, Symbol> methods = new LinkedHashMap<>();

	public ClassScope(Scope parent) {
		super(parent);
	}

	public boolean addMethod(Symbol method) {
		return methods.putIfAbsent(method.getName(), method) == null;
	}

	public Optional<Symbol> lookupMethod(String name) {
		Symbol sym = methods.get(name);

		if (sym != null)
			return Optional.of(sym);

		return parent.map(p -> p.lookup(name)).orElse(Optional.empty());
	}
}
