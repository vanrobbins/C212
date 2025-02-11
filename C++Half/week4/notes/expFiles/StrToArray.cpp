#include <iostream>
#include <sstream>
#include <string>

int main() {
    
    std::string input = "10,20,30,40,50";
    
    
    const int maxSize = 100;  
    int numbers[maxSize];     
    int index = 0;            

    
    std::stringstream ss(input);
    std::string temp;

   
    while (std::getline(ss, temp, ',')) {
        if (index < maxSize) {
            numbers[index] = std::stoi(temp); 
            index++;
        } else {
            std::cerr << "Array size exceeded." << std::endl;
            break;
        }
    }

   
    std::cout << "Stored integers:" << std::endl;
    for (int i = 0; i < index; i++) {
        std::cout << numbers[i] << " ";
    }

    std::cout << std::endl;
    return 0;
}
