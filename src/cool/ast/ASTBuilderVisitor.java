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
		return new ASTClass(ctx.start, new ASTType(ctx.name),
				ctx.parent == null ? Optional.empty() : Optional.of(new ASTType(ctx.parent)),
				ctx.feature().stream().map(this::visit).collect(Collectors.toList()), ctx);
	}

	@Override
	public ASTNode visitDef(DefContext ctx) {
		return new ASTDef(ctx.start, new ASTId(ctx.ID().getSymbol()),
				new ASTType(ctx.type), (ASTExpression) visit(ctx.expr()));
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

	@Override
	public ASTNode visitFeature(FeatureContext ctx) {
		if (ctx.method() != null)
			return visit(ctx.method());

		return new ASTField((ASTDef) visit(ctx.def()));
	}
}
