package cool.semantic.symbol;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import cool.semantic.scope.Scope;

public class MethodSymbol extends Symbol implements Scope<IdSymbol> {

	private final ClassSymbol returnType;

	private final ClassSymbol classSymbol;

	private final Map<String, IdSymbol> symbols = new LinkedHashMap<>();

	private Integer tempLocalCount = 0;

	public MethodSymbol(final String name, final ClassSymbol returnType, final ClassSymbol outerScope) {
		super(name);
		this.returnType = returnType;
		this.classSymbol = outerScope;
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

		return this.classSymbol.lookup(name);
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

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof final MethodSymbol other) {
			return this.getName().equals(other.getName());
		}
		return false;
	}

	public Integer getTempLocalCount() {
		return this.tempLocalCount;
	}

	public void setTempLocalCount(final Integer tempLocalCount) {
		this.tempLocalCount = tempLocalCount;
	}

	public ClassSymbol getClassSymbol() {
		return this.classSymbol;
	}
}
