%{
	#include<stdio.h>
	int bracket=0, op=0, opr=0;
%}
%%
"(" {bracket++;}
")" {bracket--;}
[0-9] {op++;}
[+\-*/] {opr++;}


%%
void main()
{
	printf("Enter the expression: ");
	yylex();
	int d = op - opr;
		printf("Values: %d %d\n",bracket, d);
	if(bracket == 0 && d == 1){
	printf("Expression is valid\n");
	printf("Operators: %d\n",op);
	printf("Operands: %d\n",opr);
	}
	else{
		printf("Expression is isvalid");
	}
}
