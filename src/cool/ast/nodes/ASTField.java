package cool.ast.nodes;

import cool.ast.ASTVisitor;
import cool.semantic.symbol.IdSymbol;

public class ASTField extends ASTFeature {

	private ASTDef def;

	private IdSymbol symbol;

	public ASTField(ASTDef def) {
		this.def = def;
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTDef getDef() {
		return def;
	}

	public IdSymbol getSymbol() {
		return symbol;
	}

	public void setSymbol(IdSymbol id) {
		this.symbol = id;
	}

}
