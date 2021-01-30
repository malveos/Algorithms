#include<iostream>
using namespace std;

class Guns												
{
	public :						// pure virtual is =0 child should override iter_swap(Abstract class)
									//simple virtual is if no declaration parent func exec
	virtual void shoot()=0;
	//{
		//cout<<"It is simple gun no extra features"<<endl;
	//}
};

class Pistol: public Guns
{
	public:
	int reload;
	Pistol(int x)
	{
		reload=x;	
	}
	void shoot()
	{
		cout<<"Pistol:       Capacity:"<<reload<<"\n\tHandy"<<endl;
	}
	
};

class Rifle: public Guns
{
	public:
	int reload;
	Rifle(int x)
	{
		reload=x;
	}
	void shoot()
	{
		cout<<"Rifle:       Capacity:"<<reload<<"\n\tNusta rada!!!!!!!!!"<<endl;
	}
};

class SMG : public Guns
{
	public:
	int reload;
	SMG(int x)
	{
		reload=x;
	}
	void shoot()
	{
		cout<<"SMG:         Capacity:"<<reload<<"\n\tOne bullet the end"<<endl;
	}
};

int main()
{
	Pistol p(7);
	Rifle r(320);
	SMG s(80);
	
	Guns *g1=&p;				//creating guns
	Guns *g2=&r;
	Guns *g3=&s;
	
	g1->shoot();
	g2->shoot();
	g3->shoot();				//reloading guns
	
	
	return 0;
}