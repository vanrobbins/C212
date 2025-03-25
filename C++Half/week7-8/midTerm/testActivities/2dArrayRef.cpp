#include <iostream>
using namespace std;

int main(){
    int arr[]={2,4,6};
    int *p=arr;
    for(int i=0;i<3;i++){
        (*p)++;
        cout<<*p<<" ";
        p++;
    }
    cout<<endl;
    cout<<arr[0]<<" "<<arr[1]<<" "<<arr[2]<<endl;
    return 0;
}