package cool.ast;

import cool.parser.CoolParserBaseVisitor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import cool.parser.CoolParser.*;
import cool.ast.nodes.*;

public class ASTBuilderVisitor extends CoolParserBaseVisitor<ASTNode> {

	@Override
	public ASTNode visitProgram(ProgramContext ctx) {
		return new ASTRoot(ctx.class_().stream().map(this::visit).toList());
	}

	@Override
	public ASTNode visitClass(ClassContext ctx) {
		return new ASTClass(ctx.CLASS().getSymbol(), new ASTType(ctx.name),
				ctx.parent == null ? Optional.empty() : Optional.of(new ASTType(ctx.parent)),
				ctx.feature().stream().map(this::visit).toList(), ctx);
	}

	@Override
	public ASTNode visitDef(DefContext ctx) {
		return new ASTDef(ctx.start, new ASTId(ctx.ID().getSymbol()),
				new ASTType(ctx.type),
				ctx.expr() == null ? Optional.empty() : Optional.of((ASTExpression) visit(ctx.expr())));
	}

	@Override
	public ASTNode visitMethod(MethodContext ctx) {
		return new ASTMethod(ctx.start, new ASTId(ctx.name),
				new ASTType(ctx.type),
				ctx.formal().stream().map(this::visit).map(ASTFormal.class::cast).toList(),
				(ASTExpression) visit(ctx.expr()));
	}

	@Override
	public ASTNode visitFormal(FormalContext ctx) {
		return new ASTFormal(ctx.start, new ASTId(ctx.ID().getSymbol()),
				new ASTType(ctx.TYPE().getSymbol()));
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
		return new ASTIf(ctx.IF().getSymbol(), (ASTExpression) visit(ctx.cond), (ASTExpression) visit(ctx.thenBr),
				(ASTExpression) visit(ctx.elseBr));
	}

	@Override
	public ASTNode visitWhile(WhileContext ctx) {
		return new ASTWhile(ctx.WHILE().getSymbol(), (ASTExpression) visit(ctx.cond), (ASTExpression) visit(ctx.body));
	}

	@Override
	public ASTNode visitLet(LetContext ctx) {
		List<DefContext> defs = ctx.def();
		Collections.reverse(defs);
		ASTLet acc = new ASTLet(ctx.LET().getSymbol(), (ASTDef) visit(defs.get(0)),
				(ASTExpression) visit(ctx.expr()));

		defs.stream().skip(1).forEachOrdered((def) -> new ASTLet(ctx.start, (ASTDef) visit(def),
				(ASTExpression) acc));

		return acc;
	}

	@Override
	public ASTNode visitCase(CaseContext ctx) {
		return new ASTCase(ctx.CASE().getSymbol(), (ASTExpression) visit(ctx.value),
				ctx.type.stream().map(ASTType::new).toList(),
				ctx.id.stream().map(ASTId::new).toList(),
				ctx.branch.stream().map(this::visit).map(ASTExpression.class::cast).toList());
	}

	@Override
	public ASTNode visitBlock(BlockContext ctx) {
		return new ASTBlock(ctx.start,
				ctx.expr().stream().map(this::visit).map(ASTExpression.class::cast).toList());
	}

	@Override
	public ASTNode visitPar(ParContext ctx) {
		return visit(ctx.expr());
	}

	@Override
	public ASTNode visitAssign(AssignContext ctx) {
		return new ASTAssignment(ctx.ASSIGN().getSymbol(), new ASTId(ctx.ID().getSymbol()),
				(ASTExpression) visit(ctx.expr()));
	}

	@Override
	public ASTNode visitArtihmetic(ArtihmeticContext ctx) {
		return new ASTArithmetic(ctx.op, (ASTExpression) visit(ctx.left),
				(ASTExpression) visit(ctx.right));
	}

	@Override
	public ASTNode visitComparison(ComparisonContext ctx) {
		return new ASTComparison(ctx.op, (ASTExpression) visit(ctx.left),
				(ASTExpression) visit(ctx.right));
	}

	@Override
	public ASTNode visitNew(NewContext ctx) {
		return new ASTNew(ctx.NEW().getSymbol(), new ASTType(ctx.TYPE().getSymbol()));
	}

	@Override
	public ASTNode visitThisCall(ThisCallContext ctx) {
		return new ASTCall(ctx.ID().getSymbol(), new ASTId(ctx.ID().getSymbol()), Optional.empty(),
				ctx.AT() == null ? Optional.empty() : Optional.of(new ASTType(ctx.TYPE().getSymbol())),
				ctx.expr().stream().map(this::visit).map(ASTExpression.class::cast).toList());
	}

	@Override
	public ASTNode visitMethodCall(MethodCallContext ctx) {
		return new ASTCall(ctx.ID().getSymbol(), new ASTId(ctx.ID().getSymbol()),
				Optional.of((ASTExpression) visit(ctx.object)),
				ctx.AT() == null ? Optional.empty() : Optional.of(new ASTType(ctx.TYPE().getSymbol())),
				ctx.expr().stream().map(this::visit).map(ASTExpression.class::cast).toList());
	}

	@Override
	public ASTNode visitBoolean(BooleanContext ctx) {
		return new ASTBoolean(ctx.BOOL_VAL().getSymbol());
	}

	@Override
	public ASTNode visitNot(NotContext ctx) {
		return new ASTNot(ctx.NOT().getSymbol(), (ASTExpression) visit(ctx.expr()));
	}

	@Override
	public ASTNode visitNeg(NegContext ctx) {
		return new ASTNeg(ctx.NEG().getSymbol(), (ASTExpression) visit(ctx.expr()));
	}

	@Override
	public ASTNode visitIsvoid(IsvoidContext ctx) {
		return new ASTIsVoid(ctx.IS_VOID().getSymbol(), (ASTExpression) visit(ctx.expr()));
	}

	@Override
	public ASTNode visitSelf(SelfContext ctx) {
		return new ASTSelf(ctx.SELF().getSymbol());
	}
}
