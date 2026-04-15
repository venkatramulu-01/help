#include <stdio.h>
#include <ctype.h>
int main(){
    char s[50];
    int i=1;
    printf("Enter variable: ");
    scanf("%s",s);
    if(!isalpha(s[0])){
        printf("Invalid variable\n");
        return 0;
    }
    while(s[i]){
        if(!isalnum(s[i])){
            printf("Invalid variable\n");
            return 0;
        }
        i++;
    }
    printf("Valid variable\n");
}