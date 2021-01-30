#include<iostream>
using namespace std;
class comp1
{
	private:
	friend void cal(class comp1,class comp2);
	public:
	int r1,i1;
	void get()
	{
		cout<<"enter real and imag part of first complex";
		cin>>r1>>i1;
	}
	
	
};
class comp2
{
	private:
	friend void cal(class comp1,class comp2);
	public:
	int r2,i2;
	void enter()
	{
		cout<<"enter real and imaginary parts of second number ";
		cin>>r2>>i2;
	}
};
void cal(comp1 a,comp2 b)
{
	float a1,a2,m;
	char ch;
	cout<<"enter operator";
	cin>>ch;
	if(ch=='+')
		{
		a1=a.r1+b.r2;
		a2=a.i1+b.i2;
		cout<<a1<<"+i"<<"("<<a2<<")"<<endl;
		}
	else if(ch=='-')
		{
		a1=a.r1-b.r2;
		a2=a.i1-b.i2;
		cout<<a1<<"+i"<<"("<<a2<<")"<<endl;
		}
	else if(ch=='*')
		{
		a1=(a.r1*b.r2)-(a.i1*b.i2);
		a2=(a.i1*b.r2)+(a.r1*b.i2);
		cout<<a1<<"+i"<<"("<<a2<<")"<<endl;
		}
	else if(ch=='/')
		{
		m=((b.i2*b.i2)+(b.r2*b.r2));
		a1=((a.r1*b.r2)+(a.i1*b.i2))/m*1.0;
		a2=((a.r1*b.i2)-(b.r2*a.i1))/m*1.0;
		cout<<a1<<"+i"<<"("<<a2<<")"<<endl;
		}
	else
		cout<<"try again   !!!!!";
};
int main()
{
	comp1 x1;
	comp2 x2;
	x1.get();
	//x1.print();
	x2.enter();
	//x2.out();
	cal(x1,x2);
	return 0;
}
