parser grammar CoolParser;

options {
    tokenVocab = CoolLexer;
}

program : (class SEMICOLON)* EOF
	;

expr :
	 // Identifiers
	   ID # id
	 | SELF # self
	 // Literals
	 | INT # int
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
	 | expr op=PLUS expr # artihmetic
	 | expr op=MINUS expr # artihmetic
	 | expr op=TIMES expr # artihmetic
	 | expr op=DIV expr # artihmetic
	 | expr op=LT expr # comparison
	 | expr op=LE expr # comparison
	 | expr op=EQ expr # comparison
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

member : def | method
	;

class : CLASS name=TYPE (INHERITS parent=TYPE)? OPEN_BRACE (member SEMICOLON)* CLOSE_BRACE
	;
