#include<iostream>
using namespace std;

template<class T>
class Identify
{
		public :
		T x;
		Identify(T x)
		{
			cout<<"It is not char: "<<x<<endl;
		}
};

template<>
class Identify<char>
{
	public :
		char x;
		Identify(char x)
		{
			cout<<"It is indeed a char: "<<x<<endl;
		}
};

int main()
{
	Identify<int>(899);
	Identify<char>('g');
}