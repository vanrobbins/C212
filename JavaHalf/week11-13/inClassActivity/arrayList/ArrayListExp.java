import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListExp{
     public static void main (String[] args){
         ArrayList<String> list =new ArrayList<>(Arrays.asList("a","b","c","d","e"));
         list.add("Test");
         list.add("Example");
         System.out.println(list);
         list.removeLast();
         System.out.println(list);
         
     }
}