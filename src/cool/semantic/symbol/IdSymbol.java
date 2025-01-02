package cool.semantic.symbol;

public class IdSymbol extends Symbol {

	protected ClassSymbol valueType;

	protected IDSymbolType type;

	private Integer offset;

	public IdSymbol(final String name, final IDSymbolType type) {
		super(name);
		this.type = type;
	}

	public IdSymbol(final String name, final ClassSymbol valueType, final IDSymbolType type) {
		this(name, type);
		this.valueType = valueType;
	}

	public Integer getOffset() {
		return this.offset;
	}

	public void setOffset(final Integer offset) {
		this.offset = offset;
	}

	public ClassSymbol getValueType() {
		return this.valueType;
	}

	public void setValueType(final ClassSymbol valueType) {
		this.valueType = valueType;
	}

	public IDSymbolType getType() {
		return this.type;
	}

	public void setType(final IDSymbolType type) {
		this.type = type;
	}
}
