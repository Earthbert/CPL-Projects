// Generated from c:/Users/earthbert/University/CPL/Projects/src/cool/parser/CoolParser.g4 by ANTLR 4.13.1

    package cool.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CoolParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ERROR=1, IF=2, THEN=3, ELSE=4, FI=5, WHILE=6, LOOP=7, POOL=8, CASE=9, 
		OF=10, ESAC=11, LET=12, IN=13, IS_VOID=14, NEW=15, CLASS=16, INHERITS=17, 
		BOOL_VAL=18, RIGHT_ARROW=19, AT=20, COLON=21, SEMICOLON=22, OPEN_PAR=23, 
		CLOSE_PAR=24, COMMA=25, DOT=26, OPEN_BRACE=27, CLOSE_BRACE=28, OPEN_BRACKET=29, 
		CLOSE_BRACKET=30, INT=31, NOT=32, ID=33, TYPE=34, ASSIGN=35, PLUS=36, 
		MINUS=37, TIMES=38, DIV=39, NEG=40, EQ=41, LT=42, LE=43, ERROR_UNTERMINATED_STRING=44, 
		ERROR_STRING_NULL_CHAR=45, ERROR_STRING_TOO_LONG=46, ERROR_UMATCHED_BLOCK_COMMENT=47, 
		ERROR_EOF_IN_STRING=48, ERROR_EOF_IN_COMMENT=49, STRING=50, BLOCK_COMMENT=51, 
		LINE_COMMENT=52, WS=53, ERROR_INVALID_CHAR=54;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_def = 2, RULE_method = 3, RULE_formal = 4, 
		RULE_feature = 5, RULE_class = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "def", "method", "formal", "feature", "class"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "'=>'", "'@'", "':'", "';'", 
			"'('", "')'", "','", "'.'", "'{'", "'}'", "'['", "']'", null, null, null, 
			null, "'<-'", "'+'", "'-'", "'*'", "'/'", "'~'", "'='", "'<'", "'<='", 
			null, null, null, "'*)'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ERROR", "IF", "THEN", "ELSE", "FI", "WHILE", "LOOP", "POOL", "CASE", 
			"OF", "ESAC", "LET", "IN", "IS_VOID", "NEW", "CLASS", "INHERITS", "BOOL_VAL", 
			"RIGHT_ARROW", "AT", "COLON", "SEMICOLON", "OPEN_PAR", "CLOSE_PAR", "COMMA", 
			"DOT", "OPEN_BRACE", "CLOSE_BRACE", "OPEN_BRACKET", "CLOSE_BRACKET", 
			"INT", "NOT", "ID", "TYPE", "ASSIGN", "PLUS", "MINUS", "TIMES", "DIV", 
			"NEG", "EQ", "LT", "LE", "ERROR_UNTERMINATED_STRING", "ERROR_STRING_NULL_CHAR", 
			"ERROR_STRING_TOO_LONG", "ERROR_UMATCHED_BLOCK_COMMENT", "ERROR_EOF_IN_STRING", 
			"ERROR_EOF_IN_COMMENT", "STRING", "BLOCK_COMMENT", "LINE_COMMENT", "WS", 
			"ERROR_INVALID_CHAR"
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
	public String getGrammarFileName() { return "CoolParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CoolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CoolParser.EOF, 0); }
		public List<ClassContext> class_() {
			return getRuleContexts(ClassContext.class);
		}
		public ClassContext class_(int i) {
			return getRuleContext(ClassContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14);
				class_();
				setState(15);
				match(SEMICOLON);
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CLASS );
			setState(21);
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
	public static class ParContext extends ExprContext {
		public TerminalNode OPEN_PAR() { return getToken(CoolParser.OPEN_PAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(CoolParser.CLOSE_PAR, 0); }
		public ParContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitPar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitPar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewContext extends ExprContext {
		public TerminalNode NEW() { return getToken(CoolParser.NEW, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public NewContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitNew(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitNew(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT() { return getToken(CoolParser.LT, 0); }
		public TerminalNode LE() { return getToken(CoolParser.LE, 0); }
		public TerminalNode EQ() { return getToken(CoolParser.EQ, 0); }
		public ComparisonContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(CoolParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IsvoidContext extends ExprContext {
		public TerminalNode IS_VOID() { return getToken(CoolParser.IS_VOID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IsvoidContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterIsvoid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitIsvoid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitIsvoid(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends ExprContext {
		public ExprContext cond;
		public ExprContext body;
		public TerminalNode WHILE() { return getToken(CoolParser.WHILE, 0); }
		public TerminalNode LOOP() { return getToken(CoolParser.LOOP, 0); }
		public TerminalNode POOL() { return getToken(CoolParser.POOL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public WhileContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ThisCallContext extends ExprContext {
		public ExprContext expr;
		public List<ExprContext> arg = new ArrayList<ExprContext>();
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode OPEN_PAR() { return getToken(CoolParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(CoolParser.CLOSE_PAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public ThisCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterThisCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitThisCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitThisCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(CoolParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegContext extends ExprContext {
		public TerminalNode NEG() { return getToken(CoolParser.NEG, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterNeg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitNeg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitNeg(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends ExprContext {
		public TerminalNode NOT() { return getToken(CoolParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ExprContext {
		public TerminalNode BOOL_VAL() { return getToken(CoolParser.BOOL_VAL, 0); }
		public BooleanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ExprContext {
		public TerminalNode OPEN_BRACE() { return getToken(CoolParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(CoolParser.CLOSE_BRACE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
		}
		public BlockContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetContext extends ExprContext {
		public TerminalNode LET() { return getToken(CoolParser.LET, 0); }
		public List<DefContext> def() {
			return getRuleContexts(DefContext.class);
		}
		public DefContext def(int i) {
			return getRuleContext(DefContext.class,i);
		}
		public TerminalNode IN() { return getToken(CoolParser.IN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public LetContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitLet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ExprContext {
		public ExprContext cond;
		public ExprContext thenBr;
		public ExprContext elseBr;
		public TerminalNode IF() { return getToken(CoolParser.IF, 0); }
		public TerminalNode THEN() { return getToken(CoolParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(CoolParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(CoolParser.FI, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IfContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CaseContext extends ExprContext {
		public ExprContext value;
		public Token ID;
		public List<Token> id = new ArrayList<Token>();
		public Token TYPE;
		public List<Token> type = new ArrayList<Token>();
		public ExprContext expr;
		public List<ExprContext> branch = new ArrayList<ExprContext>();
		public TerminalNode CASE() { return getToken(CoolParser.CASE, 0); }
		public TerminalNode OF() { return getToken(CoolParser.OF, 0); }
		public TerminalNode ESAC() { return getToken(CoolParser.ESAC, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(CoolParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(CoolParser.COLON, i);
		}
		public List<TerminalNode> RIGHT_ARROW() { return getTokens(CoolParser.RIGHT_ARROW); }
		public TerminalNode RIGHT_ARROW(int i) {
			return getToken(CoolParser.RIGHT_ARROW, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
		}
		public List<TerminalNode> ID() { return getTokens(CoolParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CoolParser.ID, i);
		}
		public List<TerminalNode> TYPE() { return getTokens(CoolParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CoolParser.TYPE, i);
		}
		public CaseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitCase(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ExprContext {
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArtihmeticContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode TIMES() { return getToken(CoolParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(CoolParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(CoolParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CoolParser.MINUS, 0); }
		public ArtihmeticContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterArtihmetic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitArtihmetic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitArtihmetic(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallContext extends ExprContext {
		public ExprContext object;
		public ExprContext expr;
		public List<ExprContext> arg = new ArrayList<ExprContext>();
		public TerminalNode DOT() { return getToken(CoolParser.DOT, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode OPEN_PAR() { return getToken(CoolParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(CoolParser.CLOSE_PAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AT() { return getToken(CoolParser.AT, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public MethodCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitMethodCall(this);
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
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new ThisCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(24);
				match(ID);
				setState(25);
				match(OPEN_PAR);
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1127014593778244L) != 0)) {
					{
					setState(26);
					((ThisCallContext)_localctx).expr = expr(0);
					((ThisCallContext)_localctx).arg.add(((ThisCallContext)_localctx).expr);
					setState(31);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(27);
						match(COMMA);
						setState(28);
						((ThisCallContext)_localctx).expr = expr(0);
						((ThisCallContext)_localctx).arg.add(((ThisCallContext)_localctx).expr);
						}
						}
						setState(33);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(36);
				match(CLOSE_PAR);
				}
				break;
			case 2:
				{
				_localctx = new IfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37);
				match(IF);
				setState(38);
				((IfContext)_localctx).cond = expr(0);
				setState(39);
				match(THEN);
				setState(40);
				((IfContext)_localctx).thenBr = expr(0);
				setState(41);
				match(ELSE);
				setState(42);
				((IfContext)_localctx).elseBr = expr(0);
				setState(43);
				match(FI);
				}
				break;
			case 3:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45);
				match(WHILE);
				setState(46);
				((WhileContext)_localctx).cond = expr(0);
				setState(47);
				match(LOOP);
				setState(48);
				((WhileContext)_localctx).body = expr(0);
				setState(49);
				match(POOL);
				}
				break;
			case 4:
				{
				_localctx = new BlockContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51);
				match(OPEN_BRACE);
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(52);
					expr(0);
					setState(53);
					match(SEMICOLON);
					}
					}
					setState(57); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1127014593778244L) != 0) );
				setState(59);
				match(CLOSE_BRACE);
				}
				break;
			case 5:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61);
				match(LET);
				setState(62);
				def();
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(63);
					match(COMMA);
					setState(64);
					def();
					}
					}
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(70);
				match(IN);
				setState(71);
				expr(15);
				}
				break;
			case 6:
				{
				_localctx = new CaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73);
				match(CASE);
				setState(74);
				((CaseContext)_localctx).value = expr(0);
				setState(75);
				match(OF);
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(76);
					((CaseContext)_localctx).ID = match(ID);
					((CaseContext)_localctx).id.add(((CaseContext)_localctx).ID);
					setState(77);
					match(COLON);
					setState(78);
					((CaseContext)_localctx).TYPE = match(TYPE);
					((CaseContext)_localctx).type.add(((CaseContext)_localctx).TYPE);
					setState(79);
					match(RIGHT_ARROW);
					setState(80);
					((CaseContext)_localctx).expr = expr(0);
					((CaseContext)_localctx).branch.add(((CaseContext)_localctx).expr);
					setState(81);
					match(SEMICOLON);
					}
					}
					setState(85); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(87);
				match(ESAC);
				}
				break;
			case 7:
				{
				_localctx = new NewContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				match(NEW);
				setState(90);
				match(TYPE);
				}
				break;
			case 8:
				{
				_localctx = new IsvoidContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				match(IS_VOID);
				setState(92);
				expr(12);
				}
				break;
			case 9:
				{
				_localctx = new NegContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93);
				match(NEG);
				setState(94);
				expr(11);
				}
				break;
			case 10:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95);
				match(NOT);
				setState(96);
				expr(7);
				}
				break;
			case 11:
				{
				_localctx = new ParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				match(OPEN_PAR);
				setState(98);
				expr(0);
				setState(99);
				match(CLOSE_PAR);
				}
				break;
			case 12:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101);
				match(ID);
				}
				break;
			case 13:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102);
				match(INT);
				}
				break;
			case 14:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(103);
				match(STRING);
				}
				break;
			case 15:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104);
				match(BOOL_VAL);
				}
				break;
			case 16:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(105);
				match(ID);
				setState(106);
				match(ASSIGN);
				setState(107);
				expr(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(138);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new ArtihmeticContext(new ExprContext(_parentctx, _parentState));
						((ArtihmeticContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(110);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(111);
						((ArtihmeticContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==TIMES || _la==DIV) ) {
							((ArtihmeticContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(112);
						((ArtihmeticContext)_localctx).right = expr(11);
						}
						break;
					case 2:
						{
						_localctx = new ArtihmeticContext(new ExprContext(_parentctx, _parentState));
						((ArtihmeticContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(113);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(114);
						((ArtihmeticContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ArtihmeticContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(115);
						((ArtihmeticContext)_localctx).right = expr(10);
						}
						break;
					case 3:
						{
						_localctx = new ComparisonContext(new ExprContext(_parentctx, _parentState));
						((ComparisonContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(116);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(117);
						((ComparisonContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15393162788864L) != 0)) ) {
							((ComparisonContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(118);
						((ComparisonContext)_localctx).right = expr(9);
						}
						break;
					case 4:
						{
						_localctx = new MethodCallContext(new ExprContext(_parentctx, _parentState));
						((MethodCallContext)_localctx).object = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(119);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(122);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==AT) {
							{
							setState(120);
							match(AT);
							setState(121);
							match(TYPE);
							}
						}

						setState(124);
						match(DOT);
						setState(125);
						match(ID);
						setState(126);
						match(OPEN_PAR);
						setState(135);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1127014593778244L) != 0)) {
							{
							setState(127);
							((MethodCallContext)_localctx).expr = expr(0);
							((MethodCallContext)_localctx).arg.add(((MethodCallContext)_localctx).expr);
							setState(132);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(128);
								match(COMMA);
								setState(129);
								((MethodCallContext)_localctx).expr = expr(0);
								((MethodCallContext)_localctx).arg.add(((MethodCallContext)_localctx).expr);
								}
								}
								setState(134);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(137);
						match(CLOSE_PAR);
						}
						break;
					}
					} 
				}
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		public Token name;
		public Token type;
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitDef(this);
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
			setState(143);
			((DefContext)_localctx).name = match(ID);
			setState(144);
			match(COLON);
			setState(145);
			((DefContext)_localctx).type = match(TYPE);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(146);
				match(ASSIGN);
				setState(147);
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
		public Token name;
		public Token type;
		public TerminalNode OPEN_PAR() { return getToken(CoolParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(CoolParser.CLOSE_PAR, 0); }
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(CoolParser.OPEN_BRACE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_BRACE() { return getToken(CoolParser.CLOSE_BRACE, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitMethod(this);
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
			setState(150);
			((MethodContext)_localctx).name = match(ID);
			setState(151);
			match(OPEN_PAR);
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(152);
				formal();
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(153);
					match(COMMA);
					setState(154);
					formal();
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(162);
			match(CLOSE_PAR);
			setState(163);
			match(COLON);
			setState(164);
			((MethodContext)_localctx).type = match(TYPE);
			setState(165);
			match(OPEN_BRACE);
			setState(166);
			expr(0);
			setState(167);
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
	public static class FormalContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public FormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterFormal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitFormal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitFormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalContext formal() throws RecognitionException {
		FormalContext _localctx = new FormalContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(ID);
			setState(170);
			match(COLON);
			setState(171);
			match(TYPE);
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
	public static class FeatureContext extends ParserRuleContext {
		public DefContext def() {
			return getRuleContext(DefContext.class,0);
		}
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitFeature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_feature);
		try {
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				def();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				method();
				}
				break;
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
		public Token name;
		public Token parent;
		public TerminalNode CLASS() { return getToken(CoolParser.CLASS, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(CoolParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(CoolParser.CLOSE_BRACE, 0); }
		public List<TerminalNode> TYPE() { return getTokens(CoolParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CoolParser.TYPE, i);
		}
		public TerminalNode INHERITS() { return getToken(CoolParser.INHERITS, 0); }
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
		}
		public ClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassContext class_() throws RecognitionException {
		ClassContext _localctx = new ClassContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(CLASS);
			setState(178);
			((ClassContext)_localctx).name = match(TYPE);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INHERITS) {
				{
				setState(179);
				match(INHERITS);
				setState(180);
				((ClassContext)_localctx).parent = match(TYPE);
				}
			}

			setState(183);
			match(OPEN_BRACE);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(184);
				feature();
				setState(185);
				match(SEMICOLON);
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(192);
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
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 19);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00016\u00c3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0004\u0000\u0012\b\u0000\u000b\u0000\f\u0000\u0013\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001\u001e\b\u0001\n\u0001\f\u0001!\t\u0001\u0003"+
		"\u0001#\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0004\u00018\b\u0001\u000b\u0001\f\u0001"+
		"9\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001B\b\u0001\n\u0001\f\u0001E\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001"+
		"T\b\u0001\u000b\u0001\f\u0001U\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001m\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001{\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u0083\b\u0001\n"+
		"\u0001\f\u0001\u0086\t\u0001\u0003\u0001\u0088\b\u0001\u0001\u0001\u0005"+
		"\u0001\u008b\b\u0001\n\u0001\f\u0001\u008e\t\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u0095\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u009c\b\u0003"+
		"\n\u0003\f\u0003\u009f\t\u0003\u0003\u0003\u00a1\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0003"+
		"\u0005\u00b0\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u00b6\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006\u00bc\b\u0006\n\u0006\f\u0006\u00bf\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0000\u0001\u0002\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000"+
		"\u0003\u0001\u0000&\'\u0001\u0000$%\u0001\u0000)+\u00dd\u0000\u0011\u0001"+
		"\u0000\u0000\u0000\u0002l\u0001\u0000\u0000\u0000\u0004\u008f\u0001\u0000"+
		"\u0000\u0000\u0006\u0096\u0001\u0000\u0000\u0000\b\u00a9\u0001\u0000\u0000"+
		"\u0000\n\u00af\u0001\u0000\u0000\u0000\f\u00b1\u0001\u0000\u0000\u0000"+
		"\u000e\u000f\u0003\f\u0006\u0000\u000f\u0010\u0005\u0016\u0000\u0000\u0010"+
		"\u0012\u0001\u0000\u0000\u0000\u0011\u000e\u0001\u0000\u0000\u0000\u0012"+
		"\u0013\u0001\u0000\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000\u0013"+
		"\u0014\u0001\u0000\u0000\u0000\u0014\u0015\u0001\u0000\u0000\u0000\u0015"+
		"\u0016\u0005\u0000\u0000\u0001\u0016\u0001\u0001\u0000\u0000\u0000\u0017"+
		"\u0018\u0006\u0001\uffff\uffff\u0000\u0018\u0019\u0005!\u0000\u0000\u0019"+
		"\"\u0005\u0017\u0000\u0000\u001a\u001f\u0003\u0002\u0001\u0000\u001b\u001c"+
		"\u0005\u0019\u0000\u0000\u001c\u001e\u0003\u0002\u0001\u0000\u001d\u001b"+
		"\u0001\u0000\u0000\u0000\u001e!\u0001\u0000\u0000\u0000\u001f\u001d\u0001"+
		"\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 #\u0001\u0000\u0000"+
		"\u0000!\u001f\u0001\u0000\u0000\u0000\"\u001a\u0001\u0000\u0000\u0000"+
		"\"#\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$m\u0005\u0018\u0000"+
		"\u0000%&\u0005\u0002\u0000\u0000&\'\u0003\u0002\u0001\u0000\'(\u0005\u0003"+
		"\u0000\u0000()\u0003\u0002\u0001\u0000)*\u0005\u0004\u0000\u0000*+\u0003"+
		"\u0002\u0001\u0000+,\u0005\u0005\u0000\u0000,m\u0001\u0000\u0000\u0000"+
		"-.\u0005\u0006\u0000\u0000./\u0003\u0002\u0001\u0000/0\u0005\u0007\u0000"+
		"\u000001\u0003\u0002\u0001\u000012\u0005\b\u0000\u00002m\u0001\u0000\u0000"+
		"\u000037\u0005\u001b\u0000\u000045\u0003\u0002\u0001\u000056\u0005\u0016"+
		"\u0000\u000068\u0001\u0000\u0000\u000074\u0001\u0000\u0000\u000089\u0001"+
		"\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000"+
		":;\u0001\u0000\u0000\u0000;<\u0005\u001c\u0000\u0000<m\u0001\u0000\u0000"+
		"\u0000=>\u0005\f\u0000\u0000>C\u0003\u0004\u0002\u0000?@\u0005\u0019\u0000"+
		"\u0000@B\u0003\u0004\u0002\u0000A?\u0001\u0000\u0000\u0000BE\u0001\u0000"+
		"\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DF\u0001"+
		"\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000FG\u0005\r\u0000\u0000GH\u0003"+
		"\u0002\u0001\u000fHm\u0001\u0000\u0000\u0000IJ\u0005\t\u0000\u0000JK\u0003"+
		"\u0002\u0001\u0000KS\u0005\n\u0000\u0000LM\u0005!\u0000\u0000MN\u0005"+
		"\u0015\u0000\u0000NO\u0005\"\u0000\u0000OP\u0005\u0013\u0000\u0000PQ\u0003"+
		"\u0002\u0001\u0000QR\u0005\u0016\u0000\u0000RT\u0001\u0000\u0000\u0000"+
		"SL\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000US\u0001\u0000\u0000"+
		"\u0000UV\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0005\u000b"+
		"\u0000\u0000Xm\u0001\u0000\u0000\u0000YZ\u0005\u000f\u0000\u0000Zm\u0005"+
		"\"\u0000\u0000[\\\u0005\u000e\u0000\u0000\\m\u0003\u0002\u0001\f]^\u0005"+
		"(\u0000\u0000^m\u0003\u0002\u0001\u000b_`\u0005 \u0000\u0000`m\u0003\u0002"+
		"\u0001\u0007ab\u0005\u0017\u0000\u0000bc\u0003\u0002\u0001\u0000cd\u0005"+
		"\u0018\u0000\u0000dm\u0001\u0000\u0000\u0000em\u0005!\u0000\u0000fm\u0005"+
		"\u001f\u0000\u0000gm\u00052\u0000\u0000hm\u0005\u0012\u0000\u0000ij\u0005"+
		"!\u0000\u0000jk\u0005#\u0000\u0000km\u0003\u0002\u0001\u0001l\u0017\u0001"+
		"\u0000\u0000\u0000l%\u0001\u0000\u0000\u0000l-\u0001\u0000\u0000\u0000"+
		"l3\u0001\u0000\u0000\u0000l=\u0001\u0000\u0000\u0000lI\u0001\u0000\u0000"+
		"\u0000lY\u0001\u0000\u0000\u0000l[\u0001\u0000\u0000\u0000l]\u0001\u0000"+
		"\u0000\u0000l_\u0001\u0000\u0000\u0000la\u0001\u0000\u0000\u0000le\u0001"+
		"\u0000\u0000\u0000lf\u0001\u0000\u0000\u0000lg\u0001\u0000\u0000\u0000"+
		"lh\u0001\u0000\u0000\u0000li\u0001\u0000\u0000\u0000m\u008c\u0001\u0000"+
		"\u0000\u0000no\n\n\u0000\u0000op\u0007\u0000\u0000\u0000p\u008b\u0003"+
		"\u0002\u0001\u000bqr\n\t\u0000\u0000rs\u0007\u0001\u0000\u0000s\u008b"+
		"\u0003\u0002\u0001\ntu\n\b\u0000\u0000uv\u0007\u0002\u0000\u0000v\u008b"+
		"\u0003\u0002\u0001\twz\n\u0013\u0000\u0000xy\u0005\u0014\u0000\u0000y"+
		"{\u0005\"\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000"+
		"{|\u0001\u0000\u0000\u0000|}\u0005\u001a\u0000\u0000}~\u0005!\u0000\u0000"+
		"~\u0087\u0005\u0017\u0000\u0000\u007f\u0084\u0003\u0002\u0001\u0000\u0080"+
		"\u0081\u0005\u0019\u0000\u0000\u0081\u0083\u0003\u0002\u0001\u0000\u0082"+
		"\u0080\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084"+
		"\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085"+
		"\u0088\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087"+
		"\u007f\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088"+
		"\u0089\u0001\u0000\u0000\u0000\u0089\u008b\u0005\u0018\u0000\u0000\u008a"+
		"n\u0001\u0000\u0000\u0000\u008aq\u0001\u0000\u0000\u0000\u008at\u0001"+
		"\u0000\u0000\u0000\u008aw\u0001\u0000\u0000\u0000\u008b\u008e\u0001\u0000"+
		"\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000"+
		"\u0000\u0000\u008d\u0003\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000"+
		"\u0000\u0000\u008f\u0090\u0005!\u0000\u0000\u0090\u0091\u0005\u0015\u0000"+
		"\u0000\u0091\u0094\u0005\"\u0000\u0000\u0092\u0093\u0005#\u0000\u0000"+
		"\u0093\u0095\u0003\u0002\u0001\u0000\u0094\u0092\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0005\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0005!\u0000\u0000\u0097\u00a0\u0005\u0017\u0000\u0000\u0098"+
		"\u009d\u0003\b\u0004\u0000\u0099\u009a\u0005\u0019\u0000\u0000\u009a\u009c"+
		"\u0003\b\u0004\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u009f\u0001"+
		"\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001"+
		"\u0000\u0000\u0000\u009e\u00a1\u0001\u0000\u0000\u0000\u009f\u009d\u0001"+
		"\u0000\u0000\u0000\u00a0\u0098\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005"+
		"\u0018\u0000\u0000\u00a3\u00a4\u0005\u0015\u0000\u0000\u00a4\u00a5\u0005"+
		"\"\u0000\u0000\u00a5\u00a6\u0005\u001b\u0000\u0000\u00a6\u00a7\u0003\u0002"+
		"\u0001\u0000\u00a7\u00a8\u0005\u001c\u0000\u0000\u00a8\u0007\u0001\u0000"+
		"\u0000\u0000\u00a9\u00aa\u0005!\u0000\u0000\u00aa\u00ab\u0005\u0015\u0000"+
		"\u0000\u00ab\u00ac\u0005\"\u0000\u0000\u00ac\t\u0001\u0000\u0000\u0000"+
		"\u00ad\u00b0\u0003\u0004\u0002\u0000\u00ae\u00b0\u0003\u0006\u0003\u0000"+
		"\u00af\u00ad\u0001\u0000\u0000\u0000\u00af\u00ae\u0001\u0000\u0000\u0000"+
		"\u00b0\u000b\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005\u0010\u0000\u0000"+
		"\u00b2\u00b5\u0005\"\u0000\u0000\u00b3\u00b4\u0005\u0011\u0000\u0000\u00b4"+
		"\u00b6\u0005\"\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00bd"+
		"\u0005\u001b\u0000\u0000\u00b8\u00b9\u0003\n\u0005\u0000\u00b9\u00ba\u0005"+
		"\u0016\u0000\u0000\u00ba\u00bc\u0001\u0000\u0000\u0000\u00bb\u00b8\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001"+
		"\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00c0\u0001"+
		"\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005"+
		"\u001c\u0000\u0000\u00c1\r\u0001\u0000\u0000\u0000\u0012\u0013\u001f\""+
		"9CUlz\u0084\u0087\u008a\u008c\u0094\u009d\u00a0\u00af\u00b5\u00bd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}