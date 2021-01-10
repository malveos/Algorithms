#include<iostream>
using namespace std; 

class Overload
{
	public :
	  int n;
	  Overload();
	  Overload(int g);
	  Overload operator+(Overload o);
	  Overload operator-(Overload o);
	  Overload operator*(Overload o);
	  Overload operator/(Overload o);
};
Overload::Overload(){}
Overload::Overload(int g):n(g){}
Overload Overload::operator+(Overload o)
{
	Overload temp;
	temp.n=n+o.n;
	return temp;
}
Overload Overload::operator-(Overload o)
{
	Overload c;
	c.n=n-o.n;
	return c;
}
Overload Overload::operator*(Overload o)
{
	Overload temp;
	temp.n=n*o.n;
	return temp;
}Overload Overload::operator/(Overload o)
{
	Overload temp;
	temp.n=n/o.n;
	return temp;
}

int main()
{
	Overload o1(400);
	Overload o2(200);
	
	Overload o;
	
	o=o1+o2;
	cout<<"Sum:"<<o.n<<endl;
	o=o1-o2;
	cout<<"Substraction:"<<o.n<<endl;
	o=o1*o2;
	cout<<"Multiplication:"<<o.n<<endl;
	o=o1/o2;
	cout<<"Division:"<<o.n<<endl;
	return 0;
}