%{
#include <stdio.h>
int yylex();
int yyerror(char *s);
%}
%%
S : 'a' S 'b'
  | 
  ;
%%
int main(){
    printf("Enter string:\n");
    if(yyparse()==0)
        printf("Valid\n");
}
int yyerror(char *s){
    printf("Invalid\n");
}