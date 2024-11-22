package cool.ast.nodes;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.antlr.v4.runtime.Token;

import cool.ast.ASTVisitor;
import cool.parser.CoolParser.ClassContext;
import cool.semantic.symbol.ClassSymbol;
import cool.utils.Utils;

public class ASTClass extends ASTNode {

	final private Token token;

	final private ASTType type;
	final private Optional<ASTType> parent;

	final private List<ASTFeature> features;

	final private ClassContext ctx;

	private ClassSymbol symbol;

	public ASTClass(final Token token, final ASTType name, final Optional<ASTType> parent, final List<ASTNode> features,
			final ClassContext ctx) {
		this.token = token;
		this.type = name;
		this.parent = parent;
		this.features = Utils.castList(features, ASTFeature.class);
		this.ctx = ctx;
	}

	@Override
	public <T> T accept(final ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Token getToken() {
		return this.token;
	}

	public ASTType getType() {
		return this.type;
	}

	public Optional<ASTType> getParent() {
		return this.parent;
	}

	public List<ASTFeature> getFeatures() {
		return Collections.unmodifiableList(this.features);
	}

	public ClassContext getCtx() {
		return this.ctx;
	}

	public Optional<ClassSymbol> getSymbol() {
		return Optional.ofNullable(this.symbol);
	}

	public void setSymbol(final ClassSymbol symbol) {
		this.symbol = symbol;
	}

}
