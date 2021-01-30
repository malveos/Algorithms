#include<iostream>
#include<string>
using namespace std;

class Americano
{
	public:
	int girl;
	int boy;
	
	Americano(int g,int b);
	void add();
};
Americano::Americano(int g,int b)
{
	girl=g;
	boy=b;
}
void Americano::add()
{
	cout<<"Boys:"<<boy<<" Girls:"<<girl<<" Total:"<<boy+girl<<endl;
}

class Person
{
	public :
	string name;
	Americano x;
	
	Person(string str,Americano a);
	void print();
};

Person::Person(string str,Americano a): name(str),x(a)
{
}
void Person::print()
{
	cout<<"Country "<<name<<" has ";x.add();
}

int main()
{
	Americano am(123,89);
	Person p("US",am);
	p.print();
	return 0;
}