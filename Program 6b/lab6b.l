%{
#include"y.tab.h"
extern int yylval;
%}
%%
[ \t] {;}
[+\-/*=<>]+ {printf("%s is an operator \n", yytext); return OP;}
"main"|"int"|"float"|"printf"|"return"|"extern" {printf("%s is a keyword \n", yytext); return KW;}
["][a-zA-Z_0-9 \t\n]*["] {;} //To ignore strings
[a-zA-Z_][a-zA-Z0-9_]+ {printf("%s is an identifier \n", yytext); return ID;}
. {;}
%%


