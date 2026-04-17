#include<stdio.h>
#include<string.h>
int main(){
    char *s="Hello World";
    char And[20];
    char Xor[20];
    int i;
    //printf("Original String:%s\n",s);

    for(i=0;s[i]!='\0';i++){
        And[i]=s[i]&127;
        printf("'%c' AND 127 is:%d\n",s[i],s[i]&127);
    }
    printf("And Result:%s\n",And);
    for(i=0;s[i]!='\0';i++){
        printf("'%c' XOR 127 is:%d\n",s[i],s[i]^127);
        Xor[i]=s[i]^127;
    }
    //printf("Xor result:%s\n",Xor);

    return 0;
}