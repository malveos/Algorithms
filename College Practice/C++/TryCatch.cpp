#include<iostream>
using namespace std;

int main()
{
	cout<<"Enter two nos:(Ctrl+c for stop)"<<endl;
	float x,y;
	try
	{
		while(cin>>x>>y)
		{
			if(y==0)
				throw 'f';
			cout<<"DIvision:"<<(x/y)<<"\n"<<endl;
			cout<<"Enter two nos:(Ctrl+c for stop)"<<endl;
		}
	}
	catch(...)
	{
		cout<<"Are you carzy dividing by 0"<<endl;
	}
	
}