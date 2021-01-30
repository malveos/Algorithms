#include<iostream>
#include<fstream>
using namespace std;

int main()
{
	ifstream fp("file.txt");
	int id,year;
	float mk;
	string name;
	while(fp>>id>>name>>year>>mk)
	{
		cout<<"ID:"<<id<<"  Name:"<<name<<"  Year:"<<year<<"  Marks:"<<mk<<endl;
	}
	return 0;
}