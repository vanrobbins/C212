double findAverage(const int arr[], int size){
    double sum=0;
    for(int i=0; i<size; i++){
        sum+=arr[i];
    }
    return sum/size;
};
int findMax(const int arr[], int size){
    int max=arr[0];
    for(int i=1; i<size; i++){
        if(arr[i]>max){
            max=arr[i];
        }
    }
    return max;
};
int findMin(const int arr[], int size){
    int min=arr[0];
    for(int i=1; i<size; i++){
        if(arr[i]<min){
            min=arr[i];
        }
    }
    return min;
};
void sortArray(int arr[], int size){
    for(int i=0; i<size; i++){
        for(int j=i+1; j<size; j++){
            if(arr[i]<arr[j]){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
    }
};