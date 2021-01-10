#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
    struct node *link;
};

void add(struct node **st,int mm)
{
    struct node *op,*pp,*mp;
    mp=*st;

    if(*st==NULL)
    {
        pp=(struct node*)malloc(sizeof(struct node));
        pp->link=pp;
        pp->data=mm;
    }
    else
    {
        op=(struct node*)malloc(sizeof(struct node));
        op->data=mm;
        pp=*st;
        op->link=pp->link;
        pp->link=op;
    }
    *st=pp;
}


void delet(struct node **st,int pos)
{
    struct node *op,*pp;
    op=*st;
    int i=1;static int j=1;
    if(j==1)
        op=op->link;
    j++;
    while(i<pos-1)
    {
        i++;
        op=op->link;
    }
    pp=op->link;
    op->link=pp->link;
    *st=pp->link;
    printf("%4d\t",pp->data);
    free(pp);
    return;

}
void dis(struct node *st)
{
    struct node *ty,*o;
    o=st;
    if(st==NULL)
    {
        printf("Empty list");
        return;
    }
    else
        {
            ty=o->link;
            do
            {
                printf("%4d\t",ty->data);
                if(ty==o)
                    break;
                ty=ty->link;

            }while(1);
        }
    }
int main()
{
    struct node *clist;
    clist=NULL;
    printf("Total number::\n");
    int i,k,j;
    scanf("%d",&i);
    for( j=i;j>=1;j--)
    {
        add(&clist,j);
    }
    printf("\nNodes are\n");
    dis(clist);
    printf("\nEnter interval=\t");
    scanf("%d",&k);
    j=1;
    while(j<i)
    {
        delet(&clist,k);
        --i;
    }
    printf("\nNodewill be remain is\n");
    dis(clist);
    printf("\n");

    return 0;
}
