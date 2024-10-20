// Generated from c:/Users/earthbert/University/CPL/Cool-AST/CoolLangParser.g4 by ANTLR 4.13.1
package cpl.antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CoolLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, THEN=2, ELSE=3, FI=4, WHILE=5, LOOP=6, POOL=7, CASE=8, OF=9, ESAC=10, 
		LET=11, IN=12, IS_VOID=13, NEW=14, CLASS=15, INHERITS=16, SELF=17, BOOL_VAL=18, 
		RIGHT_ARROW=19, AT=20, COLON=21, SEMICOLON=22, OPEN_PAR=23, CLOSE_PAR=24, 
		COMMA=25, DOT=26, OPEN_BRACE=27, CLOSE_BRACE=28, OPEN_BRACKET=29, CLOSE_BRACKET=30, 
		INT=31, FLOAT=32, ID=33, TYPE=34, ASSIGN=35, PLUS=36, MINUS=37, TIMES=38, 
		DIV=39, NEG=40, NOT=41, EQ=42, LT=43, LE=44, STRING=45, BLOCK_COMMENT=46, 
		LINE_COMMENT=47, WS=48;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_def = 2, RULE_method = 3, RULE_class = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "def", "method", "class"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "'=>'", "'@'", "':'", "';'", 
			"'('", "')'", "','", "'.'", "'{'", "'}'", "'['", "']'", null, null, null, 
			null, "'<-'", "'+'", "'-'", "'*'", "'/'", "'~'", "'not'", "'='", "'<'", 
			"'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "THEN", "ELSE", "FI", "WHILE", "LOOP", "POOL", "CASE", "OF", 
			"ESAC", "LET", "IN", "IS_VOID", "NEW", "CLASS", "INHERITS", "SELF", "BOOL_VAL", 
			"RIGHT_ARROW", "AT", "COLON", "SEMICOLON", "OPEN_PAR", "CLOSE_PAR", "COMMA", 
			"DOT", "OPEN_BRACE", "CLOSE_BRACE", "OPEN_BRACKET", "CLOSE_BRACKET", 
			"INT", "FLOAT", "ID", "TYPE", "ASSIGN", "PLUS", "MINUS", "TIMES", "DIV", 
			"NEG", "NOT", "EQ", "LT", "LE", "STRING", "BLOCK_COMMENT", "LINE_COMMENT", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CoolLangParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CoolLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CoolLangParser.EOF, 0); }
		public List<ClassContext> class_() {
			return getRuleContexts(ClassContext.class);
		}
		public ClassContext class_(int i) {
			return getRuleContext(ClassContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolLangParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolLangParser.SEMICOLON, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(10);
				class_();
				setState(11);
				match(SEMICOLON);
				}
				}
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(18);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MinusContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(CoolLangParser.MINUS, 0); }
		public MinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(CoolLangParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IsvoidContext extends ExprContext {
		public TerminalNode IS_VOID() { return getToken(CoolLangParser.IS_VOID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IsvoidContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitIsvoid(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LtContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT() { return getToken(CoolLangParser.LT, 0); }
		public LtContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitLt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatContext extends ExprContext {
		public TerminalNode FLOAT() { return getToken(CoolLangParser.FLOAT, 0); }
		public FloatContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends ExprContext {
		public TerminalNode WHILE() { return getToken(CoolLangParser.WHILE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LOOP() { return getToken(CoolLangParser.LOOP, 0); }
		public TerminalNode POOL() { return getToken(CoolLangParser.POOL, 0); }
		public WhileContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DIV() { return getToken(CoolLangParser.DIV, 0); }
		public DivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegContext extends ExprContext {
		public TerminalNode NEG() { return getToken(CoolLangParser.NEG, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitNeg(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends ExprContext {
		public TerminalNode NOT() { return getToken(CoolLangParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TimesContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode TIMES() { return getToken(CoolLangParser.TIMES, 0); }
		public TimesContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitTimes(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetContext extends ExprContext {
		public TerminalNode LET() { return getToken(CoolLangParser.LET, 0); }
		public List<DefContext> def() {
			return getRuleContexts(DefContext.class);
		}
		public DefContext def(int i) {
			return getRuleContext(DefContext.class,i);
		}
		public TerminalNode IN() { return getToken(CoolLangParser.IN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolLangParser.COMMA, i);
		}
		public LetContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ExprContext {
		public TerminalNode OPEN_BRACE() { return getToken(CoolLangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(CoolLangParser.CLOSE_BRACE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolLangParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolLangParser.SEMICOLON, i);
		}
		public BlockContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(CoolLangParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ExprContext {
		public TerminalNode IF() { return getToken(CoolLangParser.IF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode THEN() { return getToken(CoolLangParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(CoolLangParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(CoolLangParser.FI, 0); }
		public IfContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CaseContext extends ExprContext {
		public TerminalNode CASE() { return getToken(CoolLangParser.CASE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OF() { return getToken(CoolLangParser.OF, 0); }
		public TerminalNode ESAC() { return getToken(CoolLangParser.ESAC, 0); }
		public List<TerminalNode> ID() { return getTokens(CoolLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CoolLangParser.ID, i);
		}
		public List<TerminalNode> COLON() { return getTokens(CoolLangParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(CoolLangParser.COLON, i);
		}
		public List<TerminalNode> TYPE() { return getTokens(CoolLangParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CoolLangParser.TYPE, i);
		}
		public List<TerminalNode> RIGHT_ARROW() { return getTokens(CoolLangParser.RIGHT_ARROW); }
		public TerminalNode RIGHT_ARROW(int i) {
			return getToken(CoolLangParser.RIGHT_ARROW, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolLangParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolLangParser.SEMICOLON, i);
		}
		public CaseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitCase(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParContext extends ExprContext {
		public TerminalNode OPEN_PAR() { return getToken(CoolLangParser.OPEN_PAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(CoolLangParser.CLOSE_PAR, 0); }
		public ParContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitPar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorContext extends ExprContext {
		public TerminalNode NEW() { return getToken(CoolLangParser.NEW, 0); }
		public TerminalNode TYPE() { return getToken(CoolLangParser.TYPE, 0); }
		public ConstructorContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitConstructor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(CoolLangParser.EQ, 0); }
		public EqContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitEq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ThisCallContext extends ExprContext {
		public TerminalNode ID() { return getToken(CoolLangParser.ID, 0); }
		public TerminalNode OPEN_PAR() { return getToken(CoolLangParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(CoolLangParser.CLOSE_PAR, 0); }
		public TerminalNode SELF() { return getToken(CoolLangParser.SELF, 0); }
		public TerminalNode AT() { return getToken(CoolLangParser.AT, 0); }
		public TerminalNode TYPE() { return getToken(CoolLangParser.TYPE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolLangParser.COMMA, i);
		}
		public ThisCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitThisCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(CoolLangParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlusContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(CoolLangParser.PLUS, 0); }
		public PlusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ExprContext {
		public TerminalNode BOOL_VAL() { return getToken(CoolLangParser.BOOL_VAL, 0); }
		public BooleanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelfContext extends ExprContext {
		public TerminalNode SELF() { return getToken(CoolLangParser.SELF, 0); }
		public SelfContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitSelf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LeContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LE() { return getToken(CoolLangParser.LE, 0); }
		public LeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitLe(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ExprContext {
		public TerminalNode ID() { return getToken(CoolLangParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolLangParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DOT() { return getToken(CoolLangParser.DOT, 0); }
		public TerminalNode ID() { return getToken(CoolLangParser.ID, 0); }
		public TerminalNode OPEN_PAR() { return getToken(CoolLangParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(CoolLangParser.CLOSE_PAR, 0); }
		public TerminalNode AT() { return getToken(CoolLangParser.AT, 0); }
		public TerminalNode TYPE() { return getToken(CoolLangParser.TYPE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CoolLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolLangParser.COMMA, i);
		}
		public MethodCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(21);
				match(ID);
				}
				break;
			case 2:
				{
				_localctx = new SelfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				match(SELF);
				}
				break;
			case 3:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				match(INT);
				}
				break;
			case 4:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(FLOAT);
				}
				break;
			case 5:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				match(STRING);
				}
				break;
			case 6:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(BOOL_VAL);
				}
				break;
			case 7:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(27);
				match(LET);
				setState(28);
				def();
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(29);
					match(COMMA);
					setState(30);
					def();
					}
					}
					setState(35);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(36);
				match(IN);
				setState(37);
				expr(20);
				}
				break;
			case 8:
				{
				_localctx = new IfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(39);
				match(IF);
				setState(40);
				expr(0);
				setState(41);
				match(THEN);
				setState(42);
				expr(0);
				setState(43);
				match(ELSE);
				setState(44);
				expr(0);
				setState(45);
				match(FI);
				}
				break;
			case 9:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(47);
				match(WHILE);
				setState(48);
				expr(0);
				setState(49);
				match(LOOP);
				setState(50);
				expr(0);
				setState(51);
				match(POOL);
				}
				break;
			case 10:
				{
				_localctx = new CaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(53);
				match(CASE);
				setState(54);
				expr(0);
				setState(55);
				match(OF);
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(56);
					match(ID);
					setState(57);
					match(COLON);
					setState(58);
					match(TYPE);
					setState(59);
					match(RIGHT_ARROW);
					setState(60);
					expr(0);
					setState(61);
					match(SEMICOLON);
					}
					}
					setState(65); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(67);
				match(ESAC);
				}
				break;
			case 11:
				{
				_localctx = new BlockContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69);
				match(OPEN_BRACE);
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(70);
					expr(0);
					setState(71);
					match(SEMICOLON);
					}
					}
					setState(75); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 38498083432738L) != 0) );
				setState(77);
				match(CLOSE_BRACE);
				}
				break;
			case 12:
				{
				_localctx = new ParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				match(OPEN_PAR);
				setState(80);
				expr(0);
				setState(81);
				match(CLOSE_PAR);
				}
				break;
			case 13:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83);
				match(ID);
				setState(84);
				match(ASSIGN);
				setState(85);
				expr(14);
				}
				break;
			case 14:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				match(NOT);
				setState(87);
				expr(6);
				}
				break;
			case 15:
				{
				_localctx = new NegContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				match(NEG);
				setState(89);
				expr(5);
				}
				break;
			case 16:
				{
				_localctx = new IsvoidContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				match(IS_VOID);
				setState(91);
				expr(4);
				}
				break;
			case 17:
				{
				_localctx = new ConstructorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92);
				match(NEW);
				setState(93);
				match(TYPE);
				}
				break;
			case 18:
				{
				_localctx = new ThisCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SELF) {
					{
					setState(94);
					match(SELF);
					}
				}

				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AT) {
					{
					setState(97);
					match(AT);
					setState(98);
					match(TYPE);
					}
				}

				setState(101);
				match(ID);
				setState(102);
				match(OPEN_PAR);
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 38498083432738L) != 0)) {
					{
					setState(103);
					expr(0);
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(104);
						match(COMMA);
						setState(105);
						expr(0);
						}
						}
						setState(110);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(113);
				match(CLOSE_PAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(158);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(156);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(116);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(117);
						match(PLUS);
						setState(118);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(119);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(120);
						match(MINUS);
						setState(121);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new TimesContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(122);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(123);
						match(TIMES);
						setState(124);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new DivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(125);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(126);
						match(DIV);
						setState(127);
						expr(11);
						}
						break;
					case 5:
						{
						_localctx = new LtContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(128);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(129);
						match(LT);
						setState(130);
						expr(10);
						}
						break;
					case 6:
						{
						_localctx = new LeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(132);
						match(LE);
						setState(133);
						expr(9);
						}
						break;
					case 7:
						{
						_localctx = new EqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(135);
						match(EQ);
						setState(136);
						expr(8);
						}
						break;
					case 8:
						{
						_localctx = new MethodCallContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(137);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(140);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==AT) {
							{
							setState(138);
							match(AT);
							setState(139);
							match(TYPE);
							}
						}

						setState(142);
						match(DOT);
						setState(143);
						match(ID);
						setState(144);
						match(OPEN_PAR);
						setState(153);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 38498083432738L) != 0)) {
							{
							setState(145);
							expr(0);
							setState(150);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(146);
								match(COMMA);
								setState(147);
								expr(0);
								}
								}
								setState(152);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(155);
						match(CLOSE_PAR);
						}
						break;
					}
					} 
				}
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CoolLangParser.ID, 0); }
		public TerminalNode COLON() { return getToken(CoolLangParser.COLON, 0); }
		public TerminalNode TYPE() { return getToken(CoolLangParser.TYPE, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolLangParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(ID);
			setState(162);
			match(COLON);
			setState(163);
			match(TYPE);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(164);
				match(ASSIGN);
				setState(165);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(CoolLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CoolLangParser.ID, i);
		}
		public TerminalNode OPEN_PAR() { return getToken(CoolLangParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(CoolLangParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COLON() { return getTokens(CoolLangParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(CoolLangParser.COLON, i);
		}
		public List<TerminalNode> TYPE() { return getTokens(CoolLangParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CoolLangParser.TYPE, i);
		}
		public TerminalNode OPEN_BRACE() { return getToken(CoolLangParser.OPEN_BRACE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_BRACE() { return getToken(CoolLangParser.CLOSE_BRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CoolLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolLangParser.COMMA, i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(ID);
			setState(169);
			match(OPEN_PAR);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(170);
				match(ID);
				setState(171);
				match(COLON);
				setState(172);
				match(TYPE);
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(173);
					match(COMMA);
					setState(174);
					match(ID);
					setState(175);
					match(COLON);
					setState(176);
					match(TYPE);
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(184);
			match(CLOSE_PAR);
			setState(185);
			match(COLON);
			setState(186);
			match(TYPE);
			setState(187);
			match(OPEN_BRACE);
			setState(188);
			expr(0);
			setState(189);
			match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(CoolLangParser.CLASS, 0); }
		public List<TerminalNode> TYPE() { return getTokens(CoolLangParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CoolLangParser.TYPE, i);
		}
		public TerminalNode OPEN_BRACE() { return getToken(CoolLangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(CoolLangParser.CLOSE_BRACE, 0); }
		public TerminalNode INHERITS() { return getToken(CoolLangParser.INHERITS, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolLangParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolLangParser.SEMICOLON, i);
		}
		public List<DefContext> def() {
			return getRuleContexts(DefContext.class);
		}
		public DefContext def(int i) {
			return getRuleContext(DefContext.class,i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public ClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolLangParserVisitor ) return ((CoolLangParserVisitor<? extends T>)visitor).visitClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassContext class_() throws RecognitionException {
		ClassContext _localctx = new ClassContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(CLASS);
			setState(192);
			match(TYPE);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INHERITS) {
				{
				setState(193);
				match(INHERITS);
				setState(194);
				match(TYPE);
				}
			}

			setState(197);
			match(OPEN_BRACE);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(200);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(198);
					def();
					}
					break;
				case 2:
					{
					setState(199);
					method();
					}
					break;
				}
				setState(202);
				match(SEMICOLON);
				}
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(209);
			match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00010\u00d4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u000e\b\u0000\n\u0000\f\u0000"+
		"\u0011\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001 \b\u0001\n\u0001\f\u0001#\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001@\b\u0001\u000b\u0001"+
		"\f\u0001A\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0004\u0001J\b\u0001\u000b\u0001\f\u0001K\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001`\b"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001d\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001k\b\u0001\n\u0001"+
		"\f\u0001n\t\u0001\u0003\u0001p\b\u0001\u0001\u0001\u0003\u0001s\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001\u008d\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001\u0095\b\u0001\n\u0001\f\u0001\u0098"+
		"\t\u0001\u0003\u0001\u009a\b\u0001\u0001\u0001\u0005\u0001\u009d\b\u0001"+
		"\n\u0001\f\u0001\u00a0\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002\u00a7\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u0003\u00b2\b\u0003\n\u0003\f\u0003\u00b5\t\u0003\u0003\u0003"+
		"\u00b7\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u00c4\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"\u00c9\b\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u00cd\b\u0004\n\u0004"+
		"\f\u0004\u00d0\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0000\u0001"+
		"\u0002\u0005\u0000\u0002\u0004\u0006\b\u0000\u0000\u00f8\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0002r\u0001\u0000\u0000\u0000\u0004\u00a1\u0001\u0000"+
		"\u0000\u0000\u0006\u00a8\u0001\u0000\u0000\u0000\b\u00bf\u0001\u0000\u0000"+
		"\u0000\n\u000b\u0003\b\u0004\u0000\u000b\f\u0005\u0016\u0000\u0000\f\u000e"+
		"\u0001\u0000\u0000\u0000\r\n\u0001\u0000\u0000\u0000\u000e\u0011\u0001"+
		"\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000\u000f\u0010\u0001\u0000"+
		"\u0000\u0000\u0010\u0012\u0001\u0000\u0000\u0000\u0011\u000f\u0001\u0000"+
		"\u0000\u0000\u0012\u0013\u0005\u0000\u0000\u0001\u0013\u0001\u0001\u0000"+
		"\u0000\u0000\u0014\u0015\u0006\u0001\uffff\uffff\u0000\u0015s\u0005!\u0000"+
		"\u0000\u0016s\u0005\u0011\u0000\u0000\u0017s\u0005\u001f\u0000\u0000\u0018"+
		"s\u0005 \u0000\u0000\u0019s\u0005-\u0000\u0000\u001as\u0005\u0012\u0000"+
		"\u0000\u001b\u001c\u0005\u000b\u0000\u0000\u001c!\u0003\u0004\u0002\u0000"+
		"\u001d\u001e\u0005\u0019\u0000\u0000\u001e \u0003\u0004\u0002\u0000\u001f"+
		"\u001d\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000!\u001f\u0001"+
		"\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"$\u0001\u0000\u0000\u0000"+
		"#!\u0001\u0000\u0000\u0000$%\u0005\f\u0000\u0000%&\u0003\u0002\u0001\u0014"+
		"&s\u0001\u0000\u0000\u0000\'(\u0005\u0001\u0000\u0000()\u0003\u0002\u0001"+
		"\u0000)*\u0005\u0002\u0000\u0000*+\u0003\u0002\u0001\u0000+,\u0005\u0003"+
		"\u0000\u0000,-\u0003\u0002\u0001\u0000-.\u0005\u0004\u0000\u0000.s\u0001"+
		"\u0000\u0000\u0000/0\u0005\u0005\u0000\u000001\u0003\u0002\u0001\u0000"+
		"12\u0005\u0006\u0000\u000023\u0003\u0002\u0001\u000034\u0005\u0007\u0000"+
		"\u00004s\u0001\u0000\u0000\u000056\u0005\b\u0000\u000067\u0003\u0002\u0001"+
		"\u00007?\u0005\t\u0000\u000089\u0005!\u0000\u00009:\u0005\u0015\u0000"+
		"\u0000:;\u0005\"\u0000\u0000;<\u0005\u0013\u0000\u0000<=\u0003\u0002\u0001"+
		"\u0000=>\u0005\u0016\u0000\u0000>@\u0001\u0000\u0000\u0000?8\u0001\u0000"+
		"\u0000\u0000@A\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001"+
		"\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CD\u0005\n\u0000\u0000Ds\u0001"+
		"\u0000\u0000\u0000EI\u0005\u001b\u0000\u0000FG\u0003\u0002\u0001\u0000"+
		"GH\u0005\u0016\u0000\u0000HJ\u0001\u0000\u0000\u0000IF\u0001\u0000\u0000"+
		"\u0000JK\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000"+
		"\u0000\u0000LM\u0001\u0000\u0000\u0000MN\u0005\u001c\u0000\u0000Ns\u0001"+
		"\u0000\u0000\u0000OP\u0005\u0017\u0000\u0000PQ\u0003\u0002\u0001\u0000"+
		"QR\u0005\u0018\u0000\u0000Rs\u0001\u0000\u0000\u0000ST\u0005!\u0000\u0000"+
		"TU\u0005#\u0000\u0000Us\u0003\u0002\u0001\u000eVW\u0005)\u0000\u0000W"+
		"s\u0003\u0002\u0001\u0006XY\u0005(\u0000\u0000Ys\u0003\u0002\u0001\u0005"+
		"Z[\u0005\r\u0000\u0000[s\u0003\u0002\u0001\u0004\\]\u0005\u000e\u0000"+
		"\u0000]s\u0005\"\u0000\u0000^`\u0005\u0011\u0000\u0000_^\u0001\u0000\u0000"+
		"\u0000_`\u0001\u0000\u0000\u0000`c\u0001\u0000\u0000\u0000ab\u0005\u0014"+
		"\u0000\u0000bd\u0005\"\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000"+
		"\u0000\u0000de\u0001\u0000\u0000\u0000ef\u0005!\u0000\u0000fo\u0005\u0017"+
		"\u0000\u0000gl\u0003\u0002\u0001\u0000hi\u0005\u0019\u0000\u0000ik\u0003"+
		"\u0002\u0001\u0000jh\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000\u0000"+
		"lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000"+
		"\u0000nl\u0001\u0000\u0000\u0000og\u0001\u0000\u0000\u0000op\u0001\u0000"+
		"\u0000\u0000pq\u0001\u0000\u0000\u0000qs\u0005\u0018\u0000\u0000r\u0014"+
		"\u0001\u0000\u0000\u0000r\u0016\u0001\u0000\u0000\u0000r\u0017\u0001\u0000"+
		"\u0000\u0000r\u0018\u0001\u0000\u0000\u0000r\u0019\u0001\u0000\u0000\u0000"+
		"r\u001a\u0001\u0000\u0000\u0000r\u001b\u0001\u0000\u0000\u0000r\'\u0001"+
		"\u0000\u0000\u0000r/\u0001\u0000\u0000\u0000r5\u0001\u0000\u0000\u0000"+
		"rE\u0001\u0000\u0000\u0000rO\u0001\u0000\u0000\u0000rS\u0001\u0000\u0000"+
		"\u0000rV\u0001\u0000\u0000\u0000rX\u0001\u0000\u0000\u0000rZ\u0001\u0000"+
		"\u0000\u0000r\\\u0001\u0000\u0000\u0000r_\u0001\u0000\u0000\u0000s\u009e"+
		"\u0001\u0000\u0000\u0000tu\n\r\u0000\u0000uv\u0005$\u0000\u0000v\u009d"+
		"\u0003\u0002\u0001\u000ewx\n\f\u0000\u0000xy\u0005%\u0000\u0000y\u009d"+
		"\u0003\u0002\u0001\rz{\n\u000b\u0000\u0000{|\u0005&\u0000\u0000|\u009d"+
		"\u0003\u0002\u0001\f}~\n\n\u0000\u0000~\u007f\u0005\'\u0000\u0000\u007f"+
		"\u009d\u0003\u0002\u0001\u000b\u0080\u0081\n\t\u0000\u0000\u0081\u0082"+
		"\u0005+\u0000\u0000\u0082\u009d\u0003\u0002\u0001\n\u0083\u0084\n\b\u0000"+
		"\u0000\u0084\u0085\u0005,\u0000\u0000\u0085\u009d\u0003\u0002\u0001\t"+
		"\u0086\u0087\n\u0007\u0000\u0000\u0087\u0088\u0005*\u0000\u0000\u0088"+
		"\u009d\u0003\u0002\u0001\b\u0089\u008c\n\u0001\u0000\u0000\u008a\u008b"+
		"\u0005\u0014\u0000\u0000\u008b\u008d\u0005\"\u0000\u0000\u008c\u008a\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0005\u001a\u0000\u0000\u008f\u0090\u0005"+
		"!\u0000\u0000\u0090\u0099\u0005\u0017\u0000\u0000\u0091\u0096\u0003\u0002"+
		"\u0001\u0000\u0092\u0093\u0005\u0019\u0000\u0000\u0093\u0095\u0003\u0002"+
		"\u0001\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u0098\u0001\u0000"+
		"\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000"+
		"\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000"+
		"\u0000\u0000\u0099\u0091\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000"+
		"\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009d\u0005\u0018"+
		"\u0000\u0000\u009ct\u0001\u0000\u0000\u0000\u009cw\u0001\u0000\u0000\u0000"+
		"\u009cz\u0001\u0000\u0000\u0000\u009c}\u0001\u0000\u0000\u0000\u009c\u0080"+
		"\u0001\u0000\u0000\u0000\u009c\u0083\u0001\u0000\u0000\u0000\u009c\u0086"+
		"\u0001\u0000\u0000\u0000\u009c\u0089\u0001\u0000\u0000\u0000\u009d\u00a0"+
		"\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0001\u0000\u0000\u0000\u009f\u0003\u0001\u0000\u0000\u0000\u00a0\u009e"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005!\u0000\u0000\u00a2\u00a3\u0005"+
		"\u0015\u0000\u0000\u00a3\u00a6\u0005\"\u0000\u0000\u00a4\u00a5\u0005#"+
		"\u0000\u0000\u00a5\u00a7\u0003\u0002\u0001\u0000\u00a6\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u0005\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a9\u0005!\u0000\u0000\u00a9\u00b6\u0005\u0017\u0000"+
		"\u0000\u00aa\u00ab\u0005!\u0000\u0000\u00ab\u00ac\u0005\u0015\u0000\u0000"+
		"\u00ac\u00b3\u0005\"\u0000\u0000\u00ad\u00ae\u0005\u0019\u0000\u0000\u00ae"+
		"\u00af\u0005!\u0000\u0000\u00af\u00b0\u0005\u0015\u0000\u0000\u00b0\u00b2"+
		"\u0005\"\u0000\u0000\u00b1\u00ad\u0001\u0000\u0000\u0000\u00b2\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b7\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b6\u00aa\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005"+
		"\u0018\u0000\u0000\u00b9\u00ba\u0005\u0015\u0000\u0000\u00ba\u00bb\u0005"+
		"\"\u0000\u0000\u00bb\u00bc\u0005\u001b\u0000\u0000\u00bc\u00bd\u0003\u0002"+
		"\u0001\u0000\u00bd\u00be\u0005\u001c\u0000\u0000\u00be\u0007\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c0\u0005\u000f\u0000\u0000\u00c0\u00c3\u0005\"\u0000"+
		"\u0000\u00c1\u00c2\u0005\u0010\u0000\u0000\u00c2\u00c4\u0005\"\u0000\u0000"+
		"\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00ce\u0005\u001b\u0000\u0000"+
		"\u00c6\u00c9\u0003\u0004\u0002\u0000\u00c7\u00c9\u0003\u0006\u0003\u0000"+
		"\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000"+
		"\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005\u0016\u0000\u0000"+
		"\u00cb\u00cd\u0001\u0000\u0000\u0000\u00cc\u00c8\u0001\u0000\u0000\u0000"+
		"\u00cd\u00d0\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005\u001c\u0000\u0000"+
		"\u00d2\t\u0001\u0000\u0000\u0000\u0014\u000f!AK_clor\u008c\u0096\u0099"+
		"\u009c\u009e\u00a6\u00b3\u00b6\u00c3\u00c8\u00ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}