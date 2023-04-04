grammar Expr;

// parser rules
prog : (expr ';' NEWLINE?)*; 

expr : expr ('*'|'/') expr  # infixExpr
     | expr ('+'|'-') expr  # infixExpr 
     | '-'?num              # numberExpr
     | '(' expr ')'         # parensExpr
     | VAR'(' expr ')'      # afunctionExpr
     | VAR'('expr','expr')' # bfunctionExpr
     | VAR'=''-'?num        # assignExpr
     | VAR                  # variableExpr

     ;
     
num  : INT
     | REAL
     ;
     
// lexer rules                    
NEWLINE: [\r\n]+ ;
INT: [0-9]+ ;          // should handle negatives
REAL: [0-9]+'.'[0-9]* ; // should handle signs(+/-)
WS: [ \t\r\n]+ -> skip ;
VAR: [a-zA-Z]+ ;
