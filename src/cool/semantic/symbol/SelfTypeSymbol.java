package cool.semantic.symbol;

import java.util.Optional;

import cool.utils.Utils;

public class SelfTypeSymbol extends ClassSymbol {

	private final ClassSymbol classSymbol;

	public SelfTypeSymbol(final ClassSymbol classSymbol) {
		super(Utils.SELF_TYPE);
		this.classSymbol = classSymbol;
	}

	@Override
	public ClassSymbol getParent() {
		return this.classSymbol.getParent();
	}

	@Override
	public Optional<SelfTypeSymbol> getSelfType() {
		return Optional.empty();
	}

	@Override
	public boolean hasParent(final ClassSymbol parent) {
		if (this.classSymbol == parent)
			return true;
		return this.classSymbol.hasParent(parent);
	}

	@Override
	public boolean isSuperClassOf(final ClassSymbol child) {
		return false;
	}

	@Override
	public ClassSymbol join(final ClassSymbol other) {
		return this.classSymbol.join(other);
	}

	@Override
	public Optional<IdSymbol> lookup(final String name) {
		return this.classSymbol.lookup(name);
	}

	@Override
	public Optional<IdSymbol> lookupCurrent(final String name) {
		return this.classSymbol.lookupCurrent(name);
	}

	@Override
	public Optional<MethodSymbol> lookupCurrentMethod(final String name) {
		return this.classSymbol.lookupCurrentMethod(name);
	}

	@Override
	public Optional<MethodSymbol> lookupMethod(final String name) {
		return this.classSymbol.lookupMethod(name);
	}

	@Override
	public void setParent(final ClassSymbol parent) {
		this.classSymbol.setParent(parent);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof final SelfTypeSymbol other) {
			return this.classSymbol.isSuperClassOf(other.classSymbol);
		}
		if (obj instanceof final ClassSymbol other) {
			return this.classSymbol.isSuperClassOf(other);
		}
		return false;
	}
}
