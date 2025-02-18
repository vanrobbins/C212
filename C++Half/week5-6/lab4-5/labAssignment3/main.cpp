#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include "math_functions.h"
using namespace std;

// Function to process a line of data and output the result to a file
void outputFunction(vector<int>& singleLine, string outputFile) {
    ofstream results(outputFile, ios::app);
    // Check the first element to determine which calculation to perform
    // Remove the first element after checking
    if (singleLine.front() == 1) {
        singleLine.erase(singleLine.begin());
        results << "Arithmetic Mean: " << arithmeticMean(singleLine) << endl;
    }
    else if (singleLine.front() == 2) {
        singleLine.erase(singleLine.begin());
        results << "Geometric Mean: " << geometricMean(singleLine) << endl;
    }
    else if (singleLine.front() == 3) {
        singleLine.erase(singleLine.begin());
        results << "Harmonic Mean: " << harmonicMean(singleLine) << endl;
    }
    else if (singleLine.front() == 4) {
        singleLine.erase(singleLine.begin());
        results << "Standard Deviation: " << standardDeviation(singleLine) << endl;
    }
    else if (singleLine.front() == 5) {
        singleLine.erase(singleLine.begin());
        results << "Median: " << median(singleLine) << endl;
    }
    else if (singleLine.front() == 6) {
        singleLine.erase(singleLine.begin());
        results << "Mode: " << mode(singleLine) << endl;
    }
    else if (singleLine.front() == 7) {
        singleLine.erase(singleLine.begin());
        results << "Variance: " << variance(singleLine) << endl;
    }
    else if (singleLine.front() == 8) {
        singleLine.erase(singleLine.begin());
        results << "Maximum Number: " << maximumNumber(singleLine) << endl;
    }
    else if (singleLine.front() == 9) {
        singleLine.erase(singleLine.begin());
        results << "Minimum Number: " << minimumNumber(singleLine) << endl;
    } else {
        results << "Invalid Input" << endl;
    }
}

// Main function to read data from a file, process it, and sent to output function
int main() {
    string fileIn = "data.txt"; // Input file name
    string fileOut = "results.txt"; // Output file name
    string line;
    string value;
    int num;
    vector<int> lineData;
    ifstream data(fileIn);
    
    ofstream results(fileOut);//Open and close file to clear the content
    results.close(); // Clear the output file before writing new results

    // Read each line from the input file
    while (getline(data, line)) {
        stringstream ssData(line);
        // Split the line by commas and convert to integers
        while (getline(ssData, value, ',')) {
            num = stoi(value);
            lineData.push_back(num);
        }
        // Process the line data and write the result to the output file
        outputFunction(lineData, fileOut);
        lineData.clear(); // Clear the vector for the next line of data
    }
    data.close();
}