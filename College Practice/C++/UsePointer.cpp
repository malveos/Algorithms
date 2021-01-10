#include<iostream>
using namespace std;
class ptruse
{
	public:
	int id;
	string nm;
	ptruse(int id,string nm)
	{
		this->id=id;
		this->nm=nm;
	}
	void show()
	{
		cout<<"ID:"<<id<<"  Name:"<<nm<<endl;
	}
};
int main()
{
	ptruse *pt;
	pt= new ptruse(78,"Ram");
	cout<<endl<<pt->nm<<endl;
	pt->show();

	string ptruse::*name=&ptruse::nm;
	void (ptruse::*showptr)()=&ptruse::show;

	ptruse ptr(7888,"Sham");
	(ptr.*showptr)();
	cout<<ptr.*name<<endl;
	   
	return 0;
}