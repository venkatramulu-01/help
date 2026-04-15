%{
#include "3.tab.h"
%}
%%
[a-zA-Z]    return NUM;
[+\-*/()]   return yytext[0];
[ \t\n]     ;  
.           return yytext[0];
%%
int yywrap() {
    return 1;
}

