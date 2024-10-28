parser grammar CoolParser;

options {
    tokenVocab = CoolLexer;
}

@header {
    package cool.parser;
}

program : (class SEMICOLON)+ EOF
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
	 | IF cond=expr THEN thenBr=expr ELSE elseBr=expr FI # if
	 | WHILE cond=expr LOOP body=expr POOL # while
	 | CASE value=expr OF (ID COLON type=TYPE RIGHT_ARROW branch=expr SEMICOLON)+ ESAC # case
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

def : name=ID COLON type=TYPE (ASSIGN expr)?
	;

method : name=ID OPEN_PAR (formal (COMMA ID formal)*)? CLOSE_PAR 
	   COLON type=TYPE OPEN_BRACE expr CLOSE_BRACE;

formal: ID COLON TYPE;

feature : def
		| method;

class : CLASS name=TYPE (INHERITS parent=TYPE)? OPEN_BRACE (feature SEMICOLON)* CLOSE_BRACE
	;
