#include<iostream>
#include<cmath>
using namespace std;

void simple(double p,float n,float r);
void compound(double p,float n,float r);
int main()
{
	double p;
	float n,r;
	cout<<"Enter p n r:"<<endl;
	cin>>p>>n>>r;
	cout<<"enter interest type:(simple=s/compound=c)"<<endl;
	char c;
	cin>>c;
	
	if(c=='s')
		simple(p,n,r);
	else
		compound(p,n,r);
	
	return 0;
}

void simple(double p,float n,float r)
{
	double i=p*n*r/100.0;
	cout<<"Simple Interest:"<<i<<endl;
}
void compound(double p,float n,float r)
{
	double i=p*(pow((1+r/100),n));
	cout<<"Compound Interest:"<<i<<endl;
}
