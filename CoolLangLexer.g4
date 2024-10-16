lexer grammar CoolLangLexer;

fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];

// Keywords
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

TRUE: 't' R U E;
FALSE: 'f' A L S E;
BOOL_VAL: TRUE | FALSE;


// Special symbols
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


// Numbers
fragment DIGIT: [0-9];
INT: DIGIT+;

fragment DIGITS: DIGIT+;
fragment MOBILE: ('.' DIGITS | DIGITS '.'); // Has to be before FRACTION
fragment FRACTION: ('.' DIGITS?)?;
fragment EXPONENT: ('e' ('+' | '-')? DIGITS)?;
FLOAT: ((DIGITS FRACTION) | MOBILE) EXPONENT;


// Identifiers
fragment LETTER: [a-zA-Z];
fragment LOWER: [a-z];
fragment UPPER: [A-Z];
ID: (LOWER | '_') (LETTER | '_' | DIGIT)*;


// Types
TYPE: UPPER (LETTER | '_' | DIGIT)*;


// Operators
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


// Literals
STRING: '"' ('\\"' | .)*? '"';


// Comments
BLOCK_COMMENT: 	('*)' { System.err.println("End of block comment not allowed"); }
				|
				'(*'
				(BLOCK_COMMENT | .)*? 
				('*)' | (EOF { System.err.println("Unclosed block comment");}))) -> skip;

LINE_COMMENT: '--' ~[\r\n]* -> skip;


// Whitespace
WS: [ \n\r\t]+ -> skip;
