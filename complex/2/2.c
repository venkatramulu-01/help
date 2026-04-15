#include<stdio.h>
#include<ctype.h>
#include<stdlib.h>
int main(){
    char ch,str[20];
    FILE*fp=fopen("input.c","r");
    if(!fp) return 1;
    while((ch=fgetc(fp))!=EOF){
        if(isalpha(ch)){
            int i=0;
            str[i++]=ch;
            while(isalnum(ch=fgetc(fp))) str[i++]=ch;
            str[i]='\0';
            fseek(fp,-1,SEEK_CUR);
            printf("identifier:%s\n",str);
        }
        else if(isdigit(ch)){
            int i=0;
            str[i++]=ch;
            while(isdigit(ch=fgetc(fp))||ch=='.'){
                str[i++]=ch;
            }
            str[i]='\0';
            fseek(fp,-1,SEEK_CUR);
            printf("constant:%s\n",str);
        }
        else if(ch=='/'&&(ch=fgetc(fp))=='/'){
            printf("comment://");
            while((ch=fgetc(fp))!='\n'&&ch!=EOF) putchar(ch);
            printf("\n");
        }
        else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='='){
            printf("operator:%c\n",ch);
        }
    }
    fclose(fp);
    return 0;
}