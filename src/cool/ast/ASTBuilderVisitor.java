package cool.ast;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import cool.ast.nodes.*;
import cool.parser.CoolParser.*;
import cool.parser.CoolParserBaseVisitor;

public class ASTBuilderVisitor extends CoolParserBaseVisitor<ASTNode> {

	@Override
	public ASTNode visitProgram(final ProgramContext ctx) {
		return new ASTRoot(ctx.class_().stream().map(this::visit).toList());
	}

	@Override
	public ASTNode visitClass(final ClassContext ctx) {
		return new ASTClass(ctx.CLASS().getSymbol(), new ASTType(ctx.name),
				ctx.parent == null ? Optional.empty() : Optional.of(new ASTType(ctx.parent)),
				ctx.feature().stream().map(this::visit).toList(), ctx);
	}

	@Override
	public ASTNode visitDef(final DefContext ctx) {
		return new ASTDef(ctx.start, new ASTId(ctx.ID().getSymbol()),
				new ASTType(ctx.type),
				ctx.expr() == null ? Optional.empty() : Optional.of((ASTExpression) this.visit(ctx.expr())));
	}

	@Override
	public ASTNode visitMethod(final MethodContext ctx) {
		return new ASTMethod(ctx.start, new ASTId(ctx.name),
				new ASTType(ctx.type),
				ctx.formal().stream().map(this::visit).map(ASTFormal.class::cast).toList(),
				(ASTExpression) this.visit(ctx.expr()));
	}

	@Override
	public ASTNode visitFormal(final FormalContext ctx) {
		return new ASTFormal(ctx.start, new ASTId(ctx.ID().getSymbol()),
				new ASTType(ctx.TYPE().getSymbol()));
	}

	@Override
	public ASTNode visitInt(final IntContext ctx) {
		return new ASTInteger(ctx.INT().getSymbol());
	}

	@Override
	public ASTNode visitString(final StringContext ctx) {
		return new ASTString(ctx.STRING().getSymbol());
	}

	@Override
	public ASTNode visitId(final IdContext ctx) {
		return new ASTId(ctx.ID().getSymbol());
	}

	@Override
	public ASTNode visitFeature(final FeatureContext ctx) {
		if (ctx.method() != null)
			return this.visit(ctx.method());

		return new ASTField((ASTDef) this.visit(ctx.def()));
	}

	@Override
	public ASTNode visitIf(final IfContext ctx) {
		return new ASTIf(ctx.IF().getSymbol(), (ASTExpression) this.visit(ctx.cond),
				(ASTExpression) this.visit(ctx.thenBr),
				(ASTExpression) this.visit(ctx.elseBr));
	}

	@Override
	public ASTNode visitWhile(final WhileContext ctx) {
		return new ASTWhile(ctx.WHILE().getSymbol(), (ASTExpression) this.visit(ctx.cond),
				(ASTExpression) this.visit(ctx.body));
	}

	@Override
	public ASTNode visitLet(final LetContext ctx) {

		final List<DefContext> defs = ctx.def();
		Collections.reverse(defs);
		ASTLet acc = new ASTLet(ctx.LET().getSymbol(), (ASTDef) this.visit(defs.get(0)),
				(ASTExpression) this.visit(ctx.expr()));

		for (int i = 1; i < defs.size(); i++)
			acc = new ASTLet(ctx.LET().getSymbol(), (ASTDef) this.visit(defs.get(i)), acc);

		acc.setLetRoot(true);

		return acc;
	}

	@Override
	public ASTNode visitCase(final CaseContext ctx) {
		return new ASTCase(ctx.CASE().getSymbol(), (ASTExpression) this.visit(ctx.value),
				ctx.type.stream().map(ASTType::new).toList(),
				ctx.id.stream().map(ASTId::new).toList(),
				ctx.branch.stream().map(this::visit).map(ASTExpression.class::cast).toList());
	}

	@Override
	public ASTNode visitBlock(final BlockContext ctx) {
		return new ASTBlock(ctx.start,
				ctx.expr().stream().map(this::visit).map(ASTExpression.class::cast).toList());
	}

	@Override
	public ASTNode visitPar(final ParContext ctx) {
		return this.visit(ctx.expr());
	}

	@Override
	public ASTNode visitAssign(final AssignContext ctx) {
		return new ASTAssignment(ctx.ASSIGN().getSymbol(), new ASTId(ctx.ID().getSymbol()),
				(ASTExpression) this.visit(ctx.expr()));
	}

	@Override
	public ASTNode visitArtihmetic(final ArtihmeticContext ctx) {
		return new ASTArithmetic(ctx.op, (ASTExpression) this.visit(ctx.left),
				(ASTExpression) this.visit(ctx.right));
	}

	@Override
	public ASTNode visitComparison(final ComparisonContext ctx) {
		return new ASTComparison(ctx.op, (ASTExpression) this.visit(ctx.left),
				(ASTExpression) this.visit(ctx.right));
	}

	@Override
	public ASTNode visitNew(final NewContext ctx) {
		return new ASTNew(ctx.NEW().getSymbol(), new ASTType(ctx.TYPE().getSymbol()));
	}

	@Override
	public ASTNode visitThisCall(final ThisCallContext ctx) {
		return new ASTCall(ctx.ID().getSymbol(), new ASTId(ctx.ID().getSymbol()),
				Optional.empty(),
				Optional.empty(),
				ctx.arg.stream().map(this::visit).map(ASTExpression.class::cast).toList());
	}

	@Override
	public ASTNode visitMethodCall(final MethodCallContext ctx) {
		return new ASTCall(ctx.ID().getSymbol(), new ASTId(ctx.ID().getSymbol()),
				Optional.of((ASTExpression) this.visit(ctx.object)),
				ctx.AT() == null ? Optional.empty() : Optional.of(new ASTType(ctx.TYPE().getSymbol())),
				ctx.arg.stream().map(this::visit).map(ASTExpression.class::cast).toList());
	}

	@Override
	public ASTNode visitBoolean(final BooleanContext ctx) {
		return new ASTBoolean(ctx.BOOL_VAL().getSymbol());
	}

	@Override
	public ASTNode visitNot(final NotContext ctx) {
		return new ASTNot(ctx.NOT().getSymbol(), (ASTExpression) this.visit(ctx.expr()));
	}

	@Override
	public ASTNode visitNeg(final NegContext ctx) {
		return new ASTNeg(ctx.NEG().getSymbol(), (ASTExpression) this.visit(ctx.expr()));
	}

	@Override
	public ASTNode visitIsvoid(final IsvoidContext ctx) {
		return new ASTIsVoid(ctx.IS_VOID().getSymbol(), (ASTExpression) this.visit(ctx.expr()));
	}
}
