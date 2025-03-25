#include <iostream>
#include "exceptionHandlingFunctions.h"
using namespace std;

int main(){
    string input;
    
    // Division
    cout << "Divide two integers:\nEnter an integer: ";
    try{
        cin >> input;
        int num1 = (int)convert(input); // Convert input to integer
        cout << "Enter another integer: ";
        cin >> input;
        int num2 = (int)convert(input); // Convert input to integer
        double result = divide(num1, num2); // Perform division
        cout << "Result: " << result << endl;
    }
    catch(const char* msg){
        cout << "Error: " << msg << endl; // Handle division error
    }
    
    // Search Array
    int arr[5] = {10, 9, 8, 7, 6};
    cout << "Search Array:\nEnter an index 1-5: ";
    try{
        cin >> input;
        int index = ((int)convert(input)) - 1; // Convert input to index
        int result = searchArray(arr, index, 5); // Search array
        cout << "Result: " << result << endl;
    }
    catch(const char* msg){
        cout << "Error: " << msg << endl; // Handle array search error
    }
    
    // Verify float conversion
    cout << "Convert string to float:\nEnter a float: ";
    try{
        cin >> input;
        float result = convert(input); // Convert input to float
        cout << "Result: " << result << endl;
    }
    catch(const char* msg){
        cout << "Error: " << msg << endl; // Handle conversion error
        return -1;
    }
    
    return 0;
}