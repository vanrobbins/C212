#include <iostream>
using namespace std;

int main(){
    int s[100]={};
    for (int i=0; i<(sizeof(s)/sizeof(s[0])); i++){
        s[i]=i+1;
    }
    int sum=0;
    for(int i=0;i<(sizeof(s)/sizeof(s[0])); i++){
        sum+=s[i];
    }
    int avg= sum/(sizeof(s)/sizeof(s[0]));
    cout<<"Sum is: "<<sum<<"\nAvg is: "<<avg;
}