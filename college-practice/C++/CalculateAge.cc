#include<iostream>
using namespace std;

int main()
{
	int a=0;
	int tot=0;
	int ct=0;
	while(a!=-1)
	{
		cout<<"Enter person edge or -1"<<endl;
		cin>>a;
		tot+=a;
		ct++;
	}
	cout<<"Total persons:"<<ct-1<<"	Average:"<<(tot+1)/(ct-1)<<endl;
}