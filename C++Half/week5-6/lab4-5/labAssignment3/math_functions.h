//math_functions.h
#ifndef MATH_FUNCTIONS_H
#define MATH_FUNCTIONS_H
double arithmeticMean(const std::vector<int>& numbers);
double geometricMean(const std::vector<int>& numbers);
double harmonicMean(const std::vector<int>& numbers);
double standardDeviation(const std::vector<int>& numbers);
double variance(const std::vector<int>& numbers);
double median(std::vector<int> numbers);
int mode(const std::vector<int>& numbers);
int maximumNumber(const std::vector<int>& numbers);
int minimumNumber(const std::vector<int>& numbers);
#endif