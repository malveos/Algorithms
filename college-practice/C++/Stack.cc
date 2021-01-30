#include "stackincpp.h"
#include<iostream>
using namespace std;

class st
{								//class delaration in .h 
	char arr[10];				//defintaion in .cpp
	char top;					//include in using file
	int cur;

	public :
		st(int sz);
		~st();
		int size();
		void push(char x);
		char pop();
		void dis();

};
void st::dis()
{
	if(arr[0]==0)
	{
		cout<<"Empty"<<endl;
	}
	int i=0;
	while(arr[i]!=0)
	{
		cout<<arr[i]<<endl;
		i++;
	}
}

st::st(int sz)
{
	cout<<"size cant put::"<<endl;
	int i=0;
	while(arr[i]!=0)
	{
		arr[i]=0;
		i++;
	}
	cur=0;
}
st::~st()
{
	cout<<"Destructor"<<endl;
}
int st::size()
{
	return cur;
}


void st::push(char x)
{
	if(cur==12)
	{
		cout<<"full";
		return;
	}
	arr[cur]=x;
	cur++;
}
char st::pop()
{
	if(arr[0]==0)
	{
		cout<<"Empty"<<endl;
	}
	char t=arr[cur];
	arr[cur]=0;
	cur--;
	return t;
}

int main()
{
	st obj(12);
	obj.dis();
	obj.push('e');
	obj.push('r');
	obj.push('v');
	
	cout<<"poped:"<<obj.pop()<<endl;
	
	obj.push('f');
	obj.push('k');
	obj.dis();
	
	return 0;
}