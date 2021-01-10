#include<iostream>
using namespace std;

template <class T>
add(T x,T y)
{
	cout<<"Addition:"<<(x+y)<<endl;
}

template <class T>
sub(T x,T y)
{
	cout<<"Substraction:"<<(x-y)<<endl;
}

template <class T>
mul(T x,T y)
{
	cout<<"Multiplication:"<<(x*y)<<endl;
}

template <class T>
div(T x,T y)
{
	cout<<"Division:"<<(x/y)<<endl;
}

int main()
{
	float x,y,z;
	char ch;
	cout<<"Enter two nos:(Ctrl+c for end)"<<endl;
	
	while(cin>>x>>y)
	{
		cout<<"Enter operator:"<<endl;
		cin>>ch;
		switch(ch)
		{
			case '+':add(x,y);
					break;
			case '-':sub(x,y);
					break;
			case '*':mul(x,y);
					break;
			case '/':div(x,y);
					break;
			default:
					cout<<"Enter good operator!!!"<<endl;
		}
		
		cout<<"Enter two nos:(Ctrl+c for end)"<<endl;
	}
	return 0;
}