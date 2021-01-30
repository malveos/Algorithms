#include<stdio.h>
#include<stdlib.h>
#include"linked.h"
int main()
{
    struct node *l1,*l2,*l3;
    l1=l2=l3=NULL;
    int i,t,o,p1,p2,ppp;
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
      i=1;int e=10;
       p1=rm(&l1);
        p2=rm(&l2);
      // printf("%dhere",display(l3));
    while(1)
    {
        if(p1>p2)
            {append(&l3,p2);
              p2=rm(&l2);e--;
            }
        else if(p2>p1)
            {append(&l3,p1);
            p1=rm(&l1);e--;
            }
            else if(display(l1)!=0)

            {
                while(display(l1)==0)
                {
                    p1=rm(&l1);
                    append(&l3,p1);
                }
            }
            else if(display(l2)!=0)

            {
                while(display(l2)==0)
                {
                    p2=rm(&l2);
                    append(&l3,p2);
                }
            }
            else
            {
                break;
            }
            if(display(l2)==0&&display(l1)==0)
                break;

        /* if(e==4)
         {
             while(i<5)
             {p1=rm(&l1);
            append(&l3,p1);i++;}
            break;
         }
         else if(i==4)
         {
             while(e<5)
             {p2=rm(&l2);
            append(&l3,p2);e++;}
            break;
         }
         else{continue;}*/

    }
    printf("\nMerged  list==\n");
    display(l3);


    return 0;
}
