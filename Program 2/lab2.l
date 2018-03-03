/* Develop implement and execute a program using YACC tool to recognise all strings ending with b preceded by n number of a's using the grammar a^nb */
%{
#include"y.tab.h"
extern int yylval;
%}
%%
[aA] {return A;}
[bB] {return B;}
. {return yytext[0];}
%%





