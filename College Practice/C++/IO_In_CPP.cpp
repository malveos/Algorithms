#include<iostream>
#include<iomanip>
#include<cstdio>
#include<streambuf>
#include<fstream>
#include<cstring>
using namespace std;

int main()
{

    char ch[10],f;
    cout<<"using input manipulators"<<endl;
    cin>>ch;
    cout<<ch<<endl;

    ch=gets(char);
    cout<<ch<<endl;

    f=(char)getc(stdin);
    cout<<f<<endl;

    cin.getline(ch,5);
    cout<<ch<<endl;

   read((char*)&ch,sizeof(ch));
    cout<<ch<<endl;

    return 0;
}
