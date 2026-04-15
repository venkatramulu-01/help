%{
#include <stdio.h>
int yylex();
int yyerror(char *s);
%}

%token NUM
%left '+' '-'
%left '*' '/'

%%
E : E '+' E
  | E '-' E
  | E '*' E
  | E '/' E
  | '(' E ')'
  | NUM
  ;
%%

int main(){
    if(yyparse()==0)
        printf("Valid Expression\n");
    return 0;
}

int yyerror(char *s){
    printf("Invalid Expression\n");
    return 0;
}