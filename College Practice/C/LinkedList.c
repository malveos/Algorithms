#include<stdio.h>
typedef struct node
{
    int data;
    struct  node *link;
};

void append(struct node **st,int data)
{
    struct node *pnew,*ppre;
    pnew=*st;
    if(*st==NULL)                                                   //adding node at start
    {
        pnew=(struct node*)malloc(sizeof(struct node));
        *st=pnew;
    }
    else
    {
        while(pnew->link!=NULL)                                        //going to end of list
            pnew=pnew->link;

        pnew->link=(struct node*)malloc(sizeof(struct node));
        pnew=pnew->link;
    }
    pnew->data=data;
    pnew->link=NULL;                                            //setting values foe node at end
}
void deletefirst(struct node **st)
{
        struct node *ptemp,*ptes;
        ptemp=ptes=*st;
        if(*st==NULL)
        {
            printf("\nempty\n");
            return;
        }
        else
        {
            ptes=ptes->link;
            *st=ptes;
            free(ptemp);
      }

}
void deletelast(struct node **st)
{
    struct node *tp,*pp;
    tp=*st;
    while(tp->link!=NULL)
        {
            pp=tp;
            tp=tp->link;}
        pp->link=NULL;
        free(tp);
}

void reverse(struct node **st)
{
    struct node *temp,*main,*pre;
    main=*st;
    pre=NULL;
    while(main!=NULL)
    {
        temp=pre;
        pre=main;
        main=main->link;
        pre->link=temp;
    }
    *st=pre;
}



void search(struct node **st,int nm)
{
    struct node *pp,*tp;
    tp=*st;
    while(tp->link!=NULL)
    {
        if(tp->data==nm)
            printf("item found ");
        tp=tp->link;
    }
}

void display(struct node *st)
{
    if(st==NULL)
        printf("\nLINKED LIST IS EMPTY!!\n");
    else
    {
          printf("Elements are::\n");
        while(st!=NULL)
          {printf("%d\t",st->data);
          st=st->link;}
    }
}

int main()
{
    struct node *list;
    list=NULL;

    int s,dt,it;

      while(1)
    {
    printf("\n\n\n1.enter new node\n2.display\n3.exit\n4.delete first node\n5.delete last\n6.search\n7.reverse\n");

    scanf("%d",&s);



    switch(s)
    {
    case 1:
                printf("enter data\n");
                scanf("%d",&dt);
                append(&list,dt);
                break;
    case 2 :
                display(list);
                break;
    case 3:
                return 0;
    case 4:
                deletefirst(&list);
                break;
    case 5:
                deletelast(&list);

                break;
    case 6:
                printf("item to be found");
                scanf("%d",&it);
                search(&list,it);
    case 7:

                reverse(&list);
                break;
    }
    }
}
