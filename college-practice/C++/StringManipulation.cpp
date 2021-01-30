#include<iostream>
#include<string>
using namespace std;

int main()
{
	string a("maggi  ");
	string b,c;
	b=c;
	c.assign(a);
	
	cout<<"Copying::   "<<a<<b<<c<<endl;
	cout<<"------------------------------"<<endl;
	
	cout<<"maggi at(2)  "<<a.at(2)<<endl;
	cout<<"length:     "<<a.length()<<endl;
	cout<<"------------------------------"<<endl;
	
	string ss=" That is not the case bro";
	cout<<"Original String:  "<<ss<<endl;
	cout<<"substring substr(3,4)   "<<ss.substr(3,4)<<endl;
	
	ss.swap(c);
	cout<<"swap with maggi     "<<ss<<endl;
	cout<<"find _am_ in (i am a badam ham)    "<<ss.find("g")<<endl;
	cout<<"reverese finding same   "<<ss.rfind("g")<<endl;
	cout<<"------------------------------"<<endl;
	
	string st="Within the all boys all are not bad this is not case";
	cout<<"Original String:  "<<st<<endl;
	st.erase(25);
	cout<<"erase (4,2)     "<<st<<endl;
	cout<<"replace  (4,3,\"Kutya\")   "<<st.replace(4,3,"Kutya")<<endl;
	cout<<"insert   (6,\"dukra\")     "<<st.insert(6,"dukra")<<endl;
	cout<<"------------------------------"<<endl;
}