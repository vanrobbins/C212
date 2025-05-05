package vanar.lab8gui;

import java.util.Arrays;
public class Sort {
    public static void insertionSort(int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            // Move elements greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            // Insert key in the correct position
            arr[j + 1] = key;
        }        
    }
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    public static void mergeSort(int[] arr){
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }
    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length) {
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
        while(i < left.length) arr[k++] = left[i++];
        while(j < right.length) arr[k++] = right[j++];
    }
}
