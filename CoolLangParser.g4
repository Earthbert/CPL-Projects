parser grammar CoolLangParser;

options {
	tokenVocab = CoolLangLexer;
}

program : (class SEMICOLON)* EOF
	;

expr :
	 // Literals
	   ID # id
	 | SELF # self
	 | INT # int
	 | FLOAT # float
	 | STRING # string
	 | BOOL_VAL # boolean
	 // Control flow
	 | LET def (COMMA def)* IN expr # let
	 | IF expr THEN expr ELSE expr FI # if
	 | WHILE expr LOOP expr POOL # while
	 | CASE expr OF (ID COLON TYPE RIGHT_ARROW expr SEMICOLON)+ ESAC # case
	 | OPEN_BRACE (expr SEMICOLON)+ CLOSE_BRACE # block
	 | OPEN_PAR expr CLOSE_PAR # par
	 // Assignments
	 | ID ASSIGN expr # assign
	 // Operators
	 | expr PLUS expr # plus
	 | expr MINUS expr # minus
	 | expr TIMES expr # times
	 | expr DIV expr # div
	 | expr LT expr # lt
	 | expr LE expr # le
	 | expr EQ expr # eq
	 | NOT expr # not
	 | NEG expr # neg
	 | IS_VOID expr # isvoid
	 // Calls
	 | NEW TYPE # constructor
	 | (SELF)? (AT TYPE)? ID OPEN_PAR (expr (COMMA expr)*)? CLOSE_PAR # thisCall
	 | expr (AT TYPE)? DOT ID OPEN_PAR (expr (COMMA expr)*)? CLOSE_PAR # methodCall
	;

def : ID COLON TYPE (ASSIGN expr)?
	;

method : ID OPEN_PAR (ID COLON TYPE (COMMA ID COLON TYPE)*)? CLOSE_PAR 
	   COLON TYPE OPEN_BRACE expr CLOSE_BRACE;

class : CLASS TYPE (INHERITS TYPE)? OPEN_BRACE ((def | method) SEMICOLON)* CLOSE_BRACE
	;
