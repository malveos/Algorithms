#include<iostream>
using namespace  std;

class Ravan
{
	public:
		const int v;
		int w;
		Ravan(int v,int w);
		void print();
		void printC() const;
};

void Ravan::print()
{
	cout<<"Value:"<<v<<endl;
}

void Ravan::printC() const
{
	cout<<"value: "<<w<<endl;
}
Ravan::Ravan (int v,int w): v(10),w(20)
{
	
}

int main()
{
	Ravan g(100,15);
	g.print();
	g.printC();
	const Ravan x(15 ,89);
	//x.print();     here can't access the non-constant var v  
	x.printC();
	
	return 0;
}