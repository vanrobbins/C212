#include <iostream>
using namespace std;

int main(){
    int a = 10;
    int *p = &a;
    cout << "Value of &a: " << &a << endl;
    cout << "Value of p: " << p << endl;
    cout << "Value of a: " << a << endl;
    cout << "Value of *p: " << *p << endl;
    cout << "Value of &p: " << &p << endl;

    int arr[5] = {1, 2, 3, 4, 5};
    int *q = arr;//point to first element of array
    int *r = &arr[0];
    cout <<"Value of *q: " << *q << endl;//First element of array
    cout <<"Value of r: " << *r << endl;//First element of array
    cout <<"Value of *(q+1): " << *(q+1)<<endl;//Second element of array
    cout <<"Value of *q+1: " << *q+1<<endl;//First element of array + 1
    cout <<"Value of q: "<< q << endl;//Address of first element of array

    int arr2[2][3] = {{1, 2, 3}, {4, 5, 6}};
    int (*s)[3] = arr2;
    cout << "Value of *(*(s+1)+2): " << *(*(s+1)+2) << endl;//Third element of second row
    cout << "Value of **s: " << **s << endl;//First element of First row
    cout << "Value of *(*(s+1)): " << *(*(s+1)) << endl;//First element of Second row
    cout << "Value of *s: " << *s << endl;//Address of first row
    cout << "Value of s: " << s << endl;//Address of first row
    cout<< "All values of 2D array: " << endl;
    for(int i=0; i<2; i++){
        for(int j=0; j<3; j++){
            cout << *(*(s+i)+j) << " ";
        }
        cout << endl;
    }
    
}