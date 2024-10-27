package cool.ast;

import cool.antlr.CoolParserBaseVisitor;

import java.util.Optional;
import java.util.stream.Collectors;

import cool.antlr.CoolParser.*;
import cool.ast.nodes.*;

public class ASTBuilderVisitor extends CoolParserBaseVisitor<ASTNode> {

	@Override
	public ASTNode visitProgram(ProgramContext ctx) {
		return new ASTRoot(ctx.class_().stream().map(this::visit).collect(Collectors.toList()));
	}

	@Override
	public ASTNode visitClass(ClassContext ctx) {
		System.out.println(ctx.children);
		return new ASTClass(ctx.CLASS().getSymbol(), ctx.name.getText(),
				ctx.parent == null ? Optional.empty() : Optional.of(ctx.parent.getText()),
				ctx.member().stream().map(this::visit).collect(Collectors.toList()), ctx);
	}

	@Override
	public ASTNode visitDef(DefContext ctx) {
		return super.visitDef(ctx);
	}

	@Override
	public ASTNode visitMethod(MethodContext ctx) {
		return super.visitMethod(ctx);
	}

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
