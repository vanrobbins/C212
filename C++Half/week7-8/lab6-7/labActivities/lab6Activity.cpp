#include <iostream>
#include <cmath>
using namespace std;
void division(){
    try{
        double num1, num2;
        cout << "Enter first number: ";
        cin >> num1;
        cout << "Enter second number: ";
        cin >> num2;
        if(num2 == 0){//Ensures denominator is not zero
            throw "Division by zero is not allowed";
        }
        double result=num1/num2; //Division operation as denominator is not zero
        cout << "Result: " << result << endl; //prints the result
    }
    catch(const char* msg){
        cout << "Error: " << msg << endl;
        return;
    }   
}
void squareRoot(int num){
    if(num==-1){
        return;
    }
    cout << "Square root of " << num << " is: " << sqrt(num) << endl;
}
int negativeNum(){
    try{
        int num;
        cout << "Enter an integer: ";
        cin >> num;
        if (num < 0){//Ensures integer is not negative
            throw "Negative integers are not allowed in this scenario";
        }
        cout << "You entered: " << num << endl;//Interger is not negative
        return num;
    }
    catch(const char* msg){//Prints error message
        cout << "Error: " << msg << endl;
        return -1;
    }
}
int main(){
    division();
    squareRoot(negativeNum());
    return 0;
}