#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
    struct node *prev;
    struct node *next;
};
void add(struct node **st,int nm)
{
    struct node *pp,*pnew;
    pp=pnew=*st;
    if(*st==NULL)
    {
        pnew=(struct node*)malloc(sizeof(struct node));
        pnew->prev=NULL;
        *st=pnew;
        pnew->data=nm;
        pnew->next=NULL;
    }
    else
    {
        while(pp->next!=NULL)
            pp=pp->next;
        pnew=(struct node*)malloc(sizeof(struct node));
        pnew->next=NULL;
        pp->next=pnew;
        pnew->data=nm;
        pnew->prev=pp;
    }
}
void deletef(struct node **st)
{
    struct node *tp,*pp;
    tp=*st;
    if(tp==NULL)
    {
        printf("empty list!!!");
        return;
    }
    else
    {
        tp=tp->next;
        tp->prev=NULL;
        *st=tp;
    }
}
void deletel(struct node **st)
{
    struct node *tp=*st,*po;
    if(tp==NULL)
    {
        printf("EMPTY LIST\n");
        return ;
    }
    else if(tp->prev==NULL||tp->next==NULL)
    {
        *st=NULL;
        free(tp);
    }
    else
    {
        while(tp->next!=NULL)
        {
            po=tp;
            tp=tp->next;
        }
        po->next=NULL;
        free(tp);
    }
}
void search(struct node **st,int mm)
{
    struct node *tp;
    tp=*st;int c=0;
    while(tp!=NULL)
    {
        if(tp->data==mm)
           c++;
        tp=tp->next;
    }
    if(c==0)
        printf("Item not found\n");
    else
         printf("Item found\t%d times\n",c);
}
void reverse(struct node **st)
{
    struct node *pre,*main,*temp;
    main=temp=*st;
    while(main!=NULL)
    {
        pre=main;
        main=main->next;
    }

    *st=pre;

}
void dis(struct node *st)
{
    printf("\n");
    if(st==NULL)
    {
        printf("EMPTY LIST!!!!!!");
        return;
    }
    else
    {
        while(st!=NULL)
        {
            printf("\t%d\t",st->data);
            st=st->next;
        }
    }
}

int main()
{
    struct node *dlist;
    dlist=NULL;
    int ip,dt,dm;
    while(1)
    {
        printf("\n1.create or add\n2.deletef\n3.deletel\n4.search\n5.reverse\n6.display\n7.exit\n");
        scanf("%d",&ip);
        switch(ip)
        {
        case 1:
            printf("\nenter data\n");
            scanf("%d",&dt);
            add(&dlist,dt);
            break;
        case 2:
            deletef(&dlist);
            break;
        case 3:
            deletel(&dlist);
            break;
        case 4:
            printf("\nenter item to bee found\n");
            scanf("%d",&dm);
            search(&dlist,dm);
            break;
        case 5:
            reverse(&dlist);
            break;
        case  6:
            dis(dlist);
            break;
        case 7:
            return 0;
        }
    }
}


