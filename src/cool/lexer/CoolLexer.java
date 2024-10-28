// Generated from c:/Users/earthbert/University/CPL/Tema1/src/cool/lexer/CoolLexer.g4 by ANTLR 4.13.1

    package cool.lexer;	

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CoolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ERROR=1, IF=2, THEN=3, ELSE=4, FI=5, WHILE=6, LOOP=7, POOL=8, CASE=9, 
		OF=10, ESAC=11, LET=12, IN=13, IS_VOID=14, NEW=15, CLASS=16, INHERITS=17, 
		SELF=18, BOOL_VAL=19, RIGHT_ARROW=20, AT=21, COLON=22, SEMICOLON=23, OPEN_PAR=24, 
		CLOSE_PAR=25, COMMA=26, DOT=27, OPEN_BRACE=28, CLOSE_BRACE=29, OPEN_BRACKET=30, 
		CLOSE_BRACKET=31, INT=32, NOT=33, ID=34, TYPE=35, ASSIGN=36, PLUS=37, 
		MINUS=38, TIMES=39, DIV=40, NEG=41, EQ=42, LT=43, LE=44, ERROR_UNTERMINATED_STRING=45, 
		ERROR_STRING_NULL_CHAR=46, ERROR_STRING_TOO_LONG=47, ERROR_UMATCHED_BLOCK_COMMENT=48, 
		ERROR_EOF_IN_STRING=49, ERROR_EOF_IN_COMMENT=50, STRING=51, BLOCK_COMMENT=52, 
		LINE_COMMENT=53, WS=54, ERROR_INVALID_CHAR=55;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
			"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "IF", "THEN", 
			"ELSE", "FI", "WHILE", "LOOP", "POOL", "CASE", "OF", "ESAC", "LET", "IN", 
			"IS_VOID", "NEW", "CLASS", "INHERITS", "SELF", "TRUE", "FALSE", "BOOL_VAL", 
			"RIGHT_ARROW", "AT", "COLON", "SEMICOLON", "OPEN_PAR", "CLOSE_PAR", "COMMA", 
			"DOT", "OPEN_BRACE", "CLOSE_BRACE", "OPEN_BRACKET", "CLOSE_BRACKET", 
			"DIGIT", "INT", "LETTER", "LOWER", "UPPER", "NOT", "ID", "TYPE", "ASSIGN", 
			"PLUS", "MINUS", "TIMES", "DIV", "NEG", "EQ", "LT", "LE", "STRING_CHAR", 
			"ERROR_UNTERMINATED_STRING", "ERROR_STRING_NULL_CHAR", "ERROR_STRING_TOO_LONG", 
			"ERROR_UMATCHED_BLOCK_COMMENT", "ERROR_EOF_IN_STRING", "ERROR_EOF_IN_COMMENT", 
			"STRING", "BLOCK_COMMENT", "LINE_COMMENT", "WS", "ERROR_INVALID_CHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "'=>'", "'@'", "':'", 
			"';'", "'('", "')'", "','", "'.'", "'{'", "'}'", "'['", "']'", null, 
			null, null, null, "'<-'", "'+'", "'-'", "'*'", "'/'", "'~'", "'='", "'<'", 
			"'<='", null, null, null, "'*)'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ERROR", "IF", "THEN", "ELSE", "FI", "WHILE", "LOOP", "POOL", "CASE", 
			"OF", "ESAC", "LET", "IN", "IS_VOID", "NEW", "CLASS", "INHERITS", "SELF", 
			"BOOL_VAL", "RIGHT_ARROW", "AT", "COLON", "SEMICOLON", "OPEN_PAR", "CLOSE_PAR", 
			"COMMA", "DOT", "OPEN_BRACE", "CLOSE_BRACE", "OPEN_BRACKET", "CLOSE_BRACKET", 
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

	    
	    private void raiseError(String msg) {
	        setText(msg);
	        setType(ERROR);
	    }


	public CoolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CoolLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 76:
			ERROR_UNTERMINATED_STRING_action((RuleContext)_localctx, actionIndex);
			break;
		case 77:
			ERROR_STRING_NULL_CHAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 78:
			ERROR_STRING_TOO_LONG_action((RuleContext)_localctx, actionIndex);
			break;
		case 79:
			ERROR_UMATCHED_BLOCK_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 80:
			ERROR_EOF_IN_STRING_action((RuleContext)_localctx, actionIndex);
			break;
		case 81:
			ERROR_EOF_IN_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 82:
			STRING_action((RuleContext)_localctx, actionIndex);
			break;
		case 86:
			ERROR_INVALID_CHAR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ERROR_UNTERMINATED_STRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 raiseError("Unterminated string constant"); 
			break;
		}
	}
	private void ERROR_STRING_NULL_CHAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			 raiseError("String contains null character"); 
			break;
		}
	}
	private void ERROR_STRING_TOO_LONG_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			 raiseError("String constant too long"); 
			break;
		}
	}
	private void ERROR_UMATCHED_BLOCK_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			 raiseError("Unmatched *\u0029"); 
			break;
		}
	}
	private void ERROR_EOF_IN_STRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			 raiseError("EOF in string constant"); 
			break;
		}
	}
	private void ERROR_EOF_IN_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			 raiseError("EOF in comment"); 
			break;
		}
	}
	private void STRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			  setText(getText().substring(1, getText().length() - 1)); 
						                setText(getText().replace("\\n", "\n")
						  					             .replace("\\t", "\t")
											             .replace("\\f", "\f")
			                                             .replace("\\b", "\b")
														 .replaceAll("\\\\([a-zA-Z])", "$1")
			                                             .replace("\\\n", "\n")
			                                             .replace("\\\r", "")); 
			break;
		}
	}
	private void ERROR_INVALID_CHAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			 raiseError("Invalid character: " + getText()); 
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 78:
			return ERROR_STRING_TOO_LONG_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean ERROR_STRING_TOO_LONG_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return  getText().length() > 1024 ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00007\u021e\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"+
		"5\u00026\u00076\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007"+
		":\u0002;\u0007;\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007"+
		"?\u0002@\u0007@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007"+
		"D\u0002E\u0007E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007"+
		"I\u0002J\u0007J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007"+
		"N\u0002O\u0007O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007"+
		"S\u0002T\u0007T\u0002U\u0007U\u0002V\u0007V\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001*\u0001*\u0001*\u0001*\u0001*\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001-\u0001"+
		"-\u0003-\u0144\b-\u0001.\u0001.\u0001.\u0001/\u0001/\u00010\u00010\u0001"+
		"1\u00011\u00012\u00012\u00013\u00013\u00014\u00014\u00015\u00015\u0001"+
		"6\u00016\u00017\u00017\u00018\u00018\u00019\u00019\u0001:\u0001:\u0001"+
		";\u0004;\u0162\b;\u000b;\f;\u0163\u0001<\u0001<\u0001=\u0001=\u0001>\u0001"+
		">\u0001?\u0001?\u0001?\u0001?\u0001@\u0001@\u0003@\u0172\b@\u0001@\u0001"+
		"@\u0001@\u0005@\u0177\b@\n@\f@\u017a\t@\u0001A\u0001A\u0001A\u0001A\u0005"+
		"A\u0180\bA\nA\fA\u0183\tA\u0001A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001"+
		"A\u0001A\u0001A\u0003A\u018e\bA\u0001B\u0001B\u0001B\u0001C\u0001C\u0001"+
		"D\u0001D\u0001E\u0001E\u0001F\u0001F\u0001G\u0001G\u0001H\u0001H\u0001"+
		"I\u0001I\u0001J\u0001J\u0001J\u0001K\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0003K\u01ac\bK\u0001L\u0001L\u0005L\u01b0\bL\nL\fL\u01b3"+
		"\tL\u0001L\u0001L\u0001L\u0003L\u01b8\bL\u0001L\u0001L\u0001M\u0001M\u0005"+
		"M\u01be\bM\nM\fM\u01c1\tM\u0001M\u0001M\u0005M\u01c5\bM\nM\fM\u01c8\t"+
		"M\u0001M\u0001M\u0001M\u0001N\u0001N\u0001N\u0001N\u0001O\u0001O\u0001"+
		"O\u0001O\u0001O\u0001P\u0001P\u0005P\u01d8\bP\nP\fP\u01db\tP\u0001P\u0001"+
		"P\u0001P\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0003Q\u01e7"+
		"\bQ\u0005Q\u01e9\bQ\nQ\fQ\u01ec\tQ\u0001Q\u0001Q\u0001Q\u0001R\u0001R"+
		"\u0005R\u01f3\bR\nR\fR\u01f6\tR\u0001R\u0001R\u0001R\u0001S\u0001S\u0001"+
		"S\u0001S\u0001S\u0005S\u0200\bS\nS\fS\u0203\tS\u0001S\u0001S\u0001S\u0001"+
		"S\u0001S\u0001T\u0001T\u0001T\u0001T\u0005T\u020e\bT\nT\fT\u0211\tT\u0001"+
		"T\u0001T\u0001U\u0004U\u0216\bU\u000bU\fU\u0217\u0001U\u0001U\u0001V\u0001"+
		"V\u0001V\u0002\u01ea\u0201\u0000W\u0001\u0000\u0003\u0000\u0005\u0000"+
		"\u0007\u0000\t\u0000\u000b\u0000\r\u0000\u000f\u0000\u0011\u0000\u0013"+
		"\u0000\u0015\u0000\u0017\u0000\u0019\u0000\u001b\u0000\u001d\u0000\u001f"+
		"\u0000!\u0000#\u0000%\u0000\'\u0000)\u0000+\u0000-\u0000/\u00001\u0000"+
		"3\u00005\u00027\u00039\u0004;\u0005=\u0006?\u0007A\bC\tE\nG\u000bI\fK"+
		"\rM\u000eO\u000fQ\u0010S\u0011U\u0012W\u0000Y\u0000[\u0013]\u0014_\u0015"+
		"a\u0016c\u0017e\u0018g\u0019i\u001ak\u001bm\u001co\u001dq\u001es\u001f"+
		"u\u0000w y\u0000{\u0000}\u0000\u007f!\u0081\"\u0083#\u0085$\u0087%\u0089"+
		"&\u008b\'\u008d(\u008f)\u0091*\u0093+\u0095,\u0097\u0000\u0099-\u009b"+
		".\u009d/\u009f0\u00a11\u00a32\u00a53\u00a74\u00a95\u00ab6\u00ad7\u0001"+
		"\u0000#\u0002\u0000AAaa\u0002\u0000BBbb\u0002\u0000CCcc\u0002\u0000DD"+
		"dd\u0002\u0000EEee\u0002\u0000FFff\u0002\u0000GGgg\u0002\u0000HHhh\u0002"+
		"\u0000IIii\u0002\u0000JJjj\u0002\u0000KKkk\u0002\u0000LLll\u0002\u0000"+
		"MMmm\u0002\u0000NNnn\u0002\u0000OOoo\u0002\u0000PPpp\u0002\u0000QQqq\u0002"+
		"\u0000RRrr\u0002\u0000SSss\u0002\u0000TTtt\u0002\u0000UUuu\u0002\u0000"+
		"VVvv\u0002\u0000WWww\u0002\u0000XXxx\u0002\u0000YYyy\u0002\u0000ZZzz\u0001"+
		"\u000009\u0002\u0000AZaz\u0001\u0000az\u0001\u0000AZ\u0004\u0000\u0000"+
		"\u0000\n\n\r\r\"\"\u0001\u0000**\u0001\u0000))\u0002\u0000\n\n\r\r\u0003"+
		"\u0000\t\n\f\r  \u0216\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000"+
		"\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000"+
		"\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A"+
		"\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000"+
		"\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000\u0000"+
		"\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0000O"+
		"\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000S\u0001\u0000"+
		"\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000\u0000"+
		"\u0000]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000\u0000\u0000a"+
		"\u0001\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000\u0000e\u0001\u0000"+
		"\u0000\u0000\u0000g\u0001\u0000\u0000\u0000\u0000i\u0001\u0000\u0000\u0000"+
		"\u0000k\u0001\u0000\u0000\u0000\u0000m\u0001\u0000\u0000\u0000\u0000o"+
		"\u0001\u0000\u0000\u0000\u0000q\u0001\u0000\u0000\u0000\u0000s\u0001\u0000"+
		"\u0000\u0000\u0000w\u0001\u0000\u0000\u0000\u0000\u007f\u0001\u0000\u0000"+
		"\u0000\u0000\u0081\u0001\u0000\u0000\u0000\u0000\u0083\u0001\u0000\u0000"+
		"\u0000\u0000\u0085\u0001\u0000\u0000\u0000\u0000\u0087\u0001\u0000\u0000"+
		"\u0000\u0000\u0089\u0001\u0000\u0000\u0000\u0000\u008b\u0001\u0000\u0000"+
		"\u0000\u0000\u008d\u0001\u0000\u0000\u0000\u0000\u008f\u0001\u0000\u0000"+
		"\u0000\u0000\u0091\u0001\u0000\u0000\u0000\u0000\u0093\u0001\u0000\u0000"+
		"\u0000\u0000\u0095\u0001\u0000\u0000\u0000\u0000\u0099\u0001\u0000\u0000"+
		"\u0000\u0000\u009b\u0001\u0000\u0000\u0000\u0000\u009d\u0001\u0000\u0000"+
		"\u0000\u0000\u009f\u0001\u0000\u0000\u0000\u0000\u00a1\u0001\u0000\u0000"+
		"\u0000\u0000\u00a3\u0001\u0000\u0000\u0000\u0000\u00a5\u0001\u0000\u0000"+
		"\u0000\u0000\u00a7\u0001\u0000\u0000\u0000\u0000\u00a9\u0001\u0000\u0000"+
		"\u0000\u0000\u00ab\u0001\u0000\u0000\u0000\u0000\u00ad\u0001\u0000\u0000"+
		"\u0000\u0001\u00af\u0001\u0000\u0000\u0000\u0003\u00b1\u0001\u0000\u0000"+
		"\u0000\u0005\u00b3\u0001\u0000\u0000\u0000\u0007\u00b5\u0001\u0000\u0000"+
		"\u0000\t\u00b7\u0001\u0000\u0000\u0000\u000b\u00b9\u0001\u0000\u0000\u0000"+
		"\r\u00bb\u0001\u0000\u0000\u0000\u000f\u00bd\u0001\u0000\u0000\u0000\u0011"+
		"\u00bf\u0001\u0000\u0000\u0000\u0013\u00c1\u0001\u0000\u0000\u0000\u0015"+
		"\u00c3\u0001\u0000\u0000\u0000\u0017\u00c5\u0001\u0000\u0000\u0000\u0019"+
		"\u00c7\u0001\u0000\u0000\u0000\u001b\u00c9\u0001\u0000\u0000\u0000\u001d"+
		"\u00cb\u0001\u0000\u0000\u0000\u001f\u00cd\u0001\u0000\u0000\u0000!\u00cf"+
		"\u0001\u0000\u0000\u0000#\u00d1\u0001\u0000\u0000\u0000%\u00d3\u0001\u0000"+
		"\u0000\u0000\'\u00d5\u0001\u0000\u0000\u0000)\u00d7\u0001\u0000\u0000"+
		"\u0000+\u00d9\u0001\u0000\u0000\u0000-\u00db\u0001\u0000\u0000\u0000/"+
		"\u00dd\u0001\u0000\u0000\u00001\u00df\u0001\u0000\u0000\u00003\u00e1\u0001"+
		"\u0000\u0000\u00005\u00e3\u0001\u0000\u0000\u00007\u00e6\u0001\u0000\u0000"+
		"\u00009\u00eb\u0001\u0000\u0000\u0000;\u00f0\u0001\u0000\u0000\u0000="+
		"\u00f3\u0001\u0000\u0000\u0000?\u00f9\u0001\u0000\u0000\u0000A\u00fe\u0001"+
		"\u0000\u0000\u0000C\u0103\u0001\u0000\u0000\u0000E\u0108\u0001\u0000\u0000"+
		"\u0000G\u010b\u0001\u0000\u0000\u0000I\u0110\u0001\u0000\u0000\u0000K"+
		"\u0114\u0001\u0000\u0000\u0000M\u0117\u0001\u0000\u0000\u0000O\u011e\u0001"+
		"\u0000\u0000\u0000Q\u0122\u0001\u0000\u0000\u0000S\u0128\u0001\u0000\u0000"+
		"\u0000U\u0131\u0001\u0000\u0000\u0000W\u0136\u0001\u0000\u0000\u0000Y"+
		"\u013b\u0001\u0000\u0000\u0000[\u0143\u0001\u0000\u0000\u0000]\u0145\u0001"+
		"\u0000\u0000\u0000_\u0148\u0001\u0000\u0000\u0000a\u014a\u0001\u0000\u0000"+
		"\u0000c\u014c\u0001\u0000\u0000\u0000e\u014e\u0001\u0000\u0000\u0000g"+
		"\u0150\u0001\u0000\u0000\u0000i\u0152\u0001\u0000\u0000\u0000k\u0154\u0001"+
		"\u0000\u0000\u0000m\u0156\u0001\u0000\u0000\u0000o\u0158\u0001\u0000\u0000"+
		"\u0000q\u015a\u0001\u0000\u0000\u0000s\u015c\u0001\u0000\u0000\u0000u"+
		"\u015e\u0001\u0000\u0000\u0000w\u0161\u0001\u0000\u0000\u0000y\u0165\u0001"+
		"\u0000\u0000\u0000{\u0167\u0001\u0000\u0000\u0000}\u0169\u0001\u0000\u0000"+
		"\u0000\u007f\u016b\u0001\u0000\u0000\u0000\u0081\u0171\u0001\u0000\u0000"+
		"\u0000\u0083\u018d\u0001\u0000\u0000\u0000\u0085\u018f\u0001\u0000\u0000"+
		"\u0000\u0087\u0192\u0001\u0000\u0000\u0000\u0089\u0194\u0001\u0000\u0000"+
		"\u0000\u008b\u0196\u0001\u0000\u0000\u0000\u008d\u0198\u0001\u0000\u0000"+
		"\u0000\u008f\u019a\u0001\u0000\u0000\u0000\u0091\u019c\u0001\u0000\u0000"+
		"\u0000\u0093\u019e\u0001\u0000\u0000\u0000\u0095\u01a0\u0001\u0000\u0000"+
		"\u0000\u0097\u01ab\u0001\u0000\u0000\u0000\u0099\u01ad\u0001\u0000\u0000"+
		"\u0000\u009b\u01bb\u0001\u0000\u0000\u0000\u009d\u01cc\u0001\u0000\u0000"+
		"\u0000\u009f\u01d0\u0001\u0000\u0000\u0000\u00a1\u01d5\u0001\u0000\u0000"+
		"\u0000\u00a3\u01df\u0001\u0000\u0000\u0000\u00a5\u01f0\u0001\u0000\u0000"+
		"\u0000\u00a7\u01fa\u0001\u0000\u0000\u0000\u00a9\u0209\u0001\u0000\u0000"+
		"\u0000\u00ab\u0215\u0001\u0000\u0000\u0000\u00ad\u021b\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0007\u0000\u0000\u0000\u00b0\u0002\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b2\u0007\u0001\u0000\u0000\u00b2\u0004\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b4\u0007\u0002\u0000\u0000\u00b4\u0006\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b6\u0007\u0003\u0000\u0000\u00b6\b\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b8\u0007\u0004\u0000\u0000\u00b8\n\u0001\u0000\u0000\u0000\u00b9"+
		"\u00ba\u0007\u0005\u0000\u0000\u00ba\f\u0001\u0000\u0000\u0000\u00bb\u00bc"+
		"\u0007\u0006\u0000\u0000\u00bc\u000e\u0001\u0000\u0000\u0000\u00bd\u00be"+
		"\u0007\u0007\u0000\u0000\u00be\u0010\u0001\u0000\u0000\u0000\u00bf\u00c0"+
		"\u0007\b\u0000\u0000\u00c0\u0012\u0001\u0000\u0000\u0000\u00c1\u00c2\u0007"+
		"\t\u0000\u0000\u00c2\u0014\u0001\u0000\u0000\u0000\u00c3\u00c4\u0007\n"+
		"\u0000\u0000\u00c4\u0016\u0001\u0000\u0000\u0000\u00c5\u00c6\u0007\u000b"+
		"\u0000\u0000\u00c6\u0018\u0001\u0000\u0000\u0000\u00c7\u00c8\u0007\f\u0000"+
		"\u0000\u00c8\u001a\u0001\u0000\u0000\u0000\u00c9\u00ca\u0007\r\u0000\u0000"+
		"\u00ca\u001c\u0001\u0000\u0000\u0000\u00cb\u00cc\u0007\u000e\u0000\u0000"+
		"\u00cc\u001e\u0001\u0000\u0000\u0000\u00cd\u00ce\u0007\u000f\u0000\u0000"+
		"\u00ce \u0001\u0000\u0000\u0000\u00cf\u00d0\u0007\u0010\u0000\u0000\u00d0"+
		"\"\u0001\u0000\u0000\u0000\u00d1\u00d2\u0007\u0011\u0000\u0000\u00d2$"+
		"\u0001\u0000\u0000\u0000\u00d3\u00d4\u0007\u0012\u0000\u0000\u00d4&\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d6\u0007\u0013\u0000\u0000\u00d6(\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d8\u0007\u0014\u0000\u0000\u00d8*\u0001\u0000\u0000"+
		"\u0000\u00d9\u00da\u0007\u0015\u0000\u0000\u00da,\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0007\u0016\u0000\u0000\u00dc.\u0001\u0000\u0000\u0000\u00dd"+
		"\u00de\u0007\u0017\u0000\u0000\u00de0\u0001\u0000\u0000\u0000\u00df\u00e0"+
		"\u0007\u0018\u0000\u0000\u00e02\u0001\u0000\u0000\u0000\u00e1\u00e2\u0007"+
		"\u0019\u0000\u0000\u00e24\u0001\u0000\u0000\u0000\u00e3\u00e4\u0003\u0011"+
		"\b\u0000\u00e4\u00e5\u0003\u000b\u0005\u0000\u00e56\u0001\u0000\u0000"+
		"\u0000\u00e6\u00e7\u0003\'\u0013\u0000\u00e7\u00e8\u0003\u000f\u0007\u0000"+
		"\u00e8\u00e9\u0003\t\u0004\u0000\u00e9\u00ea\u0003\u001b\r\u0000\u00ea"+
		"8\u0001\u0000\u0000\u0000\u00eb\u00ec\u0003\t\u0004\u0000\u00ec\u00ed"+
		"\u0003\u0017\u000b\u0000\u00ed\u00ee\u0003%\u0012\u0000\u00ee\u00ef\u0003"+
		"\t\u0004\u0000\u00ef:\u0001\u0000\u0000\u0000\u00f0\u00f1\u0003\u000b"+
		"\u0005\u0000\u00f1\u00f2\u0003\u0011\b\u0000\u00f2<\u0001\u0000\u0000"+
		"\u0000\u00f3\u00f4\u0003-\u0016\u0000\u00f4\u00f5\u0003\u000f\u0007\u0000"+
		"\u00f5\u00f6\u0003\u0011\b\u0000\u00f6\u00f7\u0003\u0017\u000b\u0000\u00f7"+
		"\u00f8\u0003\t\u0004\u0000\u00f8>\u0001\u0000\u0000\u0000\u00f9\u00fa"+
		"\u0003\u0017\u000b\u0000\u00fa\u00fb\u0003\u001d\u000e\u0000\u00fb\u00fc"+
		"\u0003\u001d\u000e\u0000\u00fc\u00fd\u0003\u001f\u000f\u0000\u00fd@\u0001"+
		"\u0000\u0000\u0000\u00fe\u00ff\u0003\u001f\u000f\u0000\u00ff\u0100\u0003"+
		"\u001d\u000e\u0000\u0100\u0101\u0003\u001d\u000e\u0000\u0101\u0102\u0003"+
		"\u0017\u000b\u0000\u0102B\u0001\u0000\u0000\u0000\u0103\u0104\u0003\u0005"+
		"\u0002\u0000\u0104\u0105\u0003\u0001\u0000\u0000\u0105\u0106\u0003%\u0012"+
		"\u0000\u0106\u0107\u0003\t\u0004\u0000\u0107D\u0001\u0000\u0000\u0000"+
		"\u0108\u0109\u0003\u001d\u000e\u0000\u0109\u010a\u0003\u000b\u0005\u0000"+
		"\u010aF\u0001\u0000\u0000\u0000\u010b\u010c\u0003\t\u0004\u0000\u010c"+
		"\u010d\u0003%\u0012\u0000\u010d\u010e\u0003\u0001\u0000\u0000\u010e\u010f"+
		"\u0003\u0005\u0002\u0000\u010fH\u0001\u0000\u0000\u0000\u0110\u0111\u0003"+
		"\u0017\u000b\u0000\u0111\u0112\u0003\t\u0004\u0000\u0112\u0113\u0003\'"+
		"\u0013\u0000\u0113J\u0001\u0000\u0000\u0000\u0114\u0115\u0003\u0011\b"+
		"\u0000\u0115\u0116\u0003\u001b\r\u0000\u0116L\u0001\u0000\u0000\u0000"+
		"\u0117\u0118\u0003\u0011\b\u0000\u0118\u0119\u0003%\u0012\u0000\u0119"+
		"\u011a\u0003+\u0015\u0000\u011a\u011b\u0003\u001d\u000e\u0000\u011b\u011c"+
		"\u0003\u0011\b\u0000\u011c\u011d\u0003\u0007\u0003\u0000\u011dN\u0001"+
		"\u0000\u0000\u0000\u011e\u011f\u0003\u001b\r\u0000\u011f\u0120\u0003\t"+
		"\u0004\u0000\u0120\u0121\u0003-\u0016\u0000\u0121P\u0001\u0000\u0000\u0000"+
		"\u0122\u0123\u0003\u0005\u0002\u0000\u0123\u0124\u0003\u0017\u000b\u0000"+
		"\u0124\u0125\u0003\u0001\u0000\u0000\u0125\u0126\u0003%\u0012\u0000\u0126"+
		"\u0127\u0003%\u0012\u0000\u0127R\u0001\u0000\u0000\u0000\u0128\u0129\u0003"+
		"\u0011\b\u0000\u0129\u012a\u0003\u001b\r\u0000\u012a\u012b\u0003\u000f"+
		"\u0007\u0000\u012b\u012c\u0003\t\u0004\u0000\u012c\u012d\u0003#\u0011"+
		"\u0000\u012d\u012e\u0003\u0011\b\u0000\u012e\u012f\u0003\'\u0013\u0000"+
		"\u012f\u0130\u0003%\u0012\u0000\u0130T\u0001\u0000\u0000\u0000\u0131\u0132"+
		"\u0003%\u0012\u0000\u0132\u0133\u0003\t\u0004\u0000\u0133\u0134\u0003"+
		"\u0017\u000b\u0000\u0134\u0135\u0003\u000b\u0005\u0000\u0135V\u0001\u0000"+
		"\u0000\u0000\u0136\u0137\u0005t\u0000\u0000\u0137\u0138\u0003#\u0011\u0000"+
		"\u0138\u0139\u0003)\u0014\u0000\u0139\u013a\u0003\t\u0004\u0000\u013a"+
		"X\u0001\u0000\u0000\u0000\u013b\u013c\u0005f\u0000\u0000\u013c\u013d\u0003"+
		"\u0001\u0000\u0000\u013d\u013e\u0003\u0017\u000b\u0000\u013e\u013f\u0003"+
		"%\u0012\u0000\u013f\u0140\u0003\t\u0004\u0000\u0140Z\u0001\u0000\u0000"+
		"\u0000\u0141\u0144\u0003Y,\u0000\u0142\u0144\u0003W+\u0000\u0143\u0141"+
		"\u0001\u0000\u0000\u0000\u0143\u0142\u0001\u0000\u0000\u0000\u0144\\\u0001"+
		"\u0000\u0000\u0000\u0145\u0146\u0005=\u0000\u0000\u0146\u0147\u0005>\u0000"+
		"\u0000\u0147^\u0001\u0000\u0000\u0000\u0148\u0149\u0005@\u0000\u0000\u0149"+
		"`\u0001\u0000\u0000\u0000\u014a\u014b\u0005:\u0000\u0000\u014bb\u0001"+
		"\u0000\u0000\u0000\u014c\u014d\u0005;\u0000\u0000\u014dd\u0001\u0000\u0000"+
		"\u0000\u014e\u014f\u0005(\u0000\u0000\u014ff\u0001\u0000\u0000\u0000\u0150"+
		"\u0151\u0005)\u0000\u0000\u0151h\u0001\u0000\u0000\u0000\u0152\u0153\u0005"+
		",\u0000\u0000\u0153j\u0001\u0000\u0000\u0000\u0154\u0155\u0005.\u0000"+
		"\u0000\u0155l\u0001\u0000\u0000\u0000\u0156\u0157\u0005{\u0000\u0000\u0157"+
		"n\u0001\u0000\u0000\u0000\u0158\u0159\u0005}\u0000\u0000\u0159p\u0001"+
		"\u0000\u0000\u0000\u015a\u015b\u0005[\u0000\u0000\u015br\u0001\u0000\u0000"+
		"\u0000\u015c\u015d\u0005]\u0000\u0000\u015dt\u0001\u0000\u0000\u0000\u015e"+
		"\u015f\u0007\u001a\u0000\u0000\u015fv\u0001\u0000\u0000\u0000\u0160\u0162"+
		"\u0003u:\u0000\u0161\u0160\u0001\u0000\u0000\u0000\u0162\u0163\u0001\u0000"+
		"\u0000\u0000\u0163\u0161\u0001\u0000\u0000\u0000\u0163\u0164\u0001\u0000"+
		"\u0000\u0000\u0164x\u0001\u0000\u0000\u0000\u0165\u0166\u0007\u001b\u0000"+
		"\u0000\u0166z\u0001\u0000\u0000\u0000\u0167\u0168\u0007\u001c\u0000\u0000"+
		"\u0168|\u0001\u0000\u0000\u0000\u0169\u016a\u0007\u001d\u0000\u0000\u016a"+
		"~\u0001\u0000\u0000\u0000\u016b\u016c\u0003\u001b\r\u0000\u016c\u016d"+
		"\u0003\u001d\u000e\u0000\u016d\u016e\u0003\'\u0013\u0000\u016e\u0080\u0001"+
		"\u0000\u0000\u0000\u016f\u0172\u0003{=\u0000\u0170\u0172\u0005_\u0000"+
		"\u0000\u0171\u016f\u0001\u0000\u0000\u0000\u0171\u0170\u0001\u0000\u0000"+
		"\u0000\u0172\u0178\u0001\u0000\u0000\u0000\u0173\u0177\u0003y<\u0000\u0174"+
		"\u0177\u0005_\u0000\u0000\u0175\u0177\u0003u:\u0000\u0176\u0173\u0001"+
		"\u0000\u0000\u0000\u0176\u0174\u0001\u0000\u0000\u0000\u0176\u0175\u0001"+
		"\u0000\u0000\u0000\u0177\u017a\u0001\u0000\u0000\u0000\u0178\u0176\u0001"+
		"\u0000\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000\u0179\u0082\u0001"+
		"\u0000\u0000\u0000\u017a\u0178\u0001\u0000\u0000\u0000\u017b\u0181\u0003"+
		"}>\u0000\u017c\u0180\u0003y<\u0000\u017d\u0180\u0005_\u0000\u0000\u017e"+
		"\u0180\u0003u:\u0000\u017f\u017c\u0001\u0000\u0000\u0000\u017f\u017d\u0001"+
		"\u0000\u0000\u0000\u017f\u017e\u0001\u0000\u0000\u0000\u0180\u0183\u0001"+
		"\u0000\u0000\u0000\u0181\u017f\u0001\u0000\u0000\u0000\u0181\u0182\u0001"+
		"\u0000\u0000\u0000\u0182\u018e\u0001\u0000\u0000\u0000\u0183\u0181\u0001"+
		"\u0000\u0000\u0000\u0184\u0185\u0005S\u0000\u0000\u0185\u0186\u0005E\u0000"+
		"\u0000\u0186\u0187\u0005L\u0000\u0000\u0187\u0188\u0005F\u0000\u0000\u0188"+
		"\u0189\u0005_\u0000\u0000\u0189\u018a\u0005T\u0000\u0000\u018a\u018b\u0005"+
		"Y\u0000\u0000\u018b\u018c\u0005P\u0000\u0000\u018c\u018e\u0005E\u0000"+
		"\u0000\u018d\u017b\u0001\u0000\u0000\u0000\u018d\u0184\u0001\u0000\u0000"+
		"\u0000\u018e\u0084\u0001\u0000\u0000\u0000\u018f\u0190\u0005<\u0000\u0000"+
		"\u0190\u0191\u0005-\u0000\u0000\u0191\u0086\u0001\u0000\u0000\u0000\u0192"+
		"\u0193\u0005+\u0000\u0000\u0193\u0088\u0001\u0000\u0000\u0000\u0194\u0195"+
		"\u0005-\u0000\u0000\u0195\u008a\u0001\u0000\u0000\u0000\u0196\u0197\u0005"+
		"*\u0000\u0000\u0197\u008c\u0001\u0000\u0000\u0000\u0198\u0199\u0005/\u0000"+
		"\u0000\u0199\u008e\u0001\u0000\u0000\u0000\u019a\u019b\u0005~\u0000\u0000"+
		"\u019b\u0090\u0001\u0000\u0000\u0000\u019c\u019d\u0005=\u0000\u0000\u019d"+
		"\u0092\u0001\u0000\u0000\u0000\u019e\u019f\u0005<\u0000\u0000\u019f\u0094"+
		"\u0001\u0000\u0000\u0000\u01a0\u01a1\u0005<\u0000\u0000\u01a1\u01a2\u0005"+
		"=\u0000\u0000\u01a2\u0096\u0001\u0000\u0000\u0000\u01a3\u01a4\u0005\\"+
		"\u0000\u0000\u01a4\u01ac\u0005\"\u0000\u0000\u01a5\u01a6\u0005\\\u0000"+
		"\u0000\u01a6\u01ac\u0005\n\u0000\u0000\u01a7\u01a8\u0005\\\u0000\u0000"+
		"\u01a8\u01a9\u0005\r\u0000\u0000\u01a9\u01ac\u0005\n\u0000\u0000\u01aa"+
		"\u01ac\b\u001e\u0000\u0000\u01ab\u01a3\u0001\u0000\u0000\u0000\u01ab\u01a5"+
		"\u0001\u0000\u0000\u0000\u01ab\u01a7\u0001\u0000\u0000\u0000\u01ab\u01aa"+
		"\u0001\u0000\u0000\u0000\u01ac\u0098\u0001\u0000\u0000\u0000\u01ad\u01b1"+
		"\u0005\"\u0000\u0000\u01ae\u01b0\u0003\u0097K\u0000\u01af\u01ae\u0001"+
		"\u0000\u0000\u0000\u01b0\u01b3\u0001\u0000\u0000\u0000\u01b1\u01af\u0001"+
		"\u0000\u0000\u0000\u01b1\u01b2\u0001\u0000\u0000\u0000\u01b2\u01b7\u0001"+
		"\u0000\u0000\u0000\u01b3\u01b1\u0001\u0000\u0000\u0000\u01b4\u01b8\u0005"+
		"\n\u0000\u0000\u01b5\u01b6\u0005\r\u0000\u0000\u01b6\u01b8\u0005\n\u0000"+
		"\u0000\u01b7\u01b4\u0001\u0000\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000"+
		"\u0000\u01b8\u01b9\u0001\u0000\u0000\u0000\u01b9\u01ba\u0006L\u0000\u0000"+
		"\u01ba\u009a\u0001\u0000\u0000\u0000\u01bb\u01bf\u0005\"\u0000\u0000\u01bc"+
		"\u01be\u0003\u0097K\u0000\u01bd\u01bc\u0001\u0000\u0000\u0000\u01be\u01c1"+
		"\u0001\u0000\u0000\u0000\u01bf\u01bd\u0001\u0000\u0000\u0000\u01bf\u01c0"+
		"\u0001\u0000\u0000\u0000\u01c0\u01c2\u0001\u0000\u0000\u0000\u01c1\u01bf"+
		"\u0001\u0000\u0000\u0000\u01c2\u01c6\u0005\u0000\u0000\u0000\u01c3\u01c5"+
		"\u0003\u0097K\u0000\u01c4\u01c3\u0001\u0000\u0000\u0000\u01c5\u01c8\u0001"+
		"\u0000\u0000\u0000\u01c6\u01c4\u0001\u0000\u0000\u0000\u01c6\u01c7\u0001"+
		"\u0000\u0000\u0000\u01c7\u01c9\u0001\u0000\u0000\u0000\u01c8\u01c6\u0001"+
		"\u0000\u0000\u0000\u01c9\u01ca\u0005\"\u0000\u0000\u01ca\u01cb\u0006M"+
		"\u0001\u0000\u01cb\u009c\u0001\u0000\u0000\u0000\u01cc\u01cd\u0003\u00a5"+
		"R\u0000\u01cd\u01ce\u0004N\u0000\u0000\u01ce\u01cf\u0006N\u0002\u0000"+
		"\u01cf\u009e\u0001\u0000\u0000\u0000\u01d0\u01d1\u0005*\u0000\u0000\u01d1"+
		"\u01d2\u0005)\u0000\u0000\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d3\u01d4"+
		"\u0006O\u0003\u0000\u01d4\u00a0\u0001\u0000\u0000\u0000\u01d5\u01d9\u0005"+
		"\"\u0000\u0000\u01d6\u01d8\u0003\u0097K\u0000\u01d7\u01d6\u0001\u0000"+
		"\u0000\u0000\u01d8\u01db\u0001\u0000\u0000\u0000\u01d9\u01d7\u0001\u0000"+
		"\u0000\u0000\u01d9\u01da\u0001\u0000\u0000\u0000\u01da\u01dc\u0001\u0000"+
		"\u0000\u0000\u01db\u01d9\u0001\u0000\u0000\u0000\u01dc\u01dd\u0005\u0000"+
		"\u0000\u0001\u01dd\u01de\u0006P\u0004\u0000\u01de\u00a2\u0001\u0000\u0000"+
		"\u0000\u01df\u01e0\u0005(\u0000\u0000\u01e0\u01e1\u0005*\u0000\u0000\u01e1"+
		"\u01ea\u0001\u0000\u0000\u0000\u01e2\u01e9\u0003\u00a7S\u0000\u01e3\u01e7"+
		"\b\u001f\u0000\u0000\u01e4\u01e5\u0005*\u0000\u0000\u01e5\u01e7\b \u0000"+
		"\u0000\u01e6\u01e3\u0001\u0000\u0000\u0000\u01e6\u01e4\u0001\u0000\u0000"+
		"\u0000\u01e7\u01e9\u0001\u0000\u0000\u0000\u01e8\u01e2\u0001\u0000\u0000"+
		"\u0000\u01e8\u01e6\u0001\u0000\u0000\u0000\u01e9\u01ec\u0001\u0000\u0000"+
		"\u0000\u01ea\u01eb\u0001\u0000\u0000\u0000\u01ea\u01e8\u0001\u0000\u0000"+
		"\u0000\u01eb\u01ed\u0001\u0000\u0000\u0000\u01ec\u01ea\u0001\u0000\u0000"+
		"\u0000\u01ed\u01ee\u0005\u0000\u0000\u0001\u01ee\u01ef\u0006Q\u0005\u0000"+
		"\u01ef\u00a4\u0001\u0000\u0000\u0000\u01f0\u01f4\u0005\"\u0000\u0000\u01f1"+
		"\u01f3\u0003\u0097K\u0000\u01f2\u01f1\u0001\u0000\u0000\u0000\u01f3\u01f6"+
		"\u0001\u0000\u0000\u0000\u01f4\u01f2\u0001\u0000\u0000\u0000\u01f4\u01f5"+
		"\u0001\u0000\u0000\u0000\u01f5\u01f7\u0001\u0000\u0000\u0000\u01f6\u01f4"+
		"\u0001\u0000\u0000\u0000\u01f7\u01f8\u0005\"\u0000\u0000\u01f8\u01f9\u0006"+
		"R\u0006\u0000\u01f9\u00a6\u0001\u0000\u0000\u0000\u01fa\u01fb\u0005(\u0000"+
		"\u0000\u01fb\u01fc\u0005*\u0000\u0000\u01fc\u0201\u0001\u0000\u0000\u0000"+
		"\u01fd\u0200\u0003\u00a7S\u0000\u01fe\u0200\t\u0000\u0000\u0000\u01ff"+
		"\u01fd\u0001\u0000\u0000\u0000\u01ff\u01fe\u0001\u0000\u0000\u0000\u0200"+
		"\u0203\u0001\u0000\u0000\u0000\u0201\u0202\u0001\u0000\u0000\u0000\u0201"+
		"\u01ff\u0001\u0000\u0000\u0000\u0202\u0204\u0001\u0000\u0000\u0000\u0203"+
		"\u0201\u0001\u0000\u0000\u0000\u0204\u0205\u0005*\u0000\u0000\u0205\u0206"+
		"\u0005)\u0000\u0000\u0206\u0207\u0001\u0000\u0000\u0000\u0207\u0208\u0006"+
		"S\u0007\u0000\u0208\u00a8\u0001\u0000\u0000\u0000\u0209\u020a\u0005-\u0000"+
		"\u0000\u020a\u020b\u0005-\u0000\u0000\u020b\u020f\u0001\u0000\u0000\u0000"+
		"\u020c\u020e\b!\u0000\u0000\u020d\u020c\u0001\u0000\u0000\u0000\u020e"+
		"\u0211\u0001\u0000\u0000\u0000\u020f\u020d\u0001\u0000\u0000\u0000\u020f"+
		"\u0210\u0001\u0000\u0000\u0000\u0210\u0212\u0001\u0000\u0000\u0000\u0211"+
		"\u020f\u0001\u0000\u0000\u0000\u0212\u0213\u0006T\u0007\u0000\u0213\u00aa"+
		"\u0001\u0000\u0000\u0000\u0214\u0216\u0007\"\u0000\u0000\u0215\u0214\u0001"+
		"\u0000\u0000\u0000\u0216\u0217\u0001\u0000\u0000\u0000\u0217\u0215\u0001"+
		"\u0000\u0000\u0000\u0217\u0218\u0001\u0000\u0000\u0000\u0218\u0219\u0001"+
		"\u0000\u0000\u0000\u0219\u021a\u0006U\u0007\u0000\u021a\u00ac\u0001\u0000"+
		"\u0000\u0000\u021b\u021c\t\u0000\u0000\u0000\u021c\u021d\u0006V\b\u0000"+
		"\u021d\u00ae\u0001\u0000\u0000\u0000\u0017\u0000\u0143\u0163\u0171\u0176"+
		"\u0178\u017f\u0181\u018d\u01ab\u01b1\u01b7\u01bf\u01c6\u01d9\u01e6\u01e8"+
		"\u01ea\u01f4\u01ff\u0201\u020f\u0217\t\u0001L\u0000\u0001M\u0001\u0001"+
		"N\u0002\u0001O\u0003\u0001P\u0004\u0001Q\u0005\u0001R\u0006\u0006\u0000"+
		"\u0000\u0001V\u0007";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}