parser grammar CoolParser;

options {
	tokenVocab = CoolLexer;
}

@header {
    package cool.parser;
}

program: (class SEMICOLON)+ EOF;

expr:
	// Identifiers
	ID		# id
	| SELF	# self
	// Literals
	| INT		# int
	| STRING	# string
	| BOOL_VAL	# boolean
	// Control flow
	| LET def (COMMA def)* IN expr								# let
	| IF cond = expr THEN thenBr = expr ELSE elseBr = expr FI	# if
	| WHILE cond = expr LOOP body = expr POOL					# while
	| CASE value = expr OF (
		id += ID COLON type += TYPE RIGHT_ARROW branch += expr SEMICOLON
	)+ ESAC										# case
	| OPEN_BRACE (expr SEMICOLON)+ CLOSE_BRACE	# block
	| OPEN_PAR expr CLOSE_PAR					# par
	// Assignments
	| ID ASSIGN expr # assign
	// Operators
	| left = expr op = PLUS right = expr	# artihmetic
	| left = expr op = MINUS right = expr	# artihmetic
	| left = expr op = TIMES right = expr	# artihmetic
	| left = expr op = DIV right = expr		# artihmetic
	| left = expr op = LT right = expr		# comparison
	| left = expr op = LE right = expr		# comparison
	| left = expr op = EQ right = expr		# comparison
	| NOT expr								# not
	| NEG expr								# neg
	| IS_VOID expr							# isvoid
	// Calls
	| NEW TYPE															# new
	| (SELF)? (AT TYPE)? ID OPEN_PAR (arg+=expr (COMMA arg+=expr)*)? CLOSE_PAR	# thisCall
	| object=expr (AT TYPE)? DOT ID OPEN_PAR (arg+=expr (COMMA arg+=expr)*)? CLOSE_PAR	# methodCall;

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