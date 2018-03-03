%{
	include<stdio.h>
	int i=0;
%}
%%
	[0-9] {i++;}
%%
void main()
{
	printf("Input: ");
	yylex();
	printf("Count: %d\n",i);
}
