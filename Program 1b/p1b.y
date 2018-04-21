%{
#include<stdio.h>
extern int yylex();
%}
%token NUM
%lef                                                                                                                                                                                                              t '+''-'
%left '*''/'
%%
expr : E {printf("Result:%d",$$);return 0;}
E : E '+' E {$$=$1+$3;}
     | E '-' E {$$=$1-$3;}
	 | E '*' E {$$=$1*$3;}
	 | E '/' E {$$=$1/$3;}
	 | '(' E ')'{$$=$2;}	
	 | NUM {$$=$1;}
	 | ;
%%
void main(){
	printf("Enter the expression\n");
	yyparse();
}

int yyerror(){
printf("Error");
return 0;
}




