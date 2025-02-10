#include <iostream>
#include <fstream>
#include <sstream>
#include <cmath>
#include <string>
using namespace std;

// Function to count the number of students in the file
int numStudents(string filename){
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

// Function to find the top 4 scores from a comma-separated string of scores
void findTopScores(string studentScores, int *topScores){
    string singleScore;
    int amtScores;
    int smallestScore;
    int evalScore;
    bool moreFourScores= true;
    
    // While there are more than four scores
    while(moreFourScores){
        amtScores=0;
        smallestScore=100;
        stringstream allScores(studentScores);
        // Search scores
        while(getline(allScores,singleScore,',')){
            evalScore=stoi(singleScore);
            if(evalScore<smallestScore){
                smallestScore=evalScore;
            }
            amtScores++;
        }
        // If there are exactly four scores, store them in topScores
        if (amtScores==4){
            stringstream finalScores(studentScores);
            for(int j=0;j<4;j++){
                getline(finalScores,singleScore,',');
                topScores[j]=stoi(singleScore);
            }
            moreFourScores= false;
        }
        // If there are more than four scores, remove the smallest score and repeat
        else{
            stringstream allScores2(studentScores);
            stringstream newScores;
            bool removed = false;  // Track if we have removed one Score
            
            while (getline(allScores2, singleScore, ',')) {
                if (stoi(singleScore) == smallestScore && !removed) {
                    removed = true;  // Remove only one instance
                    continue;
                }
                if (!newScores.str().empty()) {
                    newScores << ",";
                }
                newScores << singleScore;
            }

            studentScores = newScores.str();  // Update the input string for next iteration
        }
    }
}

// Function to get scores from the file and store the top 4 scores for each student
void getScores(string fileName, int *scores[4],int numStudent){
    string studentScores;
    ifstream fileScores(fileName);
    int finalStudentScores[4];
    for(int i=0;i<numStudent;i++){
        getline(fileScores, studentScores);
        findTopScores(studentScores,finalStudentScores);
        for(int j=0;j<4;j++){
            scores[i][j]=finalStudentScores[j];
        }
    }
    fileScores.close();
}

// Function to calculate and print the average scores of students
double getNPrintAvg(int *scores[4], double stuAvg[], int numStu){
    double sum=0.0,avg,totalAvg;
    for (int i=0; i<numStu; i++){
        sum=0.0;
        for(int j=0;j<4;j++){
            sum+=scores[i][j];
        }
        avg=sum/4.0;
        stuAvg[i]=avg;
        totalAvg+=avg;
        cout<<"Student "<<(i+1)<<" Average: "<<avg<<endl;

    }
    return (totalAvg/numStu);
}

// Function to print the distribution of student scores
void printStudentDistribution(double avgScores[],int numStudents){
    int stuDistro[5]={0,0,0,0,0};
    for(int i=0;i<numStudents;i++){
        if (avgScores[i]>90){
            stuDistro[4]+=1;
        }
        else if(avgScores[i]>80){
            stuDistro[3]+=1;
        }
        else if(avgScores[i]>70){
            stuDistro[2]+=1;
        }
        else if(avgScores[i]>60){
            stuDistro[1]+=1;
        }
        else {
            stuDistro[0]+=1;
        }
    }
    
    cout<<"\nScore Distribution:\n";
    cout<<"0-59: "<<stuDistro[0]<<" students\n";
    cout<<"60-69: "<<stuDistro[1]<<" students\n";
    cout<<"70-79: "<<stuDistro[2]<<" students\n";
    cout<<"80-89: "<<stuDistro[3]<<" students\n";
    cout<<"90-100: "<<stuDistro[4]<<" students\n\n";
}

// Function to calculate the standard deviation of scores
double standardDeviation(int flatSortScores[], double avg, int numStu,int numScore){
    double variance=0.0,strdDev;
    for(int i=0;i<numScore;i++){
        variance+=pow((flatSortScores[i]-avg),2);
    }
    variance/=numScore;
    strdDev=sqrt(variance);
    return strdDev;
}

// Function to sort the scores array
void sortArray(int *stuScores[4],int flatScores[],int numStu,int totalNumScores){
    bool sorted=false;
    int compare1,compare2,median;
    int k=0;
    // Flatten the 2D array into a 1D array
    for(int i=0;i<numStu;i++){
        for(int j=0;j<4;j++){
            flatScores[k]=stuScores[i][j];
            k++;
        }
    }
    // Sort the flattened array using bubble sort
    while(!sorted){
        for(int i=0;i<totalNumScores;i++){
            compare1=flatScores[i];
            compare2=flatScores[i+1];
            if(compare1>compare2){
                flatScores[i+1]=compare1;
                flatScores[i]=compare2;
                break;
            }
            k=i;
        }
        if(k==totalNumScores-1){
            sorted=true;
        }
    }
}

// Function to count the number of unique scores
int amtUniqueNum(int sortedArray[],int totalScores){
    int amount=0,num;
    // Iterate through the sorted array to count unique numbers
    for(int i=0;i<totalScores;i++){
        if (num==sortedArray[i]){
            continue;
        }
        else{
            amount++;
            num=sortedArray[i];
        }
    }
    return amount;
}

// Function to get unique scores and their frequencies
void getUniqueNum(int sortedArray[],int *uniqueScores[2],int totalScores){
    int counter=0,num,k=0;
    // Iterate through the sorted array to find unique numbers and their frequencies
    for(int i=0;i<totalScores;i++){
        counter=0;
        if (num==sortedArray[i]){
            continue;
        }
        else{
            num=sortedArray[i];
            // Count the frequency of the current unique number
            for(int j=i;j<totalScores;j++){
                if(sortedArray[j]==num){
                    counter++;
                }
                else
                    break;
            }
            uniqueScores[k][0]=num; // Store the unique number
            uniqueScores[k][1]=counter; // Store the frequency of the unique number
            k++;
        }
    }
}

// Function to find the frequency and largest occurrence of number
void findAmtFrequencyMode(int *uniqueScores[2],int amtUniqueScores,int amtFrequencyMode[]){
    int amtOccurences=0,largestOccurence=0;
    // Find the largest occurrence of any number
    for(int i=0;i<amtUniqueScores;i++){
        if(uniqueScores[i][1]>largestOccurence)
            largestOccurence=uniqueScores[i][1];
    }
    // Count how many numbers have the largest occurrence
    for(int j=0;j<amtUniqueScores;j++){
        if(uniqueScores[j][1]==largestOccurence)
            amtOccurences++;
    }
    amtFrequencyMode[0]=amtOccurences; // Store the number of modes
    amtFrequencyMode[1]=largestOccurence; // Store the largest occurrence
}

// Function to find the mode of scores
void findMode(int *uniqueScores[2],int amtUniqueScores, int amtMode,int modeOccurence,int mode[]){
    int modesFound=0;
    // Iterate through the unique scores to find the mode(s)
    for(int i=0;i<amtUniqueScores;i++){
        if(uniqueScores[i][1]==modeOccurence){
            if (modesFound<amtMode){
                mode[modesFound]=uniqueScores[i][0]; // Store the mode
                modesFound++;
            }
            else{
                cerr<<"Error too many occurrences of mode"<<endl;
                return;
            }
            
        }
    }
}

// Function to find the median of scores
double findMedian(int sortedArray[],int totalScores){
    double median;
    // Calculate the median of the sorted array
    median=(sortedArray[(totalScores/2)-1]+sortedArray[totalScores/2])/2.0;
    return median;
}

int main(){
    string file="score.txt";
    int numberStudents=numStudents(file); // Get the number of students from the file
    int totalScores=numberStudents*4; // Calculate the total number of scores
    int *scores[numberStudents]; // Array to store scores of each student
    int flatSortScores[numberStudents*4]; // Array to store all scores in a flat structure
    int modeFrequency[2]; // Array to store mode frequency information
    double studentAvgs[numberStudents]; // Array to store average scores of students
    for(int i=0;i<numberStudents;i++){
        scores[i]=new int[4]; // Allocate memory for each student's scores
    }
    
    getScores(file,scores,numberStudents); // Get scores from the file
    // Print student average and get total average
    double totalAvg= getNPrintAvg(scores,studentAvgs,numberStudents);

    // Standard deviation and median
    sortArray(scores,flatSortScores,numberStudents,totalScores); // Sort the scores
    double strdDeviation=standardDeviation(flatSortScores,totalAvg,numberStudents,totalScores); // Calculate standard deviation
    double median=findMedian(flatSortScores,totalScores); // Calculate median

    // Mode
    int uniqueNum=amtUniqueNum(flatSortScores, totalScores); // Get the number of unique scores
    int *uniqueScores[uniqueNum]; // Array to store unique scores and their frequencies
    for(int i=0;i<uniqueNum;i++){
        uniqueScores[i]=new int[2]; // Allocate memory for unique scores
    }
    getUniqueNum(flatSortScores,uniqueScores,totalScores); // Get unique scores and their frequencies
    findAmtFrequencyMode(uniqueScores,uniqueNum,modeFrequency); // Find the frequency and largest occurrence of number
    int amountMode= modeFrequency[0]; // Get the number of modes
    int occurMode=modeFrequency[1]; // Get the frequency of the mode
    int mode[amountMode]; // Array to store the mode(s)
    findMode(uniqueScores,uniqueNum,amountMode,occurMode,mode); // Find the mode(s)
    // Print results
    printStudentDistribution(studentAvgs,numberStudents); // Print the distribution of student scores
    cout<<"Overall Average: "<<totalAvg<<endl<<"Standard Deviation: "<<strdDeviation<<endl<<"Median: "<<median<<endl<<"Mode: ";
    char comma=',';
    if(amountMode>1){
        for (int i=0;i<amountMode;i++){
            if(i!=amountMode-1){
                cout<<mode[i]<<comma<<' ';
            }
            else
                cout<<mode[i]<<endl;
        }
    }
    else{
        cout<<mode[0];
    }
}