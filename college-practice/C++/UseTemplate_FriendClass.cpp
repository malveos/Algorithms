#include<iostream>
using namespace std;

template <class T>
class Myclass
{
	T value;
	public:
	void setvalue(T v)
	{
		value=v;
	}
	T getvalue(){return value;}
	template <class U>
	friend void print(Myclass<U>&);
};
template <class U>
void print(Myclass<U>& c)
{
	cout<<c.getvalue();
}
int main()
{
	Myclass<string> obj;
	obj.setvalue("Karansing");
	print(obj);
	return 0;
}

