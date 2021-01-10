#include<stdio.h>
#include<stdlib.h>
struct stack
{
    int top;
    int data[100];
};
void push(struct stack *st,int data)
{

    st->data[++(st->top)]=data;
    return;
}
void pop(struct stack *st)
{
    return (st->data[st->top--]);
}
int rt(struct stack *st)
{
    int po;
    po=st->data[st->top];
    st->top=st->top--;
    return po;
}
void dis(struct stack *st)
{
    if(st->top==-1)
    {
        printf("\nstack undeerflow\n");
        return;
    }
    else if(st->top==99)
    {
        printf("\n Stack overflow");
        return;
    }
    else
    {
        int i;
        for(i=0;i<=st->top;i++)
            printf("%d\t",st->data[i]);
    }
}
int main()
{
    struct stack s;
    s.top=-1;
    int dt,p;
    while(1)
    {
    printf("\n\n1.display\n2.push\n3.pop\n4.exit\n5.retrive\n\n");
    scanf("%d",&p);
    switch(p)
    {

    case 1:
        dis(&s);
        break;
    case 2:
        printf("\nEnter data to be inserted==\t");
        scanf("%d",&dt);
        push(&s,dt);
        break;
    case 3:
         pop(&s);
         break;
   case 4:
        return 0;
   case 6:
        dt=rt(&s);
        printf("\nRetrieved data is %d",dt);
        break;

    }
}
}
