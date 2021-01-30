#include<stdio.h>
#include<stdlib.h>
struct stack
{
    int top;
    struct node *link;
}ST;
void push(struct stack **st,int n)
{
    struct stack *pp,*op;
    pp=*st;
    op=(struct stack*)malloc(sizeof(struct stack));
    op->link=*st;
    op->top=n;
    *st=op;

}
int pop(struct stack **st)
{
    struct stack *pp,*pl;
    pp=*st;
    int ppl;

    ppl=pp->top;
    pl=*st;
    *st=pl->link;
    free(pl);
    return ppl;
}
int main()
{
    unsigned int nm;
    struct stack *s;
    int dt;
    s=NULL;
    printf("\nEnter decimal\n\t");
    scanf("%d",&nm);
    while(nm>0)
    {
        //dt=(int *)malloc(sizeof(int));
        dt=nm%2;
        push(&s,dt);
        nm=nm/2;
    }
    while(s!=NULL)
    {
        dt=pop(&s);
        printf("%d",dt);
    }
    return 0;
}
