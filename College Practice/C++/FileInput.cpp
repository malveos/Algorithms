#include<iostream>
#include<fstream>
#include<string>
using namespace std;

int main()
{
	ofstream fp;
	fp.open("file.txt");
	string str="omkar";
	
	cout<<"Enter id name year marks"<<endl;
	int id,yr;
	string nm; 
	float mk;
	while(cin>>id>>nm>>yr>>mk)
	{
			fp<<id<<" "<<nm<<" "<<yr<<" "<<mk<<endl;
			cout<<"Enter id name year marks"<<endl;
	}
	
	fp.close();
	
	return 0;
}