#include <iostream>
#include <algorithm> // Required for std::sort

int main() {
    // Define an array of integers
    int arr[] = {5, 2, 9, 1, 5, 6};
    int n = sizeof(arr) / sizeof(arr[0]); // Calculate the number of elements in the array

    // Sorting the array in ascending order
    std::sort(arr, arr + n);

    // Displaying the sorted array
    std::cout << "Sorted array in ascending order: ";
    for(int i = 0; i < n; i++) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;

    return 0;
}
