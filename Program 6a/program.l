%{
#include<stdio.h>
int sl=0;
int ml=0;
%}

%%
"//".+ {sl++;}
"/*"[^/*]*[\n]*"*/" {ml++;}
.echo;
%%

void main()
{
yyin=fopen("f1.c","r");
yyout=fopen("f2.c","w");
yylex();
printf("\n Number of single line comments are = %d\n",sl);
printf("\n Number of multiline comments are =%d\n",ml);
}
