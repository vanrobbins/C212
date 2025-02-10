#include <iostream>
#include <fstream>
using namespace std;
int readNumGrades(string filename){
    int lines=0;
    string line;
    ifstream fileGrades(filename);
    if (!(fileGrades.is_open())){
        cerr<<"Error Opening File:"<<filename<<endl;
    }
    while(getline(fileGrades, line)){
        lines++;
    }
    return lines;
}
void readGrades(string filename, int grades[]){
    int lines=0;
    string line;
    ifstream fileGrades(filename);
    if (!(fileGrades.is_open())){
        cerr<<"Error Opening File:"<<filename<<endl;
    }
    while(getline(fileGrades, line)){
        grades[lines]=stoi(line);
        lines++;
    }
}
double calculateAverage(int grades[],int size){
    double sum=0.0;
    for(int i=0; i<size;i++){
        sum+=grades[i];
    }
    return sum/size;
}
int findHighest(int grades[],int size){
    int highestGrade=0;
    for(int i=0; i<size;i++){
        if (grades[i]>highestGrade){
            highestGrade=grades[i];
        }
        else
            continue;
    }
    return highestGrade;
}
int findLowest(int grades[],int size){
    int lowestGrade=100;
    for(int i=0; i<size;i++){
        if (grades[i]<lowestGrade){
            lowestGrade=grades[i];
        }
        else
            continue;
    }
    return lowestGrade;
}
int findAboveAvg(int grades[],double avg,int size){
    int aboveAvg=0;
    for(int i=0; i<size;i++){
        if (grades[i]>avg){
            aboveAvg++;
        }
        else
            continue;
    }
    return aboveAvg;
}
void printResults(int numRead, double avg, int highest, int lowest, int numAboveAvg ){
    cout<<"Number of grades read: "<<numRead<<"\nAverage grade: "<<avg<<"\nHighest grade: "<<highest<<"\nLowest grade: "<<lowest<<"\nStudents above average: "<<numAboveAvg;

}
int main(){
    string file="grades.txt";
    int gradesRead=readNumGrades(file);
    int grades[gradesRead];
    readGrades(file, grades);
    double average=calculateAverage(grades, gradesRead);
    int highestGrade=findHighest(grades, gradesRead);
    int lowestGrade=findLowest(grades, gradesRead);
    int aboveAvg=findAboveAvg(grades, average, gradesRead);
    printResults(gradesRead,average,highestGrade,lowestGrade,aboveAvg);
}