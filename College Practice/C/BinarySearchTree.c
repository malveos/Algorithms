#include<stdio.h>
#include<stdlib.h>


typedef struct node
{
        struct node *left;
        struct node *right;
        int data;

}NODE;

typedef struct tree
{
    NODE *rt;
}BST;

void init(BST *p)
{
    p->rt=NULL;

}

NODE* creatnode(int d)
{
    NODE *p=(NODE *)malloc(sizeof(NODE));
    p->data=d;
    p->left=p->right=NULL;
    return p;
}

void creatBST(BST *p)
{
    int e;
    NODE *a,*b,*c;
    a=p->rt;
    while(1)
    {
        a=p->rt;
        c=a;
        printf("\nEnter data to continue To stop press 0\n\nEnter data:\t");
        scanf("%d",&e);
        if(e==0)
        {
            break;
        }
        b=creatnode(e);
        if(p->rt==NULL)
        {
            p->rt=b;
            continue;
        }
        while(a!=NULL)
        {
            if(b->data<a->data)
            {
                c=a;
                a=a->left;
            }
            else{

                c=a;
                a=a->right;
            }
        }
        if(b->data<c->data)
        {
            c->left=b;
        }
        else
        {
            c->right=b;
        }
    }

}


void inorder(NODE *p)
{
    if(p!=NULL)
    {
        inorder(p->left);
        printf("\t%d",p->data);
        inorder(p->right);
    }
}

int main()
{
    BST p;
    init(&p);
    creatBST(&p);
    inorder(p.rt);

    return 0;
}
