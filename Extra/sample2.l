%{
#include<stdio.h>
int a=0,b=0;
%}
%%
[+\-*/] {a++;}
[a-z0-9] {b++;}
%%
void main()
{
printf("Enter text: ");
yylex();
printf("No. of operators: %d\n",a);
printf("No. of operands: %d\n",b);
}
