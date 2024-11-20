package cool.semantic.scope;

import java.util.*;

import cool.semantic.symbol.Symbol;

public interface Scope<T extends Symbol> {

	public boolean add(T sym);

	public Optional<T> lookup(String name);

	public Optional<T> lookupCurrent(String name);

}
