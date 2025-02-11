#include <iostream>
using namespace std;

int main(){
    //array
    int a[8]={15,20,12,25,13,8,10,16};
    
    //find max min of array and their indexes
    int maxIdx=0;
    int minIdx=0;
    for(int i=0; i<(sizeof(a)/sizeof(a[0])); i++){
        if(a[i]>a[maxIdx]){
            maxIdx=i;
        }
        if(a[i]<a[minIdx]){
            minIdx=i;
        }
        else{
            continue;
        }
    }
    cout<<"The maximum #'s index is "<<maxIdx<<" it's value is "<<a[maxIdx]<<endl;
    cout<<"The minimum #'s index is "<<minIdx<<" it's value is "<<a[minIdx]<<endl;
//find specific value in array 
    int key=13;
    int keyFound=-1;
    for(int i=0; i<(sizeof(a)/sizeof(a[0])); i++){
        if(a[i]==key){
            keyFound=i;
            break;
        }
    }
    if(keyFound>=0){
        cout<<"Key "<<key<<" found at index "<<keyFound<<endl;
    }
    else{
        cout<<"Key not found";
    }

    for(int i=(sizeof(a)/sizeof(a[0]))-1; i>-1; i--){
        cout<<a[i]<<" ";
    }
    cout<<endl;
//nested loop
    for(int i=0; i<5; i++){
        for(int j=i; j<4; j++){
            cout<<"x";
        }
        cout<<endl;
    }
    
    for(int i=0; i<5; i++){
        for(int j=i; j>0; j--){
            cout<<"x";
        }
        cout<<endl;
    }
}