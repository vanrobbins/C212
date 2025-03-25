#include <iostream>
#include <fstream>
#include <sstream>
#include "array_ops.h"
using namespace std;
int numSets(string filename){
    int lines=0;
    string line;
    ifstream fileScores(filename);
    if (!(fileScores.is_open())){
        cerr<<"Error Opening File:"<<filename<<endl;
        return -1;
    }
    while(getline(fileScores, line)){
        lines++;
    }
    return lines;
}
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
void flattenArray(int** arr, int arrSize[], int flatArr[], int amtSets){
    int k=0;
    for(int i=0; i<amtSets; i++){
        for(int j=0; j<arrSize[i]; j++){
            flatArr[k++]=arr[i][j];
        }
    }
}
void outputResults(string filename, double avg, int max, int min, int arr[], int size){
    ofstream fileResults(filename);
    fileResults<<"Average: "<<avg<<endl;
    fileResults<<"Max: "<<max<<endl;
    fileResults<<"Min: "<<min<<endl;
    fileResults<<"Sorted Array: ";
    for(int i=0; i<size; i++){
        if (i%10==0){
            fileResults<<endl;
        }
        if(i!=size-1){  
            fileResults<<arr[i]<<" ";
        }
        else{
            fileResults<<arr[i];
        }
    }
}
int main(){
    string file="numbers.txt";
    string resultfile="results.txt";
    int totalNum=0;
    int amtSets=numSets(file);
    int** arr=new int*[amtSets];
    int arrSize[amtSets];
    createArray(file,arr,arrSize);
    
    for(int i=0; i<amtSets; i++){
        totalNum+=arrSize[i];
    }
    int flatArr[totalNum];
    flattenArray(arr,arrSize,flatArr,amtSets);
    sortArray(flatArr,totalNum);
    outputResults("results.txt",findAverage(flatArr,totalNum),findMax(flatArr,totalNum),findMin(flatArr,totalNum),flatArr,totalNum);
    //Deallocate memory
    for (int i = 0; i < amtSets; i++) {
        delete[] arr[i];
    }
    delete[] arr;
    cout<<"Results have been written to results.txt"<<endl;
    return 0;
}