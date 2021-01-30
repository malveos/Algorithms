#include<iostream>
using namespace std;

template <class T>
class Circle
{
		public :
		T rad;
		Circle(T r);
		void cal();
};

template <class T>
Circle<T>::Circle(T r)
{
	rad=r;
}

template <class T>
void Circle<T>::cal()
{
	cout<<"Area:"<<(22/7*rad*rad)<<endl;
}

int main()
{
	Circle<int> c(67);
	c.cal();
	
	Circle<float> c1(7.1);
	c1.cal();
	
}

