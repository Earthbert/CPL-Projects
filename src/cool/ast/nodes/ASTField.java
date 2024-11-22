package cool.ast.nodes;

import java.util.Optional;

import cool.ast.ASTVisitor;
import cool.semantic.symbol.IdSymbol;

public class ASTField extends ASTFeature {

	private final ASTDef def;

	private IdSymbol symbol;

	public ASTField(final ASTDef def) {
		this.def = def;
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public ASTDef getDef() {
		return this.def;
	}

	public Optional<IdSymbol> getSymbol() {
		return Optional.ofNullable(this.symbol);
	}

	public void setSymbol(final IdSymbol id) {
		this.symbol = id;
	}

}
