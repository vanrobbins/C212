#include <iostream>
#include <limits>
#include <cmath>
using namespace std;
//Function to take and validate user input

int inputInt(){
    int userInt;
    cout<<"Enter a positive integer greater than 1: ";
    //Ensures input is a positive integer greater than 1
    while(!(cin>>userInt)||(userInt<=1)){
        cout << "Invalid input.\nEnter a positive integer greater than 1: ";
        //Clears cin error flag
        cin.clear();
        //deletes characters previously entered to cin
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }
    return userInt;
}
//Function to check if a number is prime
int isPrime(int n){
    int nSqrt = sqrt(n);
    int divisorCount=0;
    //Counts divisors up to the square root of the number
    for(int i=2;i<=nSqrt;i++){
        if(n%i==0){
            divisorCount++;
        }
    }
    //Returns divisor count based on divisorCount properties
    //If prime, returns 0 (no divisors other than 1 and itself)
    if (divisorCount==0)
        //Is prime
        return divisorCount;

    //If not prime, calculates and returns total divisors
    //If not perfect square has 2 factors for every divisor found
    else if(nSqrt*nSqrt!=n){
        return divisorCount*2;
    }
    //If perfect square has 2 factors for every divisor found minus 1
    else{
        return (divisorCount*2)-1;
    }
    
}

//Function to print the divisors of a number
void printDivisors(int n, int arrayNums[],int endA){
    cout<<"Divisors of "<<n<<" are: ";
    for(int i=0; i<=endA;i++){
        //Formats output to display divisors separated by commas
        if (i!=endA)
            cout<<arrayNums[i]<<", ";
        else
            cout<<arrayNums[i]<<endl;
    }
}
//Function to find and store divisors in an array

void findDivisors(int n, int numDivisors){
    int startIdx=0;
    int endIdx=numDivisors-1;
    int divisors[numDivisors];

    //Iterates up to the square root of the number
    for(int i=2; i<=(sqrt(n));i++){
        //find pairs of divisors until at central divisors
        if((n%i==0)&&(startIdx<=endIdx)){
            //Adds small divisors to start of array
            divisors[startIdx++]={i};
            //Adds large divisors to end of array
            divisors[endIdx--]={(n/i)};
        }
    }
    //sends divisors to print function;
    printDivisors(n, divisors,(numDivisors-1));
}


int main(){
    int userNum;
    int numFactors;
    string again;
    cout<<"Check for Prime Number\n";
    //Prompts user for input and checks if the number is prime
    userNum=inputInt();
    numFactors=isPrime(userNum);

    //If not prime, finds and prints its divisors
    if (numFactors>0){
        cout<<userNum<<" is not a prime number\n";
        //Finds and prints divisors
        findDivisors(userNum,numFactors);
    }
    //prime
    else
        cout<<userNum<<" is a prime number\n";

    //Loop to allow user to check another number
    cout<<"Would you like to find if another number is prime? Y/N ";
    cin>>again;
    if (again=="y" || again=="Y")
        //Recursively calls main() if the user wants to continue
        main();
    else
        return 0;

}