import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortedArrayLists_Robbins_Van {
    private static ArrayList<Integer> sortedMergeIntegers;

    //Merge sorted array list function
    public static ArrayList<Integer> mergeArrayList(ArrayList<Integer> array1, ArrayList<Integer> array2) {
        sortedMergeIntegers = new ArrayList<>();
        int i = 0, j = 0;//Initialize counters
        Integer element1, element2;//Initialize single arraylist value holders
        // Merge elements from both arrays
        while (i < array1.size() && j < array2.size()) {
            element1 = array1.get(i);//element1== arrayList1 Element at i
            element2 = array2.get(j);//element2== arrayList2 Element at j
            if (element1 < element2) { //element1 less than element2
                sortedMergeIntegers.add(element1);
                i++;
            } 
            else if (element1 > element2) { //element2 less than element1
                sortedMergeIntegers.add(element2);
                j++;
            } 
            else { //element1==element2; add both elements; could also make it so only adds one so no duplicates
                sortedMergeIntegers.add(element1);
                sortedMergeIntegers.add(element2);
                i++;
                j++;
            }
        }
        // Append remaining elements from array1 if longer then array2
        while (i < array1.size()) {
            sortedMergeIntegers.add(array1.get(i));
            i++;
        }

        // Append remaining elements from array2 if longer than array1
        while (j < array2.size()) {
            sortedMergeIntegers.add(array2.get(j));
            j++;
        }

        return sortedMergeIntegers;
    }
    //Main Run
    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8, 10, 12, 14));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(4, 6, 5, 7, 9, 11, 13, 15, 17, 19));
        ArrayList<Integer> mergedList = mergeArrayList(arrayList1, arrayList2);

        System.out.println("Merged List: " + mergedList);
    }
}
