#include <iostream>
using namespace std;
int sum(int a=5, int b=7){
    return a+b;
}
int main(){
cout<< sum(8)<<endl;
cout<< sum()<<endl;
}