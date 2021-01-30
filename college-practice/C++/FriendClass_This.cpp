#include<iostream>
#include<cmath>
using namespace std;

class Potato
{
	public:
		int root;
		
		Potato(int m);
		friend void square(Potato p);
};
Potato::Potato(int m):root(m)
{
	cout<<"Entered no is"<<this->root<<"  "<<(*this).root<<endl;
}

void square(Potato p)
{
	cout<<"Square:"<<p.root*p.root<<" SquareRoot:"<<sqrt(p.root)<<endl;
}

int main()
{
	Potato pp(64);
	square(pp);
	return 0;
}