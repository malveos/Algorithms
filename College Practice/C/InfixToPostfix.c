#include "stack.h"
int priority(char c)
{
    if(c=='^')
        return 3;
     if(c=='*'||c=='/')
        return 2;
         if(c=='+'||c=='-')
        return 1;

        return 0;
}

int oper(char cc)
{
    if(cc=='^'||cc=='*'||cc=='/'||cc=='+'||cc=='-')
        return 1;

        return 0;
}

int main()
{
    char exp[100]={0};
    char temp[10]={0};
    char token;
    struct stack *s;
    char *ptr;
    s=NULL;
    printf("\n\nEnter string==\t");

    while((token=getchar())!='\n')
    {
        if(token=='(')
        {
            ptr=(char*)malloc(sizeof(char));
            *ptr=token;
            push(&s,ptr);
        }
        else if(token==')')
        {
             ptr=(char*)pop(&s);
             while(*ptr!='(')
             {
                 temp[0]=*ptr;
                 strcat(exp,temp);
                 ptr=(char*)pop(&s);

             }
        }
        else if(oper(token))
        {
             ptr=(char*)sttop(&s);

             while(!emptyStack(s)&&priority(token)<=priority(*ptr))
             {
                 ptr=(char*)pop(&s);
                 temp[0]=*ptr;
                 strcat(exp,temp);
                 ptr=(char*)sttop(s);
             }
              ptr=(char*)malloc(sizeof(char));
              *ptr=token;
              push(&s,ptr);
        }
        else
        {
            temp[0]=token;
            strcat(exp,temp);
        }
    }


    while(!emptyStack(s))
    {
        ptr=(char*)pop(&s);
        temp[0]=*ptr;
        strcat(exp,temp);
    }


    printf("\n\nPostfix is\n\t");
    puts(exp);
    getch();
    return 0;
}
