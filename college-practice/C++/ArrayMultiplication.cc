#include<iostream>

using namespace std;

void multi(int [3][3],int [3][3]);

int main()
{
	
	int a1[3][3],a2[3][3];
	
	for(int i=0;i<3;i++)
		for(int j=0;j<3;j++)
		cin>>a1[i][j]>>a2[i][j];
	
	for(int i=0;i<3;i++)
	{for(int j=0;j<3;j++)
		cout<<a1[i][j]<<" ";
	
		cout<<endl;
	}
	for(int i=0;i<3;i++)
	{for(int j=0;j<3;j++)
		cout<<a2[i][j]<<" ";
	
		cout<<endl;
	}
	
	
	multi(a1,a2);
	
	return 0;
}
   
void  multi(int a1[3][3],int a2[3][3])
{
	int n=3;
	int a[n][n];
	
		for(int i=0;i<3;i++)
	{for(int j=0;j<3;j++)
		a[i][j]=0;
	}
	for(int i=0;i<3;i++)
	{for(int j=0;j<3;j++)
		cout<<a1[i][j]<<" ";
	
		cout<<endl;
	}
	for(int i=0;i<3;i++)
	{for(int j=0;j<3;j++)
		cout<<a2[i][j]<<" ";
	
		cout<<endl;
	}
	

	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
			for(int k=0;k<n;k++)
				a[i][j]=a[i][j]+a1[i][k]*a2[k][j];
	
	for(int i=0;i<n;i++)
	{for(int j=0;j<n;j++)
		cout<<a[i][j]<<" ";
		cout<<endl;
	}
}