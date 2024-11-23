package cool.semantic.symbol;

import java.util.Map;

public class SelfTypeSymbol extends ClassSymbol {

	public SelfTypeSymbol(final Map<String, IdSymbol> symbols, final Map<String, MethodSymbol> methods) {
		super("SELF_TYPE");
		this.symbols = symbols;
		this.methods = methods;
	}

	public void setMethodMap(final Map<String, MethodSymbol> methods) {
		this.methods = methods;
	}
}
