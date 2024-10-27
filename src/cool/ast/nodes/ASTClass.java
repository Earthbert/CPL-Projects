package cool.ast.nodes;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.antlr.v4.runtime.Token;

import cool.antlr.CoolParser.ClassContext;
import cool.utils.Utils;

public class ASTClass extends ASTNode {

	final private Token token;

	final private String name;
	final private String parent;

	final private List<ASTClassMember> members;

	final private ClassContext ctx;

	public ASTClass(Token token, String name, Optional<String> parent, List<ASTNode> members, ClassContext ctx) {
		this.token = token;
		this.name = name;
		this.parent = parent.orElse("Object");
		this.members = Utils.castList(members, ASTClassMember.class);
		this.ctx = ctx;
	}

	public Token getToken() {
		return token;
	}

	public String getName() {
		return name;
	}

	public String getParent() {
		return parent;
	}

	public List<ASTClassMember> getMembers() {
		return Collections.unmodifiableList(members);
	}

	public ClassContext getCtx() {
		return ctx;
	}
}
