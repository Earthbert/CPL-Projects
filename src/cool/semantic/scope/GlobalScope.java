package cool.semantic.scope;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import cool.semantic.symbol.ClassSymbol;

public class GlobalScope implements Scope<ClassSymbol> {

	private Map<String, ClassSymbol> classes = new LinkedHashMap<>();

	@Override
	public boolean add(ClassSymbol sym) {
		return classes.putIfAbsent(sym.getName(), sym) == null;
	}

	@Override
	public Optional<ClassSymbol> lookup(String name) {
		return this.lookupCurrent(name);
	}

	@Override
	public Optional<ClassSymbol> lookupCurrent(String name) {
		return Optional.ofNullable(classes.get(name));
	}
}
