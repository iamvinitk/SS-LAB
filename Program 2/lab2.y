%{
#include<stdio.h>
extern int yylex();
%}
%token A
%token B
%%
expr : S'\n' {printf("Valid\n");}
S: A S
 | B;
%%
void main()
{
	printf("Enter the string\n");
	yyparse();
}

int yyerror(){
printf("Invalid string\n");
return 0;
}




