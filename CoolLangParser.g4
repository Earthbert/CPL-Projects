parser grammar CoolLangParser;

options {
	tokenVocab = CoolLangLexer;
}

expr : ID
	 | INT
	 | FLOAT
	 | BOOL_VAL
	 | let
	 | if
	 | while
	 | case
	 | OPEN_BRACE (expr SEMICOLON)+ CLOSE_BRACE
	;

def : ID COLON TYPE (ASSIGN expr)?;

let : LET def IN expr;

if : IF expr THEN expr ELSE expr FI;

while : WHILE expr LOOP expr POOL;

case : CASE ID OF (ID COLON TYPE RIGHT_ARROW expr)+ ESAC;
