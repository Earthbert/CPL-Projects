package cool.ast;

import cool.antlr.CoolParserBaseVisitor;
import cool.antlr.CoolParser.*;
import cool.ast.nodes.*;

public class ASTBuilderVisitor extends CoolParserBaseVisitor<ASTNode> {

	@Override
	public ASTNode visitInt(IntContext ctx) {
		return new ASTInteger(ctx.INT().getSymbol());
	}

	@Override
	public ASTNode visitString(StringContext ctx) {
		return new ASTString(ctx.STRING().getSymbol());
	}
	
	@Override
	public ASTNode visitId(IdContext ctx) {
		return new ASTId(ctx.ID().getSymbol());
	}
}
