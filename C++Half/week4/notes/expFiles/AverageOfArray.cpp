#include <iostream>


double calculateAverage(int arr[], int size) {
    int sum = 0;
    for (int i = 0; i < size; i++) {
        sum += arr[i];
    }
    return static_cast<double>(sum) / size;
}

int main() {
    
    const int rows = 3;
    const int cols = 4;
    int array[rows][cols] = {
        {10, 20, 30, 40},
        {50, 60, 70, 80},
        {90, 100, 110, 120}
    };

    
    for (int i = 0; i < rows; i++) {
        double avg = calculateAverage(array[i], cols); 
        std::cout << "Average of row " << i + 1 << " is: " << avg << std::endl;
    }

    return 0;
}
