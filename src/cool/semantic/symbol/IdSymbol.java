package cool.semantic.symbol;

public class IdSymbol extends Symbol {

	protected ClassSymbol type;

	public IdSymbol(final String name) {
		super(name);
	}

	public ClassSymbol getType() {
		return this.type;
	}

	public void setType(final ClassSymbol type) {
		this.type = type;
	}

}
