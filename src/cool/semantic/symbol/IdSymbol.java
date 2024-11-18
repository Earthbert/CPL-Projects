package cool.semantic.symbol;

public class IdSymbol extends Symbol {

	protected ClassSymbol type;

	public IdSymbol(String name) {
		super(name);
	}

	public ClassSymbol getType() {
		return type;
	}

	public void setType(ClassSymbol type) {
		this.type = type;
	}

}
