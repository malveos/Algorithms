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
# define TRUE 1
# define FALSE 0

int emptyStack (struct stack* pST)
{
	if (pST==NULL)
	       return TRUE;
	else
	       return FALSE;
}

int sttop(struct stack *st)
{
    if(st==NULL)
        return 0;
    else
    {
        return (st->top);
    }
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
