#include <iostream>
using namespace std;
void swap(int &a, int &b){
    int c=a;
    a=b;
    b=c;
}
int main(){
    int x=5;
    int y=10;
    cout<<"x: "<<x<<endl;
    cout<<"y: "<<y<<endl;
    swap(x,y);
    cout<<"After swap"<<endl;
    cout<<"x: "<<x<<endl;
    cout<<"y: "<<y<<endl;
    
}