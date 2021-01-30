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
        printf("\nEmpty queue ");
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
        printf("Empty queue\n");
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
int main()
{
    struct q *ft,*rt;
    ft=rt=NULL;
    while(1)
    {
        printf("\n1.display\n2.enqueue\n3.dequeue\n4.exit\n");int u,dt;
        scanf("%d",&u);
        switch(u)
        {
        case 1:
            dis(ft);
            break;
        case 2:
            printf("\nEnter data\n");
            scanf("%d",&dt);
            enque(&ft,&rt,dt);
            break;
        case 3:
            dt=deque(&ft,&rt);
            printf("\nRetrieved data==%d\t",dt);
            break;
        case 4:
            return 0;
        }
    }
}
