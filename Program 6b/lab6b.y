%{
#include<stdio.h>
extern int yylex();
extern FILE *yyin;
int id=0,key=0,op=0;
%}
%token OP
%token KW
%token ID
%%
S: OP S {op++;}
 | KW S {key++;}
 | ID S {id++;}
 | OP {op++;}
 | KW {key++;}
 | ID {id++;};
%%
void main()
{
	yyin = fopen("fin.txt", "r");
	yyparse();
	printf("No. of keywords : %d\n", key);
	printf("No. of identifiers : %d\n", id);
	printf("No. of operators : %d\n", op);		
}

int yyerror(){
return 0;
}




