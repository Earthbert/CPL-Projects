parser grammar CoolParser;

options {
	tokenVocab = CoolLexer;
}

@header {
    package cool.parser;
}

program: (class SEMICOLON)+ EOF;

expr:

	// Calls
	(SELF)? (AT TYPE)? ID OPEN_PAR (
		arg += expr (COMMA arg += expr)*
	)? CLOSE_PAR # thisCall
	| object = expr (AT TYPE)? DOT ID OPEN_PAR (
		arg += expr (COMMA arg += expr)*
	)? CLOSE_PAR # methodCall

	// Control flow
	| IF cond = expr THEN thenBr = expr ELSE elseBr = expr FI	# if
	| WHILE cond = expr LOOP body = expr POOL					# while
	| OPEN_BRACE (expr SEMICOLON)+ CLOSE_BRACE					# block
	| LET def (COMMA def)* IN expr								# let
	| CASE value = expr OF (
		id += ID COLON type += TYPE RIGHT_ARROW branch += expr SEMICOLON
	)+ ESAC		# case
	| NEW TYPE	# new

	// Operators
	| IS_VOID expr									# isvoid
	| left = expr op = (TIMES | DIV) right = expr	# artihmetic
	| left = expr op = (PLUS | MINUS) right = expr	# artihmetic
	| NEG expr										# neg
	| left = expr op = (LT | LE | EQ) right = expr	# comparison
	| NOT expr										# not
	| OPEN_PAR expr CLOSE_PAR						# par

	// Literals Identifiers
	| SELF		# self
	| ID		# id
	| INT		# int
	| STRING	# string
	| BOOL_VAL	# boolean

	// Assignments
	| ID ASSIGN expr # assign;

def: name = ID COLON type = TYPE (ASSIGN expr)?;

method:
	name = ID OPEN_PAR (formal (COMMA formal)*)? CLOSE_PAR COLON type = TYPE OPEN_BRACE expr
		CLOSE_BRACE;

formal: ID COLON TYPE;

feature: def | method;

class:
	CLASS name = TYPE (INHERITS parent = TYPE)? OPEN_BRACE (
		feature SEMICOLON
	)* CLOSE_BRACE;