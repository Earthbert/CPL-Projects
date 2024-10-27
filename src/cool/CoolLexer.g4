lexer grammar CoolLexer;

tokens {
	ERROR
}

@members {    
    private void raiseError(String msg) {
        setText(msg);
        setType(ERROR);
    }
}

fragment A: [aA];
fragment B: [bB];
fragment C: [cC];
fragment D: [dD];
fragment E: [eE];
fragment F: [fF];
fragment G: [gG];
fragment H: [hH];
fragment I: [iI];
fragment J: [jJ];
fragment K: [kK];
fragment L: [lL];
fragment M: [mM];
fragment N: [nN];
fragment O: [oO];
fragment P: [pP];
fragment Q: [qQ];
fragment R: [rR];
fragment S: [sS];
fragment T: [tT];
fragment U: [uU];
fragment V: [vV];
fragment W: [wW];
fragment X: [xX];
fragment Y: [yY];
fragment Z: [zZ];

IF: I F;
THEN: T H E N;
ELSE: E L S E;
FI: F I;

WHILE: W H I L E;
LOOP: L O O P;
POOL: P O O L;

CASE: C A S E;
OF: O F;
ESAC: E S A C;

LET: L E T;
IN: I N;

IS_VOID: I S V O I D;
NEW: N E W;

CLASS: C L A S S;
INHERITS: I N H E R I T S;

SELF: S E L F;

fragment TRUE: 't' R U E;
fragment FALSE: 'f' A L S E;
BOOL_VAL: FALSE | TRUE;

RIGHT_ARROW: '=>';
AT: '@';

COLON: ':';
SEMICOLON: ';';

OPEN_PAR: '(';
CLOSE_PAR: ')';

COMMA: ',';
DOT: '.';

OPEN_BRACE: '{';
CLOSE_BRACE: '}';

OPEN_BRACKET: '[';
CLOSE_BRACKET: ']';

fragment DIGIT: [0-9];
INT: DIGIT+;

fragment LETTER: [a-zA-Z];
fragment LOWER: [a-z];
fragment UPPER: [A-Z];
ID: (LOWER | '_') (LETTER | '_' | DIGIT)*;

TYPE: UPPER (LETTER | '_' | DIGIT)* | 'SELF_TYPE';

ASSIGN: '<-';
PLUS: '+';
MINUS: '-';
TIMES: '*';
DIV: '/';
NEG: '~';

NOT: 'not';

EQ: '=';
LT: '<';
LE: '<=';

fragment STRING_CHAR:
	'\\"'
	| '\\\n'
	| '\\\r\n'
	| ~('\n' | '\r' | '"' | '\u0000');

ERROR_UNTERMINATED_STRING:
	'"' STRING_CHAR* ('\n' | '\r\n') { raiseError("Unterminated string constant"); };

ERROR_STRING_NULL_CHAR:
	'"' STRING_CHAR* '\u0000' STRING_CHAR* '"' { raiseError("String contains null character"); };

ERROR_STRING_TOO_LONG:
	STRING { getText().length() > 1024 }? { raiseError("String constant too long"); };

ERROR_UMATCHED_BLOCK_COMMENT: '*)' { raiseError("Unmatched *\u0029"); };

ERROR_EOF_IN_STRING: '"' STRING_CHAR* EOF { raiseError("EOF in string constant"); };

ERROR_EOF_IN_COMMENT: '(*' (BLOCK_COMMENT | .)*? EOF { raiseError("EOF in comment"); };

STRING:
	'"' STRING_CHAR* '"' {  setText(getText().substring(1, getText().length() - 1)); 
			                setText(getText().replace("\\n", "\n")
			  					             .replace("\\t", "\t")
								             .replace("\\f", "\f")
                                             .replace("\\b", "\b")
											 .replaceAll("\\\\([a-zA-Z])", "$1")
                                             .replace("\\\n", "")
                                             .replace("\\\r", "")); };

BLOCK_COMMENT: '(*' (BLOCK_COMMENT | .)*? '*)' -> skip;

LINE_COMMENT: '--' ~[\r\n]* -> skip;

WS: [ \n\f\r\t]+ -> skip;

ERROR_INVALID_CHAR: . { raiseError("Invalid character: " + getText()); };
