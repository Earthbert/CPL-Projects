package cool.ast;

import cool.parser.CoolParserBaseVisitor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import cool.parser.CoolParser.*;
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

	@Override
	public ASTNode visitIf(IfContext ctx) {
		return new ASTIf(ctx.start, (ASTExpression) visit(ctx.cond), (ASTExpression) visit(ctx.thenBr),
				(ASTExpression) visit(ctx.elseBr));
	}

	@Override
	public ASTNode visitWhile(WhileContext ctx) {
		return new ASTWhile(ctx.start, (ASTExpression) visit(ctx.cond), (ASTExpression) visit(ctx.body));
	}

	@Override
	public ASTNode visitLet(LetContext ctx) {
		List<DefContext> defs = ctx.def();
		Collections.reverse(defs);
		ASTLet acc = new ASTLet(ctx.start, (ASTDef) visit(defs.get(0)), (ASTExpression) visit(ctx.expr()));

		defs.stream().skip(1).forEachOrdered((def) -> new ASTLet(ctx.start, (ASTDef) visit(def), (ASTExpression) acc));

		return acc;
	}
}
