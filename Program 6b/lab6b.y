%{
#include<stdio.h>
extern int yylex();
%}
%token A
%token B
%%

%%
void main()
{
	printf("Enter the filename\n");
	yyparse();
}

int yyerror(){
return 0;
}




