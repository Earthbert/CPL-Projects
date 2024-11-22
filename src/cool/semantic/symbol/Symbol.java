package cool.semantic.symbol;

abstract public class Symbol {

	protected String name;

	public Symbol(final String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return this.getName();
	}

}
