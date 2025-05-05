package vanar.lab8gui;

import java.io.File;
public  class RunTest {
    public static void startTest(File filePath) {
        CSVWrite outputFile = new CSVWrite(new String[] {"Data Size:","Selection Sort:","Insertion Sort:","Merge Sort:"}, filePath);
        outputFile.headerCSV();
        String dataLine[]= new String[4];

        for(int i=10000;i<=100000;i+=10000){
            int[] array= GenerateRandNum.generateRandomArray(1, 1000,i);
            dataLine[0]=Integer.toString(i);
            dataLine[1]=Double.toString(getTime("selection",array.clone()));
            dataLine[2]=Double.toString(getTime("insertion",array.clone()));
            dataLine[3]=Double.toString(getTime("merge",array.clone()));
            outputFile.writeLine(dataLine);
        }
        outputFile.close();
    }
    public static double getTime(String sortType,int[] array){
        long startTime;
        long endTime;
        if(sortType.equals("insertion")){
            startTime=System.nanoTime();
            Sort.insertionSort(array);
            endTime=System.nanoTime();
            System.out.println(((double)(endTime-startTime))/1000000);
            return ((double)(endTime-startTime))/1000000;
        }
        else if(sortType.equals("selection")){
            startTime=System.nanoTime();
            Sort.selectionSort(array);
            endTime=System.nanoTime();
            System.out.println(((double)(endTime-startTime))/1000000);
            return ((double)(endTime-startTime))/1000000;
        }
        else if(sortType.equals("merge")){
            startTime=System.nanoTime();
            Sort.mergeSort(array);
            endTime=System.nanoTime();
            System.out.println(((double)(endTime-startTime))/1000000);
            return ((double)(endTime-startTime))/1000000;
        }
        else{
            return -1;
        }
    }
}
