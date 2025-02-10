#include <iostream>
using namespace std;

int main(){
    for(int i = 100; i <= 150; i+=2){
        cout<<i<<" ";
    }
    cout<< endl;

    int j=100;
    while(j<=150){
        if (j%2==0)
            cout<<j<<" ";
        j++;
    }
    cout<< endl;

    int k=100;
    do
    {
        cout<<k<<" ";
        k+=2;
    } while (k<=150);
    
}