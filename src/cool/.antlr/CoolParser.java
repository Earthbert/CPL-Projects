// Generated from c:/Users/earthbert/University/CPL/Tema1/src/cool/CoolParser.g4 by ANTLR 4.13.1
package cool.antlr4;
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
		SELF=18, BOOL_VAL=19, RIGHT_ARROW=20, AT=21, COLON=22, SEMICOLON=23, OPEN_PAR=24, 
		CLOSE_PAR=25, COMMA=26, DOT=27, OPEN_BRACE=28, CLOSE_BRACE=29, OPEN_BRACKET=30, 
		CLOSE_BRACKET=31, INT=32, ID=33, TYPE=34, ASSIGN=35, PLUS=36, MINUS=37, 
		TIMES=38, DIV=39, NEG=40, NOT=41, EQ=42, LT=43, LE=44, ERROR_UNTERMINATED_STRING=45, 
		ERROR_STRING_NULL_CHAR=46, ERROR_STRING_TOO_LONG=47, ERROR_UMATCHED_BLOCK_COMMENT=48, 
		ERROR_EOF_IN_STRING=49, ERROR_EOF_IN_COMMENT=50, STRING=51, BLOCK_COMMENT=52, 
		LINE_COMMENT=53, WS=54, ERROR_INVALID_CHAR=55;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_def = 2, RULE_method = 3, RULE_class = 4, 
		RULE_error = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "def", "method", "class", "error"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "'=>'", "'@'", "':'", 
			"';'", "'('", "')'", "','", "'.'", "'{'", "'}'", "'['", "']'", null, 
			null, null, "'<-'", "'+'", "'-'", "'*'", "'/'", "'~'", "'not'", "'='", 
			"'<'", "'<='", null, null, null, "'*)'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ERROR", "IF", "THEN", "ELSE", "FI", "WHILE", "LOOP", "POOL", "CASE", 
			"OF", "ESAC", "LET", "IN", "IS_VOID", "NEW", "CLASS", "INHERITS", "SELF", 
			"BOOL_VAL", "RIGHT_ARROW", "AT", "COLON", "SEMICOLON", "OPEN_PAR", "CLOSE_PAR", 
			"COMMA", "DOT", "OPEN_BRACE", "CLOSE_BRACE", "OPEN_BRACKET", "CLOSE_BRACKET", 
			"INT", "ID", "TYPE", "ASSIGN", "PLUS", "MINUS", "TIMES", "DIV", "NEG", 
			"NOT", "EQ", "LT", "LE", "ERROR_UNTERMINATED_STRING", "ERROR_STRING_NULL_CHAR", 
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
			while (_la==CLASS) {
				{
				{
				setState(12);
				class_();
				setState(13);
				match(SEMICOLON);
				}
				}
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(20);
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
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonContext extends ExprContext {
		public Token op;
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
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(CoolParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IsvoidContext extends ExprContext {
		public TerminalNode IS_VOID() { return getToken(CoolParser.IS_VOID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IsvoidContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorContext extends ExprContext {
		public TerminalNode NEW() { return getToken(CoolParser.NEW, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public ConstructorContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends ExprContext {
		public TerminalNode WHILE() { return getToken(CoolParser.WHILE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LOOP() { return getToken(CoolParser.LOOP, 0); }
		public TerminalNode POOL() { return getToken(CoolParser.POOL, 0); }
		public WhileContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ThisCallContext extends ExprContext {
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode OPEN_PAR() { return getToken(CoolParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(CoolParser.CLOSE_PAR, 0); }
		public TerminalNode SELF() { return getToken(CoolParser.SELF, 0); }
		public TerminalNode AT() { return getToken(CoolParser.AT, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
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
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(CoolParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegContext extends ExprContext {
		public TerminalNode NEG() { return getToken(CoolParser.NEG, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends ExprContext {
		public TerminalNode NOT() { return getToken(CoolParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ExprContext {
		public TerminalNode BOOL_VAL() { return getToken(CoolParser.BOOL_VAL, 0); }
		public BooleanContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelfContext extends ExprContext {
		public TerminalNode SELF() { return getToken(CoolParser.SELF, 0); }
		public SelfContext(ExprContext ctx) { copyFrom(ctx); }
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
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ExprContext {
		public TerminalNode IF() { return getToken(CoolParser.IF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode THEN() { return getToken(CoolParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(CoolParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(CoolParser.FI, 0); }
		public IfContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CaseContext extends ExprContext {
		public TerminalNode CASE() { return getToken(CoolParser.CASE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OF() { return getToken(CoolParser.OF, 0); }
		public TerminalNode ESAC() { return getToken(CoolParser.ESAC, 0); }
		public List<TerminalNode> ID() { return getTokens(CoolParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CoolParser.ID, i);
		}
		public List<TerminalNode> COLON() { return getTokens(CoolParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(CoolParser.COLON, i);
		}
		public List<TerminalNode> TYPE() { return getTokens(CoolParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CoolParser.TYPE, i);
		}
		public List<TerminalNode> RIGHT_ARROW() { return getTokens(CoolParser.RIGHT_ARROW); }
		public TerminalNode RIGHT_ARROW(int i) {
			return getToken(CoolParser.RIGHT_ARROW, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
		}
		public CaseContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ExprContext {
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArtihmeticContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(CoolParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CoolParser.MINUS, 0); }
		public TerminalNode TIMES() { return getToken(CoolParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(CoolParser.DIV, 0); }
		public ArtihmeticContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DOT() { return getToken(CoolParser.DOT, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode OPEN_PAR() { return getToken(CoolParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(CoolParser.CLOSE_PAR, 0); }
		public TerminalNode AT() { return getToken(CoolParser.AT, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public MethodCallContext(ExprContext ctx) { copyFrom(ctx); }
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
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(23);
				match(ID);
				}
				break;
			case 2:
				{
				_localctx = new SelfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(SELF);
				}
				break;
			case 3:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				match(INT);
				}
				break;
			case 4:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(STRING);
				}
				break;
			case 5:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(27);
				match(BOOL_VAL);
				}
				break;
			case 6:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				match(LET);
				setState(29);
				def();
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(30);
					match(COMMA);
					setState(31);
					def();
					}
					}
					setState(36);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(37);
				match(IN);
				setState(38);
				expr(20);
				}
				break;
			case 7:
				{
				_localctx = new IfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(40);
				match(IF);
				setState(41);
				expr(0);
				setState(42);
				match(THEN);
				setState(43);
				expr(0);
				setState(44);
				match(ELSE);
				setState(45);
				expr(0);
				setState(46);
				match(FI);
				}
				break;
			case 8:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48);
				match(WHILE);
				setState(49);
				expr(0);
				setState(50);
				match(LOOP);
				setState(51);
				expr(0);
				setState(52);
				match(POOL);
				}
				break;
			case 9:
				{
				_localctx = new CaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(54);
				match(CASE);
				setState(55);
				expr(0);
				setState(56);
				match(OF);
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(57);
					match(ID);
					setState(58);
					match(COLON);
					setState(59);
					match(TYPE);
					setState(60);
					match(RIGHT_ARROW);
					setState(61);
					expr(0);
					setState(62);
					match(SEMICOLON);
					}
					}
					setState(66); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(68);
				match(ESAC);
				}
				break;
			case 10:
				{
				_localctx = new BlockContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70);
				match(OPEN_BRACE);
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(71);
					expr(0);
					setState(72);
					match(SEMICOLON);
					}
					}
					setState(76); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2255111521620548L) != 0) );
				setState(78);
				match(CLOSE_BRACE);
				}
				break;
			case 11:
				{
				_localctx = new ParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				match(OPEN_PAR);
				setState(81);
				expr(0);
				setState(82);
				match(CLOSE_PAR);
				}
				break;
			case 12:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84);
				match(ID);
				setState(85);
				match(ASSIGN);
				setState(86);
				expr(14);
				}
				break;
			case 13:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				match(NOT);
				setState(88);
				expr(6);
				}
				break;
			case 14:
				{
				_localctx = new NegContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				match(NEG);
				setState(90);
				expr(5);
				}
				break;
			case 15:
				{
				_localctx = new IsvoidContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				match(IS_VOID);
				setState(92);
				expr(4);
				}
				break;
			case 16:
				{
				_localctx = new ConstructorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93);
				match(NEW);
				setState(94);
				match(TYPE);
				}
				break;
			case 17:
				{
				_localctx = new ThisCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SELF) {
					{
					setState(95);
					match(SELF);
					}
				}

				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AT) {
					{
					setState(98);
					match(AT);
					setState(99);
					match(TYPE);
					}
				}

				setState(102);
				match(ID);
				setState(103);
				match(OPEN_PAR);
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2255111521620548L) != 0)) {
					{
					setState(104);
					expr(0);
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(105);
						match(COMMA);
						setState(106);
						expr(0);
						}
						}
						setState(111);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(114);
				match(CLOSE_PAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(159);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(157);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ArtihmeticContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(117);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(118);
						((ArtihmeticContext)_localctx).op = match(PLUS);
						setState(119);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new ArtihmeticContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(120);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(121);
						((ArtihmeticContext)_localctx).op = match(MINUS);
						setState(122);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new ArtihmeticContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(123);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(124);
						((ArtihmeticContext)_localctx).op = match(TIMES);
						setState(125);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new ArtihmeticContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(126);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(127);
						((ArtihmeticContext)_localctx).op = match(DIV);
						setState(128);
						expr(11);
						}
						break;
					case 5:
						{
						_localctx = new ComparisonContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(129);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(130);
						((ComparisonContext)_localctx).op = match(LT);
						setState(131);
						expr(10);
						}
						break;
					case 6:
						{
						_localctx = new ComparisonContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(132);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(133);
						((ComparisonContext)_localctx).op = match(LE);
						setState(134);
						expr(9);
						}
						break;
					case 7:
						{
						_localctx = new ComparisonContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(135);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(136);
						((ComparisonContext)_localctx).op = match(EQ);
						setState(137);
						expr(8);
						}
						break;
					case 8:
						{
						_localctx = new MethodCallContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(138);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(141);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==AT) {
							{
							setState(139);
							match(AT);
							setState(140);
							match(TYPE);
							}
						}

						setState(143);
						match(DOT);
						setState(144);
						match(ID);
						setState(145);
						match(OPEN_PAR);
						setState(154);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2255111521620548L) != 0)) {
							{
							setState(146);
							expr(0);
							setState(151);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(147);
								match(COMMA);
								setState(148);
								expr(0);
								}
								}
								setState(153);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(156);
						match(CLOSE_PAR);
						}
						break;
					}
					} 
				}
				setState(161);
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
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(ID);
			setState(163);
			match(COLON);
			setState(164);
			match(TYPE);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(165);
				match(ASSIGN);
				setState(166);
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
		public List<TerminalNode> ID() { return getTokens(CoolParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CoolParser.ID, i);
		}
		public TerminalNode OPEN_PAR() { return getToken(CoolParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(CoolParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COLON() { return getTokens(CoolParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(CoolParser.COLON, i);
		}
		public List<TerminalNode> TYPE() { return getTokens(CoolParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CoolParser.TYPE, i);
		}
		public TerminalNode OPEN_BRACE() { return getToken(CoolParser.OPEN_BRACE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_BRACE() { return getToken(CoolParser.CLOSE_BRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(ID);
			setState(170);
			match(OPEN_PAR);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(171);
				match(ID);
				setState(172);
				match(COLON);
				setState(173);
				match(TYPE);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(174);
					match(COMMA);
					setState(175);
					match(ID);
					setState(176);
					match(COLON);
					setState(177);
					match(TYPE);
					}
					}
					setState(182);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(185);
			match(CLOSE_PAR);
			setState(186);
			match(COLON);
			setState(187);
			match(TYPE);
			setState(188);
			match(OPEN_BRACE);
			setState(189);
			expr(0);
			setState(190);
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
		public TerminalNode CLASS() { return getToken(CoolParser.CLASS, 0); }
		public List<TerminalNode> TYPE() { return getTokens(CoolParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CoolParser.TYPE, i);
		}
		public TerminalNode OPEN_BRACE() { return getToken(CoolParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(CoolParser.CLOSE_BRACE, 0); }
		public TerminalNode INHERITS() { return getToken(CoolParser.INHERITS, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
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
	}

	public final ClassContext class_() throws RecognitionException {
		ClassContext _localctx = new ClassContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(CLASS);
			setState(193);
			match(TYPE);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INHERITS) {
				{
				setState(194);
				match(INHERITS);
				setState(195);
				match(TYPE);
				}
			}

			setState(198);
			match(OPEN_BRACE);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(201);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(199);
					def();
					}
					break;
				case 2:
					{
					setState(200);
					method();
					}
					break;
				}
				setState(203);
				match(SEMICOLON);
				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(210);
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
	public static class ErrorContext extends ParserRuleContext {
		public TerminalNode ERROR() { return getToken(CoolParser.ERROR, 0); }
		public ErrorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error; }
	}

	public final ErrorContext error() throws RecognitionException {
		ErrorContext _localctx = new ErrorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_error);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(ERROR);
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
		"\u0004\u00017\u00d7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u0010"+
		"\b\u0000\n\u0000\f\u0000\u0013\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001!\b\u0001\n\u0001\f\u0001"+
		"$\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001A\b\u0001"+
		"\u000b\u0001\f\u0001B\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0004\u0001K\b\u0001\u000b\u0001\f\u0001L\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001a\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001e\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001l\b\u0001"+
		"\n\u0001\f\u0001o\t\u0001\u0003\u0001q\b\u0001\u0001\u0001\u0003\u0001"+
		"t\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u008e\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u0096\b\u0001\n\u0001"+
		"\f\u0001\u0099\t\u0001\u0003\u0001\u009b\b\u0001\u0001\u0001\u0005\u0001"+
		"\u009e\b\u0001\n\u0001\f\u0001\u00a1\t\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00a8\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003\u00b3\b\u0003\n\u0003\f\u0003\u00b6\t\u0003"+
		"\u0003\u0003\u00b8\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004\u00c5\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u00ca\b\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u00ce\b"+
		"\u0004\n\u0004\f\u0004\u00d1\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0000\u0001\u0002\u0006\u0000\u0002\u0004\u0006"+
		"\b\n\u0000\u0000\u00f9\u0000\u0011\u0001\u0000\u0000\u0000\u0002s\u0001"+
		"\u0000\u0000\u0000\u0004\u00a2\u0001\u0000\u0000\u0000\u0006\u00a9\u0001"+
		"\u0000\u0000\u0000\b\u00c0\u0001\u0000\u0000\u0000\n\u00d4\u0001\u0000"+
		"\u0000\u0000\f\r\u0003\b\u0004\u0000\r\u000e\u0005\u0017\u0000\u0000\u000e"+
		"\u0010\u0001\u0000\u0000\u0000\u000f\f\u0001\u0000\u0000\u0000\u0010\u0013"+
		"\u0001\u0000\u0000\u0000\u0011\u000f\u0001\u0000\u0000\u0000\u0011\u0012"+
		"\u0001\u0000\u0000\u0000\u0012\u0014\u0001\u0000\u0000\u0000\u0013\u0011"+
		"\u0001\u0000\u0000\u0000\u0014\u0015\u0005\u0000\u0000\u0001\u0015\u0001"+
		"\u0001\u0000\u0000\u0000\u0016\u0017\u0006\u0001\uffff\uffff\u0000\u0017"+
		"t\u0005!\u0000\u0000\u0018t\u0005\u0012\u0000\u0000\u0019t\u0005 \u0000"+
		"\u0000\u001at\u00053\u0000\u0000\u001bt\u0005\u0013\u0000\u0000\u001c"+
		"\u001d\u0005\f\u0000\u0000\u001d\"\u0003\u0004\u0002\u0000\u001e\u001f"+
		"\u0005\u001a\u0000\u0000\u001f!\u0003\u0004\u0002\u0000 \u001e\u0001\u0000"+
		"\u0000\u0000!$\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"#\u0001"+
		"\u0000\u0000\u0000#%\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000"+
		"%&\u0005\r\u0000\u0000&\'\u0003\u0002\u0001\u0014\'t\u0001\u0000\u0000"+
		"\u0000()\u0005\u0002\u0000\u0000)*\u0003\u0002\u0001\u0000*+\u0005\u0003"+
		"\u0000\u0000+,\u0003\u0002\u0001\u0000,-\u0005\u0004\u0000\u0000-.\u0003"+
		"\u0002\u0001\u0000./\u0005\u0005\u0000\u0000/t\u0001\u0000\u0000\u0000"+
		"01\u0005\u0006\u0000\u000012\u0003\u0002\u0001\u000023\u0005\u0007\u0000"+
		"\u000034\u0003\u0002\u0001\u000045\u0005\b\u0000\u00005t\u0001\u0000\u0000"+
		"\u000067\u0005\t\u0000\u000078\u0003\u0002\u0001\u00008@\u0005\n\u0000"+
		"\u00009:\u0005!\u0000\u0000:;\u0005\u0016\u0000\u0000;<\u0005\"\u0000"+
		"\u0000<=\u0005\u0014\u0000\u0000=>\u0003\u0002\u0001\u0000>?\u0005\u0017"+
		"\u0000\u0000?A\u0001\u0000\u0000\u0000@9\u0001\u0000\u0000\u0000AB\u0001"+
		"\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000"+
		"CD\u0001\u0000\u0000\u0000DE\u0005\u000b\u0000\u0000Et\u0001\u0000\u0000"+
		"\u0000FJ\u0005\u001c\u0000\u0000GH\u0003\u0002\u0001\u0000HI\u0005\u0017"+
		"\u0000\u0000IK\u0001\u0000\u0000\u0000JG\u0001\u0000\u0000\u0000KL\u0001"+
		"\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000"+
		"MN\u0001\u0000\u0000\u0000NO\u0005\u001d\u0000\u0000Ot\u0001\u0000\u0000"+
		"\u0000PQ\u0005\u0018\u0000\u0000QR\u0003\u0002\u0001\u0000RS\u0005\u0019"+
		"\u0000\u0000St\u0001\u0000\u0000\u0000TU\u0005!\u0000\u0000UV\u0005#\u0000"+
		"\u0000Vt\u0003\u0002\u0001\u000eWX\u0005)\u0000\u0000Xt\u0003\u0002\u0001"+
		"\u0006YZ\u0005(\u0000\u0000Zt\u0003\u0002\u0001\u0005[\\\u0005\u000e\u0000"+
		"\u0000\\t\u0003\u0002\u0001\u0004]^\u0005\u000f\u0000\u0000^t\u0005\""+
		"\u0000\u0000_a\u0005\u0012\u0000\u0000`_\u0001\u0000\u0000\u0000`a\u0001"+
		"\u0000\u0000\u0000ad\u0001\u0000\u0000\u0000bc\u0005\u0015\u0000\u0000"+
		"ce\u0005\"\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000"+
		"ef\u0001\u0000\u0000\u0000fg\u0005!\u0000\u0000gp\u0005\u0018\u0000\u0000"+
		"hm\u0003\u0002\u0001\u0000ij\u0005\u001a\u0000\u0000jl\u0003\u0002\u0001"+
		"\u0000ki\u0001\u0000\u0000\u0000lo\u0001\u0000\u0000\u0000mk\u0001\u0000"+
		"\u0000\u0000mn\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001"+
		"\u0000\u0000\u0000ph\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000"+
		"qr\u0001\u0000\u0000\u0000rt\u0005\u0019\u0000\u0000s\u0016\u0001\u0000"+
		"\u0000\u0000s\u0018\u0001\u0000\u0000\u0000s\u0019\u0001\u0000\u0000\u0000"+
		"s\u001a\u0001\u0000\u0000\u0000s\u001b\u0001\u0000\u0000\u0000s\u001c"+
		"\u0001\u0000\u0000\u0000s(\u0001\u0000\u0000\u0000s0\u0001\u0000\u0000"+
		"\u0000s6\u0001\u0000\u0000\u0000sF\u0001\u0000\u0000\u0000sP\u0001\u0000"+
		"\u0000\u0000sT\u0001\u0000\u0000\u0000sW\u0001\u0000\u0000\u0000sY\u0001"+
		"\u0000\u0000\u0000s[\u0001\u0000\u0000\u0000s]\u0001\u0000\u0000\u0000"+
		"s`\u0001\u0000\u0000\u0000t\u009f\u0001\u0000\u0000\u0000uv\n\r\u0000"+
		"\u0000vw\u0005$\u0000\u0000w\u009e\u0003\u0002\u0001\u000exy\n\f\u0000"+
		"\u0000yz\u0005%\u0000\u0000z\u009e\u0003\u0002\u0001\r{|\n\u000b\u0000"+
		"\u0000|}\u0005&\u0000\u0000}\u009e\u0003\u0002\u0001\f~\u007f\n\n\u0000"+
		"\u0000\u007f\u0080\u0005\'\u0000\u0000\u0080\u009e\u0003\u0002\u0001\u000b"+
		"\u0081\u0082\n\t\u0000\u0000\u0082\u0083\u0005+\u0000\u0000\u0083\u009e"+
		"\u0003\u0002\u0001\n\u0084\u0085\n\b\u0000\u0000\u0085\u0086\u0005,\u0000"+
		"\u0000\u0086\u009e\u0003\u0002\u0001\t\u0087\u0088\n\u0007\u0000\u0000"+
		"\u0088\u0089\u0005*\u0000\u0000\u0089\u009e\u0003\u0002\u0001\b\u008a"+
		"\u008d\n\u0001\u0000\u0000\u008b\u008c\u0005\u0015\u0000\u0000\u008c\u008e"+
		"\u0005\"\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0090\u0005"+
		"\u001b\u0000\u0000\u0090\u0091\u0005!\u0000\u0000\u0091\u009a\u0005\u0018"+
		"\u0000\u0000\u0092\u0097\u0003\u0002\u0001\u0000\u0093\u0094\u0005\u001a"+
		"\u0000\u0000\u0094\u0096\u0003\u0002\u0001\u0000\u0095\u0093\u0001\u0000"+
		"\u0000\u0000\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000"+
		"\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u009b\u0001\u0000"+
		"\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u0092\u0001\u0000"+
		"\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000"+
		"\u0000\u0000\u009c\u009e\u0005\u0019\u0000\u0000\u009du\u0001\u0000\u0000"+
		"\u0000\u009dx\u0001\u0000\u0000\u0000\u009d{\u0001\u0000\u0000\u0000\u009d"+
		"~\u0001\u0000\u0000\u0000\u009d\u0081\u0001\u0000\u0000\u0000\u009d\u0084"+
		"\u0001\u0000\u0000\u0000\u009d\u0087\u0001\u0000\u0000\u0000\u009d\u008a"+
		"\u0001\u0000\u0000\u0000\u009e\u00a1\u0001\u0000\u0000\u0000\u009f\u009d"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u0003"+
		"\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a2\u00a3"+
		"\u0005!\u0000\u0000\u00a3\u00a4\u0005\u0016\u0000\u0000\u00a4\u00a7\u0005"+
		"\"\u0000\u0000\u00a5\u00a6\u0005#\u0000\u0000\u00a6\u00a8\u0003\u0002"+
		"\u0001\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000"+
		"\u0000\u0000\u00a8\u0005\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005!\u0000"+
		"\u0000\u00aa\u00b7\u0005\u0018\u0000\u0000\u00ab\u00ac\u0005!\u0000\u0000"+
		"\u00ac\u00ad\u0005\u0016\u0000\u0000\u00ad\u00b4\u0005\"\u0000\u0000\u00ae"+
		"\u00af\u0005\u001a\u0000\u0000\u00af\u00b0\u0005!\u0000\u0000\u00b0\u00b1"+
		"\u0005\u0016\u0000\u0000\u00b1\u00b3\u0005\"\u0000\u0000\u00b2\u00ae\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b6\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b7\u00ab\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001"+
		"\u0000\u0000\u0000\u00b9\u00ba\u0005\u0019\u0000\u0000\u00ba\u00bb\u0005"+
		"\u0016\u0000\u0000\u00bb\u00bc\u0005\"\u0000\u0000\u00bc\u00bd\u0005\u001c"+
		"\u0000\u0000\u00bd\u00be\u0003\u0002\u0001\u0000\u00be\u00bf\u0005\u001d"+
		"\u0000\u0000\u00bf\u0007\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\u0010"+
		"\u0000\u0000\u00c1\u00c4\u0005\"\u0000\u0000\u00c2\u00c3\u0005\u0011\u0000"+
		"\u0000\u00c3\u00c5\u0005\"\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000"+
		"\u00c6\u00cf\u0005\u001c\u0000\u0000\u00c7\u00ca\u0003\u0004\u0002\u0000"+
		"\u00c8\u00ca\u0003\u0006\u0003\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000"+
		"\u00c9\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000"+
		"\u00cb\u00cc\u0005\u0017\u0000\u0000\u00cc\u00ce\u0001\u0000\u0000\u0000"+
		"\u00cd\u00c9\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000"+
		"\u00cf\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d2\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d3\u0005\u001d\u0000\u0000\u00d3\t\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d5\u0005\u0001\u0000\u0000\u00d5\u000b\u0001\u0000\u0000\u0000\u0014"+
		"\u0011\"BL`dmps\u008d\u0097\u009a\u009d\u009f\u00a7\u00b4\u00b7\u00c4"+
		"\u00c9\u00cf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}