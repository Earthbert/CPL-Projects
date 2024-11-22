package cool.semantic.scope;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import cool.semantic.symbol.ClassSymbol;

public class GlobalScope implements Scope<ClassSymbol> {

	private final Map<String, ClassSymbol> classes = new LinkedHashMap<>();

	@Override
	public boolean add(final ClassSymbol sym) {
		return this.classes.putIfAbsent(sym.getName(), sym) == null;
	}

	@Override
	public Optional<ClassSymbol> lookup(final String name) {
		return this.lookupCurrent(name);
	}

	@Override
	public Optional<ClassSymbol> lookupCurrent(final String name) {
		return Optional.ofNullable(this.classes.get(name));
	}
}
