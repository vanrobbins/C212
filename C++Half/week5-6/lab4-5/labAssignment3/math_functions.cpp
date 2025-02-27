#include <vector>
#include <cmath>
#include <numeric>
#include <algorithm>
#include <unordered_map>
#include "math_functions.h"

double arithmeticMean(const std::vector<int>& numbers) {
    return std::accumulate(numbers.begin(), numbers.end(), 0.0) / numbers.size();
}

double geometricMean(const std::vector<int>& numbers) {
    double product = 1.0;
    for (int num : numbers) {
        product *= num;
    }
    return std::pow(product, 1.0 / numbers.size());
}

double harmonicMean(const std::vector<int>& numbers) {
    double sum = 0.0;
    for (int num : numbers) {
        sum += 1.0 / num;
    }
    return numbers.size() / sum;
}

double standardDeviation(const std::vector<int>& numbers) {
    double mean = arithmeticMean(numbers);
    double variance = 0.0;
    for (int num : numbers) {
        variance += (num - mean) * (num - mean);
    }
    return std::sqrt(variance / numbers.size());
}

double variance(const std::vector<int>& numbers) {
    double mean = arithmeticMean(numbers);
    double sum = 0.0;
    for (int num : numbers) {
        sum += (num - mean) * (num - mean);
    }
    return sum / numbers.size();
}

double median(std::vector<int> numbers) {
    std::sort(numbers.begin(), numbers.end());
    size_t n = numbers.size();
    return (n % 2 == 0) ? (numbers[n / 2 - 1] + numbers[n / 2]) / 2.0 : numbers[n / 2];
}

int mode(const std::vector<int>& numbers) {
    std::unordered_map<int, int> frequency;
    for (int num : numbers) {
        frequency[num]++;
    }
    int mode = numbers[0];
    int max_count = 0;
    for (const auto& [num, count] : frequency) {
        if (count > max_count) {
            max_count = count;
            mode = num;
        }
    }
    return mode;
}

int maximumNumber(const std::vector<int>& numbers) {
    return *std::max_element(numbers.begin(), numbers.end());
}

int minimumNumber(const std::vector<int>& numbers) {
    return *std::min_element(numbers.begin(), numbers.end());
}
