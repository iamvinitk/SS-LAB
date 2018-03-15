%{
	#include "y.tab.h"
	extern int yylval;
%}
%%
[a-zA-Z_]* {return L;}
[0-9]* {return D;}
%%

