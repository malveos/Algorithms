#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
    struct node *link;
};
void push(struct node **st,int dat)
{
    struct node *p,*u;
    p=*st;
    u=(struct node *)malloc(sizeof(struct node));
    u->data=dat;
    u->link=*st;
    *st=u;
}
void pop(struct node **st)
{
    struct node *i=*st;
     if(i==NULL)
    {
     printf("\nEMPTY STACK\n");
     return;
    }
    else
    {i=*st;
    *st=i->link;
    free(i);
    return;
    }
}
int top(struct node **st)
{
    struct node *t;
    int tu;
    t=*st;
    tu=t->data;
    return tu;
}
void dis(struct node *st)
{
    if(st==NULL)
        printf("\nEMPTY STACK\n");
    else
    {
        while(st!=NULL)
        {
            printf("%d\t",st->data);
            st=st->link;
        }
    }

}
int main()
{

    struct node *st;
    st=NULL;
    int op,dt;
    while(1)
    {
        printf("\n1.push\n2.pop\n3.display\n4.stack top node\n5.exit\n");
        scanf("%d",&op);
        switch(op)
        {
        case 1:
            printf("\nEnter data for pushing:\n");
            scanf("%d",&dt);
            push(&st,dt);
            break;
        case 2:
            dt=top(&st);
            pop(&st);
            printf("\npoped data is :\t%d \n",dt);
            break;
        case 3:
            dis(st);
            break;
        case 4:
            dt=top(&st);
            printf("\n data at top  is :\t%d \n",dt);
            break;
        case 5:
            return 0;
        }
    }

}
