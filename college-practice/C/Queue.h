#include<stdio.h>
#include<stdlib.h>
struct q
{
    int data;
    struct node *link;
};
void enque(struct q **ft,struct q **rt,int mm)
{
    struct q *pn,*ii;
    pn=(struct q *)malloc(sizeof(struct q) );
    if(!pn)
    {
        return;
    }
    else
    {
        pn->data=mm;
        pn->link=NULL;
        if(*ft==NULL)
            *ft=pn;
        else
        {
            ii=*rt;
            ii->link=pn;
        }
        *rt=pn;
    }

}
int deque(struct q **ft,struct q **rt)
{
    struct q *pp;int io;
    if(*ft==NULL)
    {
        printf("\nEmpty ");
        return 0;
    }
    else
    {
        pp=*ft;
        io=pp->data;
        *ft=pp->link;
        free(pp);
        return io;
    }
}
void dis(struct q *st)
{
    if(st==NULL)
    {
        printf("Empty list\n");
        return;
    }
    else
    {
        while(st!=NULL)
        {
            printf("%d\t",st->data);
            st=st->link;
        }
    }
}
