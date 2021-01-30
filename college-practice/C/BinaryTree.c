#include<stdio.h>
#include<stdlib.h>
#define M 30
#include<math.h>
typedef struct node
{
	struct node *left;
	int data;
	struct node *right;
}NODE;
typedef struct bt
{
	NODE *rt;
}BT;

//stack creation for non recursive
typedef struct stack
{
    int top;
    NODE *ptr[10];

}STK;

void inits(STK *p)
{
  p->top=-1;
}

void push(STK *s,NODE *a)
{
    s->top++;
    s->ptr[s->top]=a;
}

NODE *pop(STK *s)
{
    NODE *a=s->ptr[s->top--];
    return a;
}

int isempty(STK *s)
{
    return (s->top==-1);
}

//NON-RECURSIVE TRAVERSAL

void nonrec_inorder(BT *p,STK *s)
{
    NODE *a=p->rt;
    inits(s);
    do
    {
        while(a!=NULL)
        {
            push(s,a);
            a=a->left;
        }

        if(!isempty(s))
        {
            a=pop(s);
            printf("%4d",a->data);
            a=a->right;
        }
    }while(a!=NULL||!isempty(s));
}


void nonrec_preorder(BT *p,STK *s)
{
    NODE *a=p->rt;
while(a!=NULL||!isempty(s))
{
    printf("%4d",a->data);
    if(a->right!=NULL)
        push(s,a->right);
    else
        a=a->left;
    if(a==NULL && !isempty(s))
        a=pop(s);
    }
}


void nonrec_postorder(BT *p,STK *s)
{
    NODE *a=p->rt;
while(a!=NULL||!isempty(s))
{
    if(a->right!=NULL)
        push(s,a->right);
    else
        a=a->left;
    if(a==NULL && !isempty(s))
        a=pop(s);
    printf("%4d",a->data);
    }
}


//initialize binary tree
void init(BT *a)
{
	a->rt=NULL;
}

NODE *createnode(int data)
{
	NODE *p=(NODE *)malloc(sizeof(NODE));
	p->data=data;
	p->left=p->right=NULL;
	return p;
}




void preorder(NODE *p)
{
	if(p!=NULL)
	{

		printf("%4d",p->data);
		preorder(p->left);
		preorder(p->right);
	}
}


void inorder(NODE *p)
{
	if(p!=NULL)
	{
		inorder(p->left);
		printf("%4d",p->data);
		inorder(p->right);
	}
}



void postorder(NODE *p)
{
	if(p!=NULL)
	{
		postorder(p->left);
		postorder(p->right);
		printf("%4d",p->data);
	}
}



NODE *calcnode(BT *p , int j)
{
    NODE *a=p->rt,*d;
	if(j>3)
	{
		a=calcnode(p,j/2);
    }
	if(j%2==0)
    {
            if(a->left==NULL)
                a=a;
            else
                a=a->left;
    }
	if(j%2==1)
    {
        if(a->right==NULL)
            a=a;
        else
            a=a->right;
    }
	return a;
}

void createtree(BT *p)
{
	int d[M],i=0,j,k;
	NODE *a=p->rt,*b,*l;
	NODE *c=p->rt;
	while(1)
	{
		printf("\nENTER THE DATA:");
		scanf("%d",&d[i]);
		if(d[i]==0)
			break;
		i++;
	}
	for(j=0;j<i;j++)
	{
		c=p->rt;
		b=createnode(d[j]);
		if(j==0)
		{
			p->rt=b;
			continue;
		}
		else if(j==1)
		{
			c->left=b;
			continue;
		}
        else
            {
                c=calcnode(p,(j+1));
                if((j+1)%2==0)
                    c->left=b;
                else
                    c->right=b;
                }

	}
	printf("TREE CREATED");
}


void checktree(BT *p)
{
    NODE *a=p->rt;
    if(a==NULL)
    {
        printf("THE TREE IS COMPLETE BINARY TREE");
    }
    int i=0,j,z;
    j=countnodes(p->rt);
    j=j+1;
    while(1)
    {
        z=pow(2,i);
        if(z==j)
        {
           printf("THE TREE IS COMPLETE BINARY TREE");
           break;
        }
        else if(z>i)
            printf("THE TREE IS NOT COMPLETE");
        i++;
    }
}


int countnodes(NODE *p)
{
    static int i=0;
	if(p!=NULL)
	{
		countnodes(p->left);
		i++;
		countnodes(p->right);
	}
}


int main()
{
	BT a;
	init(&a);
	int opt,d;
	while(1)
    {
        printf("\nBINARY TREE \nMENU\nOPTION:\n1.Create Tree\n2.Inorder\n3.Preorder\n4.Postorder\n5.Check Tree\n6.Exit");
        scanf("%d",&opt);
        if(opt==6)
            break;
        switch(opt)
        {
        case 1:
            printf("\n\n");
            createtree(&a);
            printf("\n\n");
            break;
        case 2:
            printf("\n\n");
            inorder(a.rt);
            printf("\n\n");
            break;
        case 3:
            printf("\n\n");
            preorder(a.rt);
            printf("\n\n");
            break;
        case 4:
            printf("\n\n");
            postorder(a.rt);
            printf("\n\n");
            break;
        case 5:
            printf("\n\n");
            checktree(&a);
            printf("\n\n");
        }
    }
	return 0;
}
