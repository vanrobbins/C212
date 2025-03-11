#include <iostream>
using namespace std;

// Function to divide two integers with error handling for division by zero
double divide(int a, int b) {
    if (b == 0) {
        throw "Division by zero"; // Throw error if denominator is zero
    }
    return ((double)a / (double)b);
}

// Function to search an array at a given index with error handling for out-of-bounds index
int searchArray(int a[], int selectionIndex, int size) {
    if (selectionIndex < 0 || selectionIndex >= size) {
        throw "Index out of bounds"; // Throw error if index is out of bounds
    }
    return a[selectionIndex];
}

// Function to convert a string to a float with error handling for invalid input
float convert(string a) {
    try{
        stof(a); // Attempt to convert string to float
    }
    catch(invalid_argument){
        throw "Input not numerical"; // Throw error if input is not numerical
    }
    return stof(a);
}