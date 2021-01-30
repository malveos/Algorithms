#include<iostream>
using namespace std;

template <class A,class B>
B area(A h,B x,B y)
{
	B xx=(0.5*(x+y)*h);
	return xx;
}

int main()
{
	cout<<"Enter height and two parallel sides of trapezium:"<<endl;
	int h;
	float x,y;
	cin>>h>>x>>y;
	
	cout<<"Area:"<<area(h,x,y)<<endl;
	
}