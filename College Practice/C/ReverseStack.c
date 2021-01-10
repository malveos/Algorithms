#include"stack.h"
void dis(struct stack *st)
{
    if(st==NULL)
    {
        printf("\nempty\n");
        return;
    }
    else
    {
        while(st!=NULL)
        {
            printf("%d\t",st->top);
            st=st->link;
        }
    }
}
int main()
{

    int i=0,j,k;
    struct stack *s1,*s2;
    s1=s2=NULL;
    printf("Enter no of elements==\t");
    scanf("%d",&j);
    for(i=0;i<j;i++)
    {
        printf("Enter data");scanf("%d",&k);
        push(&s1,k);

    }
    dis(s1);

   printf("\nNew stack==\n");
    for(i=0;i<j;i++)
    {
            k=pop(&s1);
            push(&s2,k);
    }
    dis(s2);
    return 0;
}
