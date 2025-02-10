#include <iostream>
#include <limits>
#include <cmath>
using namespace std;
void taskOne(){
    int userInt;
    cout<<"Enter Integer: ";
    while(!(cin>>userInt)){
        cin.clear();
        //deletes characters previously entered to cin
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        //remind user coefficent entering
        cout<<"Invalid input\n"<<"Enter Integer:";
    }
    //positive,negative,zero verification
    if (userInt>0)
        cout<< userInt<< " is positive\n";
    else if(userInt<0)
        cout<< userInt<<" is negative\n";
    else
        cout<<"Integer is 0";
    //even odd verification
    if(userInt%2==0)
        cout<< userInt<< " is even\n";
    else
        cout<< userInt<< " is odd\n";
}

double calculateSquare(double num){
    return pow(num,2);
}
double calculateSquareRoot(double num){
    return sqrt(num);
}
void taskTwo(){
    double userDouble;
    cout<<"Enter Double: ";
    while(!(cin>>userDouble)){
        cin.clear();
        //deletes characters previously entered to cin
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        //remind user coefficent entering
        cout<<"Invalid input\n"<<"Enter Double:";
    }
    if (userDouble>=0){
        cout<<"Square: "<<calculateSquare(userDouble)<<endl;
        cout<<"Square root: "<<calculateSquareRoot(userDouble)<<endl;
    }
    else{
        cout<<"Square: "<<calculateSquare(userDouble)<<endl;
        cout<<"Square root: Cannot calculate square root of negative number\n";
    }
}

bool isDivisibleByD(int num,int divisor){
    if (num%divisor==0)
        return true;
    else
        return false; 
}
void printDivisibleNumbers(int n[], int divBy){
    cout<<n<<" ";
}
void taskThree(){
    /*
        int userInt=-1;
    while(userInt!=0){
        cout<<"Enter Positive Number (0 to exit): ";
        while(!(cin>>userInt)&&userInt<0){
            cin.clear();
            //deletes characters previously entered to cin
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            //remind user coefficent entering
            cout<<"Invalid input\n"<<"Enter Positive Number (0 to exit):";
        }
        cout<<"Numbers divisible by 2:";
        for (int i=2; i<=userInt; i+=1){
            if(isDivisibleBy2(i))
                printDivisibleNumbers(i);
        }

         cout<<"\nNumbers divisible by 3:";
        for (int j=1; j<=userInt; j++){
            if(isDivisibleBy3(j))
                printDivisibleNumbers(j);
        }
        cout<<endl;
    }
    */
}
int main(){
    taskOne();
    taskTwo();
    taskThree();
    return 0;
}