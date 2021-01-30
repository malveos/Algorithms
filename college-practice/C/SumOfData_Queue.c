#include"stack.h"
int main()
{
    struct q *s;
    s=NULL;
    printf("\nEnter total==\n");
    int d,f,c=0,dt,i;
    int sum=0;
    scanf("%d",&d);
    for( i=0;i<d;i++)
    {
        printf("\n Enter data==\t");scanf("%d",&f);
        push(&s,f);
    }
    for(i=0;i<d;i++)
    {
        dt=pop(&s);
        sum+=dt;
        c++;
    }
    float av=sum/c;

    printf("\n\nsum=%d\t average=%f\n",sum,av);

    return 0;

}
