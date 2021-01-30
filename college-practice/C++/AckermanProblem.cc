#include<iostream>

using namespace std;
int ack(int,int);

int main()
{
	int x,y;
	cout<<"Enter nos"<<endl;
	cin>>x>>y;
	cout<<"printing ackerman:"<<ack(x,y)<<endl;
	return 0;
}

int ack(int x,int y)
{
	if(x==0)
		return y+1;
	else if(y==0)
		return ack(x-1,1);
	else
	{
		cout<<x<<" "<<y<<endl;
		return ack(x-1,ack(x,y-1));
	}
}