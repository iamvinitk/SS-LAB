%{
#include<stdio.h>
extern int yylex();
%}
%token L
%token D
%%
expr : S {printf("Valid Name\n");}
S : L D
  | L
  |;
%%
void main()
{
	printf("Enter the Variable Name\n");
	yyparse();                                        
}

int yyerror(){
printf("Invalid Variable Name\n");
return 0;
}




