%{
#include"y.tab.h"
extern int yylval;
%}
%%
[*] {return A;}
[main] {return B;}
. {return yytext[0];}
%%





