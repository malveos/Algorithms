#include<iostream>

using namespace std;

class Play
{
	public:
	int cost;
	 void price(int x)
	 {
		 cost=x;
	 }
};

class Online: public Play
{
	public:
	
	void noofPlayers()
	{
		cout<<"Not Specific: with cost:"<<cost<<endl;
	}
};

class Offline: public Play
{
	public :
	void noofPlayers()
	{
		cout<<"Specific: with cost:"<<cost<<endl;
	}
};


int main()
{
	Online ol;
	Offline of;
	Play *p1=&ol;
	Play *p2=&of;
	
	p1->price(87);
	p2->price(657);
	
	ol.noofPlayers();
	of.noofPlayers();
	
	return 0;
}
