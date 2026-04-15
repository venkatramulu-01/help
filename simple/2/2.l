%{
#include <stdio.h>
%}
%%
"int"|"float"|"if"|"else"      { printf("%s -> Keyword\n", yytext); }
[0-9]+                         { printf("%s -> Number\n", yytext); }
[a-zA-Z_][a-zA-Z0-9_]*         { printf("%s -> Identifier\n", yytext); }
[+\-*/=]                       { printf("%s -> Operator\n", yytext); }
[ \t\n]                        ;   
.                              { printf("%s -> Special Symbol\n", yytext); }
%%
int main() {
    printf("Enter input:\n");
    yylex();
    return 0;
}
int yywrap() {
    return 1;
}