#include<bits/stdc++.h>
using namespace std;
#define MAXN 100

int N,K;
int arr[MAXN];

inline int sum(vector<int> v){
    int sum = 0;
    for(int i = 0; i< v.size() ; ++i ){
        sum += v[i];
    }
    return sum;
}
void subsetSum(int index,vector<int> v)
{

    int sumTill = sum(v);
    if(sumTill> K)
        return;
    if(sumTill == K){
        for(int i = 0 ;i<v.size(); ++i){
            cout<<v[i]<<" ";
        }
        cout<<  endl;
        return;
    }
    if(index == N)
        return;
    subsetSum(index + 1 , v);
    v.push_back(arr[index]);
    subsetSum(index + 1 , v);
}
int main()
{
    cin>>N>>K;
    for(int i = 0 ; i < N ; ++i )
        cin>>arr[i];
    cout<<"Solutions:"<<endl;
    vector<int> v;
    subsetSum(0,v);
    return 0;
}
