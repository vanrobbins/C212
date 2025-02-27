
#include <iostream>
#include <sstream>
#include <fstream>
#include "calculator.h"
using namespace std;

int main(){
    string fileInput="input.txt"; // Input file containing calculations
    string fileOutput="output.txt"; // Output file to store results
    ifstream fileIn(fileInput); // Open input file for reading
    ofstream fileOut(fileOutput); // Open output file for writing
    string singleCalculation; // String to store a single calculation line
    string operation; // String to store the operation
    string singleNum; // String to store a single number
    int num[2]; // Array to store the two numbers for the calculation

    // Read each line from the input file
    while(getline(fileIn, singleCalculation)){
        stringstream singleCalc(singleCalculation); // Create a stringstream for the line
        getline(singleCalc, operation, ' '); // Extract the operation
        // Extract the two numbers
        for(int j=0;j<2;j++){
            getline(singleCalc,singleNum, ' ');
            num[j]=stoi(singleNum);
        }
        // Perform the calculation based on the operation
        if (operation=="+"){
            int result=add(num[0],num[1]);
            fileOut<<num[0]<<" "<<operation<<" "<<num[1]<<" = "<<result<<endl;
        }
        else if(operation=="-"){
            int result=subtract(num[0],num[1]);
            fileOut<<num[0]<<" "<<operation<<" "<<num[1]<<" = "<<result<<endl;
        }
        else if(operation=="*"){
            int result=multiply(num[0],num[1]);
            fileOut<<num[0]<<" "<<operation<<" "<<num[1]<<" = "<<result<<endl;
        }
        else if(operation=="/"){
            if (num[1]==0 || num[1]==0.0){
                cerr<<"Cannot divide by zero"<<endl;
                fileOut<<"Cannot divide by zero"<<endl;
                continue;
            }
            double result=divide(num[0],num[1]);
            fileOut<<num[0]<<" "<<operation<<" "<<num[1]<<" = "<<result<<endl;
        }
        else{
            cerr<<"Invalid operation"<<endl;
            continue;
        }
    }
    fileIn.close(); // Close the input file
    fileOut.close(); // Close the output file
}