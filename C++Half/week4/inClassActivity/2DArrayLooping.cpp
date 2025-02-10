#include <iostream>
#include <random>
using namespace std;

int main(){
    int A[3][4] = {{1,4,2,3},{4,2,6,2},{4,1,0,2}};
    int B[3][4] = {{1,2,2,1},{4,1,2,0},{1,0,0,2}};
    int C[3][4];
    for (int i=0;i<3;i++){
        for(int j=0;j<4;j++){
            C[i][j]=A[i][j]+B[i][j];
        }
    }
    for (int i=0;i<3;i++){
        for (int j=0;j<4;j++){
            cout<<C[i][j]<<" ";
        }
        cout<<endl;
    }
    return 0;
    
}