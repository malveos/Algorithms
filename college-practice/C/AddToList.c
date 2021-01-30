#include<stdio.h>
#include<stdlib.h>
#include "linked.h"
/*struct node
{
    int data;
    struct node *link;
};*/

int rm(struct node **st)
{
    struct node *pp;int dt;
    pp=*st;
    dt=0;
    if(*st==NULL)
    {
        printf("Empty list");
        return dt;
    }
    else
    {

        dt=pp->data;
        *st=pp->link;

        free(pp);
    }
    return dt;
};
int main()
{
    struct node *l1,*l2;
    l1=l2=NULL;int i=1,pp,t,o;
    printf("\nAdd 5 elements to 1st\n");
    for( i=1;i<=5;i++)
    {
        printf("Enter element");
        scanf("%d",&t);
        append(&l1,t);
    }
    display(l1);
    printf("\nAdd 5 ele to 2nd\n");
    for(i=1;i<=5;i++)
    {
        printf("Enter element");
        scanf("%d",&o);
        append(&l2,o);
    }
    display(l2);
    i=1;
    while(i<=5)
    {
        i++;
        pp=rm(&l2);
       // printf("%d",pp);
        append(&l1,pp);
    }
    printf("\nNew list==\n");
    display(l1);
    return 0;
}
