%{
	#include<stdio.h>
	int v=0,z=0;
%}
%%
[aeiouAEIOU] {v++;}
[a-zA-Z] {z++;}


%%
void main()
{
	printf("Input: ");
	yylex();
	printf("Vowels: %d\n",v);
	printf("Consonants: %d\n",z);
}
