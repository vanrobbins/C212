#include <iostream>
#include <limits> //required to find limit and empty cin
#include <complex> //required to solve with complex numbers
using namespace std;

// Function that has user input value, checks validity of input--will repeat until a valid value is inputed
double userInputCoefficent(string coefficentName, bool notZero){
    double userDouble;
    cout<< coefficentName <<": ";
    // has user input value until valid-- while the entered value is not a double, or if value cannot be 0 and is 0: retry
    while(!(cin>>userDouble) || ((notZero==true) ? userDouble==0 : false)){
        //entered value is not a double
        if(!cin)
            cout << "Invalid input.\nPlease retry entering a valid number:\n";
        //entered value is 0 and cannot be
        else
            cout<< "Invalid input. "<<coefficentName <<" cannot be 0.\nPlease retry entering a valid number:\n";
        //clears cin error flag
        cin.clear();
        //deletes characters previously entered to cin
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        //remind user coefficent entering
        cout<< coefficentName <<": ";
    }
    return userDouble;
}

//function finds discriminant given a,b,c
double findDiscriminant(double a,double b,double c){
    double discriminant = pow(b,2)-(4*a*c); //b^2-4ac
    return discriminant;
}

//function finds roots of quadratic given a,b,c
void findRoots(double a,double b,double c){
    double discriminant=findDiscriminant(a,b,c);//determines if 1 or 2 solutions by finding discriminant
    cout.precision(3); //rounds cout root values to 3 places exp. 0.333 or 3.33

    //discriminant is equal to 0--one solution
    if (discriminant==0){
        if (b==0){
            cout<<"The root of the equation is: "<<b<<endl;
        }
        else{
            double root=(-b/(2*a));
            cout<<"The root of the equation is: "<<root<<endl;
        }
    }
    //two solutions
    else{
        //uses complex numbers to solve remainder of quadratics-- positiveRoot= +sqrt, negativeRoot= -sqrt
       complex<double>positiveRoot=(-b+sqrt(complex<double>(discriminant)))/(2*a);
       complex<double>negativeRoot=(-b-sqrt(complex<double>(discriminant)))/(2*a);
       //if the solution does not have imaginary number as part of root output the two solutions
       if (positiveRoot.imag()==0){
        cout<<"The roots of the equation are: "<<positiveRoot.real()<<" and "<<negativeRoot.real()<<endl;
       }
       //solution contains imaginary number output both solutions with imaginarys
       else if(positiveRoot.real()==0){
            cout<<"The roots of the equation are: "<<positiveRoot.imag()<<"i and - "<<positiveRoot.imag()<<"i\n";
       }
       else{
            cout<<"The roots of the equation are: "<<positiveRoot.real()<<" + "<<positiveRoot.imag()<<"i and "<<positiveRoot.real()<<" - "<<positiveRoot.imag()<<"i\n";
       }
    }
}

int main(){
    double valueA, valueB, valueC;
    string again;
    cout<<"Enter the coefficents of a quadratic equation a, b, and c:\n";
    //has user input valid a,b,c values-- a cannot be 0 while b and c can
    valueA= userInputCoefficent("a",true);
    valueB= userInputCoefficent("b",false);
    valueC= userInputCoefficent("c",false);
    //function finds roots and outputs them 
    findRoots(valueA,valueB,valueC);

    //Try again 
    cout<<"Would you like to find the roots of another quadratic?\nY/N ";
    cin>>again;
    if (again=="y" || again=="Y")
        main();
    else
        return 0;
}

