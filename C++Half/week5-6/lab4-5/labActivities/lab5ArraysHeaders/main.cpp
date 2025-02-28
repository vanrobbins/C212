#include <iostream>
#include <fstream>
#include <sstream>
#include "array_ops.h"
using namespace std;

// Function to count the number of sets in the file
int numSets(string filename){
    int lines=0;
    string line;
    ifstream fileScores(filename);
    while(getline(fileScores, line)){
        lines++;
    }
    return lines;
}

// Function to create a 2D array from the file
void createArray(string filename, int** arr, int arrSize[]){
    string line;
    string sinNum;
    int amtNum=0;
    int i=0;
    ifstream fileScores(filename);
    while(getline(fileScores, line)){
        amtNum=0;
        stringstream ss(line);
        while(getline(ss, sinNum, ',')){
            amtNum++;
        }
        arrSize[i]=amtNum;
        arr[i]=new int[amtNum];
        ss.clear();
        ss.str(line);
        int j=0;
        while(getline(ss, sinNum, ',')){
            arr[i][j++]=stoi(sinNum);
        }
        i++;
    }
    fileScores.close();
}

// Function to convert an array to a string representation
string printArray(int arr[], int size){
    string str="[";
    for(int i=1; i<size; i++){
        str+=to_string(arr[i]);
        if(i<size-1){
            str+=", ";
        }
    }
    str+="]";
    return str;
}

// Function to output the results to a file
void outputResults(string filename,int** arr, int arrSize[], int sets){
    ofstream fileResults(filename);
    for(int i=0; i<sets; i++){
        if (arr[i][0]==1){
            fileResults<<"Average of "<<printArray(arr[i],arrSize[i])<<": "<<findAverage(arr[i],arrSize[i])<<endl;
        }
        else if(arr[i][0]==2){
            fileResults<<"Max of "<<printArray(arr[i],arrSize[i])<<": "<<findMax(arr[i],arrSize[i])<<endl;
        }
        else if(arr[i][0]==3){
            fileResults<<"Min of "<<printArray(arr[i],arrSize[i])<<": "<<findMin(arr[i],arrSize[i])<<endl;
        }
        else if(arr[i][0]==4){
            fileResults<<"Sort Array "<<printArray(arr[i],arrSize[i])<<": ";
            sortArray(arr[i],arrSize[i]);
            fileResults<<printArray(arr[i],arrSize[i])<<endl;
        }
        else{
            fileResults<<"Invalid operation"<<endl;
        }
    }
    fileResults.close();
}

int main(){
    // Define file names
    string file="numbers.txt";
    string resultfile="results.txt";
    
    // Get the number of sets in the file
    int amtSets=numSets(file);
    
    // Create a 2D array to store the numbers
    int** arr=new int*[amtSets];
    int arrSize[amtSets];
    createArray(file,arr,arrSize);
    
    // Calculate the total number of elements
    
    
    // Output the results
    outputResults(resultfile,arr,arrSize,amtSets);
    
    // Deallocate memory
    for (int i = 0; i < amtSets; i++) {
        delete[] arr[i];
    }
    delete[] arr;
    
    cout<<"Results have been written to results.txt"<<endl;
    return 0;
}