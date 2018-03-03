%{
#include<stdio.h>
extern int yylex();
%}
%token A
%token B
%%
expr : S
S: S A     
 | B ;
%%
void main(){
	printf("Enter the expression\n");
	if(yyparse() == 0)
			printf("Valid\n");
}

int yyerror(){
printf("Error\n");
return 0;
}




