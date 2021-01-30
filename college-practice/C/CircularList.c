#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
    struct node *link;
};
void add(struct node **st,int nm)
{
    struct node *first=*st,*pnew,*last;

    if(*st==NULL)
    {
        pnew=(struct node*)malloc(sizeof(struct node));

        *st=pnew;
        pnew->data=nm;
        pnew->link=pnew;
        first=pnew;

    }
    else
    {
        pnew=(struct node*)malloc(sizeof(struct node));
        pnew->data=nm;
        pnew->link=first->link;
        first->link=pnew ;
        first=first->link;

    }

}
void dis(struct node *st)
{
    struct node *tp,*first=st;
    if(st==NULL)
    {
        printf("\nEMPTY LIST!!!!\n");
        return;
    }
    printf("%d\t",first->data);
    first=first->link;
    while(first!=st)
    {
        printf("%d\t",first->data);
        first=first->link;
    }
}
void del(struct node **st,int mmmm)
{
    struct node *pp,*ss,*ww,*m,*a,*b,*c;
    pp=m=b=*st;
    if(*st==NULL)
    {
        printf("Empty list!!!");
        return;
    }
    if(pp->link==pp)
    {
        if(pp->data==mmmm)
        {*st=NULL;
        free(pp);}
        return;
    }

    do
    {

        if(pp->data==mmmm)
        {
            if(pp==*st)
            {
             do
            {       a=*st;
                    c=b;
                    b=b->link;
                    if(a==b)
                    break;
            }while(1);
            c->link=pp->link;
            *st=pp->link;
            free(pp);
            pp=*st;
        }
    else
         {
             ss->link=pp->link;
             free(pp);
            pp=ss->link;
         }
        }
        ww=*st;
        ss=pp;
        pp=pp->link;
        if(ww==pp&&ss!=*st)
            return;
    }while(1);
}
int main()
{
    struct node *clist;
    clist=NULL;
    int i,dt;
    while(1)
    {
    printf("\n1.display\n2.add or create\n3.exit\n4.delete\n");
    scanf("%d",&i);
    switch(i)
    {
    case 1:
        dis(clist);
        break;
    case 2:
        printf("\nEnter data\n");
        scanf("%d",&dt);
        add(&clist ,  dt);
        break;
    case 3:
        return 0;
    case 4:
        printf("\nEnter data to de deleted");
        scanf("%d",&dt);
        del(&clist,dt);
        break;
    }
    }


}
