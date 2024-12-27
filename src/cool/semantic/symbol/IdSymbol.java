package cool.semantic.symbol;

public class IdSymbol extends Symbol {

	protected ClassSymbol valueType;

	protected IDSymbolType type;

	public IdSymbol(final String name, final IDSymbolType type) {
		super(name);
		this.type = type;
	}

	public IdSymbol(final String name, final ClassSymbol valueType, final IDSymbolType type) {
		this(name, type);
		this.valueType = valueType;
	}

	public ClassSymbol getValueType() {
		return this.valueType;
	}

	public void setValueType(final ClassSymbol valueType) {
		this.valueType = valueType;
	}

}
