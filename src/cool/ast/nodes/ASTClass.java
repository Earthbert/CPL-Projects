package cool.ast.nodes;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.antlr.v4.runtime.Token;

import cool.antlr.CoolParser.ClassContext;
import cool.ast.ASTVisitor;
import cool.utils.Utils;

public class ASTClass extends ASTNode {

	final private Token token;

	final private ASTType type;
	final private Optional<ASTType> parent;

	final private List<ASTFeature> features;

	final private ClassContext ctx;

	public ASTClass(Token token, ASTType name, Optional<ASTType> parent, List<ASTNode> features, ClassContext ctx) {
		this.token = token;
		this.type = name;
		this.parent = parent;
		this.features = Utils.castList(features, ASTFeature.class);
		this.ctx = ctx;
	}

	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Token getToken() {
		return token;
	}

	public ASTType getType() {
		return type;
	}

	public Optional<ASTType> getParent() {
		return parent;
	}

	public List<ASTFeature> getFeatures() {
		return Collections.unmodifiableList(features);
	}

	public ClassContext getCtx() {
		return ctx;
	}
}
