#include<iostream>
using namespace std;

class GrandFather					//access modifiers: all derived use public and protected
{									//private is only in that class
	
	public:
		int publicv=9890;		//constructor for derived should pass argv if parent has contructor with argument
		int gf;
		GrandFather(int ss)
		{										//constructor destructor works as sandwitch i.e.dest=child to parent
			gf=ss;																			//   cons= parent to child		
			cout<<"I am grandfather , Age:"<<gf<<endl;
		}
		int privatev=5677;
		~GrandFather();
	private:
		
	protected:
		int protectedv=7756;
		
		
};
GrandFather::~GrandFather()
{
	cout<<"GrandFather is destructing!!"<<endl;
}
class Father: public GrandFather
{
	public:
	int f;
	~Father();
	Father(int ss): GrandFather(ss)
	{
		f=ss;
		cout<<"I am father,Age:"<<f<<endl;
	}
	protected:
	
};
Father::~Father()
{
	cout<<"Father is destructing!!!"<<endl;
}
class Son: public Father
{
	
	public :
		int s;
		Son(int sa);
		~Son();
		void printAll();
};
Son::~Son()
{
	cout<<"Son is destructing!!!"<<endl;
}
Son :: Son(int sa): Father(sa),s(sa)
{
	cout<<"I am son, Age:"<<s<<endl;	
}
void Son::printAll()
{
	cout<<"GrandFather:"<<gf<<"\n Father:"<<f<<"\nSon:"<<s;
	cout<<"\n\n public:"<<publicv<<"\nprivate:"<<privatev<<"\nprotected:"<<protectedv<<endl;
}

int main()
{
	GrandFather g(80);
	cout<<"---------------------------------------"<<endl;
	Father f(40);
	cout<<"---------------------------------------"<<endl;
	Son s(20);
	cout<<"---------------------------------------"<<endl;
	s.printAll();
	return 0;
}