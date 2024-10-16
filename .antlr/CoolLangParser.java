// Generated from c:/Users/earthbert/University/CPL/Cool-AST/CoolLangParser.g4 by ANTLR 4.13.1
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
		LET=11, IN=12, IS_VOID=13, NEW=14, CLASS=15, INHERITS=16, TRUE=17, FALSE=18, 
		BOOL_VAL=19, RIGHT_ARROW=20, AT=21, COLON=22, SEMICOLON=23, OPEN_PAR=24, 
		CLOSE_PAR=25, COMMA=26, DOT=27, OPEN_BRACE=28, CLOSE_BRACE=29, OPEN_BRACKET=30, 
		CLOSE_BRACKET=31, INT=32, FLOAT=33, ID=34, TYPE=35, ASSIGN=36, PLUS=37, 
		MINUS=38, TIMES=39, DIV=40, NEG=41, NOT=42, EQ=43, LT=44, LE=45, STRING=46, 
		BLOCK_COMMENT=47, LINE_COMMENT=48, WS=49;
	public static final int
		RULE_expr = 0, RULE_def = 1, RULE_let = 2, RULE_if = 3, RULE_while = 4, 
		RULE_case = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"expr", "def", "let", "if", "while", "case"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "'=>'", "'@'", "':'", 
			"';'", "'('", "')'", "','", "'.'", "'{'", "'}'", "'['", "']'", null, 
			null, null, null, "'<-'", "'+'", "'-'", "'*'", "'/'", "'~'", "'not'", 
			"'='", "'<'", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "THEN", "ELSE", "FI", "WHILE", "LOOP", "POOL", "CASE", "OF", 
			"ESAC", "LET", "IN", "IS_VOID", "NEW", "CLASS", "INHERITS", "TRUE", "FALSE", 
			"BOOL_VAL", "RIGHT_ARROW", "AT", "COLON", "SEMICOLON", "OPEN_PAR", "CLOSE_PAR", 
			"COMMA", "DOT", "OPEN_BRACE", "CLOSE_BRACE", "OPEN_BRACKET", "CLOSE_BRACKET", 
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
	public static class ExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CoolLangParser.ID, 0); }
		public TerminalNode INT() { return getToken(CoolLangParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(CoolLangParser.FLOAT, 0); }
		public TerminalNode BOOL_VAL() { return getToken(CoolLangParser.BOOL_VAL, 0); }
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public WhileContext while_() {
			return getRuleContext(WhileContext.class,0);
		}
		public CaseContext case_() {
			return getRuleContext(CaseContext.class,0);
		}
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expr);
		int _la;
		try {
			setState(30);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(12);
				match(ID);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(13);
				match(INT);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(14);
				match(FLOAT);
				}
				break;
			case BOOL_VAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(15);
				match(BOOL_VAL);
				}
				break;
			case LET:
				enterOuterAlt(_localctx, 5);
				{
				setState(16);
				let();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 6);
				{
				setState(17);
				if_();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 7);
				{
				setState(18);
				while_();
				}
				break;
			case CASE:
				enterOuterAlt(_localctx, 8);
				{
				setState(19);
				case_();
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 9);
				{
				setState(20);
				match(OPEN_BRACE);
				setState(24); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(21);
					expr();
					setState(22);
					match(SEMICOLON);
					}
					}
					setState(26); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 30333733154L) != 0) );
				setState(28);
				match(CLOSE_BRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(ID);
			setState(33);
			match(COLON);
			setState(34);
			match(TYPE);
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(35);
				match(ASSIGN);
				setState(36);
				expr();
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
	public static class LetContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(CoolLangParser.LET, 0); }
		public DefContext def() {
			return getRuleContext(DefContext.class,0);
		}
		public TerminalNode IN() { return getToken(CoolLangParser.IN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let; }
	}

	public final LetContext let() throws RecognitionException {
		LetContext _localctx = new LetContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_let);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(LET);
			setState(40);
			def();
			setState(41);
			match(IN);
			setState(42);
			expr();
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
	public static class IfContext extends ParserRuleContext {
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
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
	}

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(IF);
			setState(45);
			expr();
			setState(46);
			match(THEN);
			setState(47);
			expr();
			setState(48);
			match(ELSE);
			setState(49);
			expr();
			setState(50);
			match(FI);
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
	public static class WhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(CoolLangParser.WHILE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LOOP() { return getToken(CoolLangParser.LOOP, 0); }
		public TerminalNode POOL() { return getToken(CoolLangParser.POOL, 0); }
		public WhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while; }
	}

	public final WhileContext while_() throws RecognitionException {
		WhileContext _localctx = new WhileContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(WHILE);
			setState(53);
			expr();
			setState(54);
			match(LOOP);
			setState(55);
			expr();
			setState(56);
			match(POOL);
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
	public static class CaseContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(CoolLangParser.CASE, 0); }
		public List<TerminalNode> ID() { return getTokens(CoolLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CoolLangParser.ID, i);
		}
		public TerminalNode OF() { return getToken(CoolLangParser.OF, 0); }
		public TerminalNode ESAC() { return getToken(CoolLangParser.ESAC, 0); }
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
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case; }
	}

	public final CaseContext case_() throws RecognitionException {
		CaseContext _localctx = new CaseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(CASE);
			setState(59);
			match(ID);
			setState(60);
			match(OF);
			setState(66); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(61);
				match(ID);
				setState(62);
				match(COLON);
				setState(63);
				match(TYPE);
				setState(64);
				match(RIGHT_ARROW);
				setState(65);
				expr();
				}
				}
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(70);
			match(ESAC);
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

	public static final String _serializedATN =
		"\u0004\u00011I\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0004\u0000\u0019\b\u0000\u000b\u0000\f\u0000\u001a\u0001"+
		"\u0000\u0001\u0000\u0003\u0000\u001f\b\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001&\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0004\u0005C\b\u0005\u000b\u0005\f\u0005D\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0000\u0000\u0006\u0000\u0002\u0004\u0006\b\n"+
		"\u0000\u0000M\u0000\u001e\u0001\u0000\u0000\u0000\u0002 \u0001\u0000\u0000"+
		"\u0000\u0004\'\u0001\u0000\u0000\u0000\u0006,\u0001\u0000\u0000\u0000"+
		"\b4\u0001\u0000\u0000\u0000\n:\u0001\u0000\u0000\u0000\f\u001f\u0005\""+
		"\u0000\u0000\r\u001f\u0005 \u0000\u0000\u000e\u001f\u0005!\u0000\u0000"+
		"\u000f\u001f\u0005\u0013\u0000\u0000\u0010\u001f\u0003\u0004\u0002\u0000"+
		"\u0011\u001f\u0003\u0006\u0003\u0000\u0012\u001f\u0003\b\u0004\u0000\u0013"+
		"\u001f\u0003\n\u0005\u0000\u0014\u0018\u0005\u001c\u0000\u0000\u0015\u0016"+
		"\u0003\u0000\u0000\u0000\u0016\u0017\u0005\u0017\u0000\u0000\u0017\u0019"+
		"\u0001\u0000\u0000\u0000\u0018\u0015\u0001\u0000\u0000\u0000\u0019\u001a"+
		"\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a\u001b"+
		"\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001d"+
		"\u0005\u001d\u0000\u0000\u001d\u001f\u0001\u0000\u0000\u0000\u001e\f\u0001"+
		"\u0000\u0000\u0000\u001e\r\u0001\u0000\u0000\u0000\u001e\u000e\u0001\u0000"+
		"\u0000\u0000\u001e\u000f\u0001\u0000\u0000\u0000\u001e\u0010\u0001\u0000"+
		"\u0000\u0000\u001e\u0011\u0001\u0000\u0000\u0000\u001e\u0012\u0001\u0000"+
		"\u0000\u0000\u001e\u0013\u0001\u0000\u0000\u0000\u001e\u0014\u0001\u0000"+
		"\u0000\u0000\u001f\u0001\u0001\u0000\u0000\u0000 !\u0005\"\u0000\u0000"+
		"!\"\u0005\u0016\u0000\u0000\"%\u0005#\u0000\u0000#$\u0005$\u0000\u0000"+
		"$&\u0003\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000"+
		"\u0000&\u0003\u0001\u0000\u0000\u0000\'(\u0005\u000b\u0000\u0000()\u0003"+
		"\u0002\u0001\u0000)*\u0005\f\u0000\u0000*+\u0003\u0000\u0000\u0000+\u0005"+
		"\u0001\u0000\u0000\u0000,-\u0005\u0001\u0000\u0000-.\u0003\u0000\u0000"+
		"\u0000./\u0005\u0002\u0000\u0000/0\u0003\u0000\u0000\u000001\u0005\u0003"+
		"\u0000\u000012\u0003\u0000\u0000\u000023\u0005\u0004\u0000\u00003\u0007"+
		"\u0001\u0000\u0000\u000045\u0005\u0005\u0000\u000056\u0003\u0000\u0000"+
		"\u000067\u0005\u0006\u0000\u000078\u0003\u0000\u0000\u000089\u0005\u0007"+
		"\u0000\u00009\t\u0001\u0000\u0000\u0000:;\u0005\b\u0000\u0000;<\u0005"+
		"\"\u0000\u0000<B\u0005\t\u0000\u0000=>\u0005\"\u0000\u0000>?\u0005\u0016"+
		"\u0000\u0000?@\u0005#\u0000\u0000@A\u0005\u0014\u0000\u0000AC\u0003\u0000"+
		"\u0000\u0000B=\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DB\u0001"+
		"\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000"+
		"FG\u0005\n\u0000\u0000G\u000b\u0001\u0000\u0000\u0000\u0004\u001a\u001e"+
		"%D";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}