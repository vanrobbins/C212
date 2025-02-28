// Function to find the average of an array
double findAverage(const int arr[], int size){
    double sum=0;
    for(int i=1; i<size; i++){
        sum+=arr[i];
    }
    return sum/size;
};

// Function to find the maximum value in an array
int findMax(const int arr[], int size){
    int max=arr[1];
    for(int i=2; i<size; i++){
        if(arr[i]>max){
            max=arr[i];
        }
    }
    return max;
};

// Function to find the minimum value in an array
int findMin(const int arr[], int size){
    int min=arr[1];
    for(int i=2; i<size; i++){
        if(arr[i]<min){
            min=arr[i];
        }
    }
    return min;
};

// Function to sort an array in ascending order
void sortArray(int arr[], int size){
    for(int i=1; i<size; i++){
        for(int j=i+1; j<size; j++){
            if(arr[i]>arr[j]){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
    }
};