#include <iostream>
#include <random>
using namespace std;

int main(){
    //Get Random number Between 50 and 100
    default_random_engine engine{random_device{}()};
    uniform_int_distribution<int> randomInt{50, 100};
    const int score{randomInt(engine)};

    cout<<"You got "<<score<<" it is a ";
    if (score>=90){
        cout<<"A";
    }
    else if (score>=80){
        cout<<"B";
    }
    else if (score>=70){
        cout<<"C";
    }
    else if (score>=60){
        cout<<"D";
    }   
    else{
        cout<<"F";
    }
    return 0;
}