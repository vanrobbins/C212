#include <iostream>
using namespace std;
double average(int a, int b, int c){
    double s=0.0;
    s=a+b+c;
    return s/3;
}
int main(){
    cout<<"Hello World";
    double avg=average(3,4,10);
    cout<<avg;
    return 0;
}