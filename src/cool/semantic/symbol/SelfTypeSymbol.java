package cool.semantic.symbol;

import java.util.Optional;

import cool.utils.Utils;

public class SelfTypeSymbol extends ClassSymbol {

	private ClassSymbol classSymbol;

	public SelfTypeSymbol() {
		super();
		this.name = Utils.SELF_TYPE;
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
	public boolean isSuperClassOf(final ClassSymbol child) {
		return child instanceof SelfTypeSymbol;
	}

	@Override
	public ClassSymbol mostCommonAncestor(final ClassSymbol other) {
		if (other instanceof SelfTypeSymbol)
			return this;
		return this.getClassSymbol().mostCommonAncestor(other);
	}

	public void setClassSymbol(final ClassSymbol classSymbol) {
		this.classSymbol = classSymbol;
	}

	public ClassSymbol getClassSymbol() {
		return this.classSymbol;
	}

	@Override
	public String getClassName() {
		return this.getClassSymbol().getClassName();
	}
}
