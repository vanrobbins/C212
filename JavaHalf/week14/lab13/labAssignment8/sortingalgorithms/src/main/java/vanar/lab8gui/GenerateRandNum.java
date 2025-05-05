package vanar.lab8gui;
import java.util.Random;
public class GenerateRandNum {
    public static int[] generateRandomArray(int min, int max, int size){
        int randomArray[]= new int[size];
        Random random = new Random();
        for(int i=0; i<size;i++){
            randomArray[i]=random.nextInt(min,max+1);
        }
        return randomArray;
    }
}
