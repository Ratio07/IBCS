package ComputationalThinking;

import java.util.Arrays;

public class sorting {
    public static void main(String[] args) {
        int[] array = {9, 4, 8, 10, 4, 2, 8, 730298, 19392, 2222,2};
        String[] words = {"apple", "mango", "grape", "banana"};
        sortedFreq(array);
        SelectionSort(array);
        System.out.println(Arrays.toString(array));
        stringBubbleSort(words);
        System.out.println(Arrays.toString(words));
    }

    public static void bubbleSort (int[] arr){
       for(int i=0; i<arr.length-1; i++){
           boolean swap = false;
           for(int j =0; j<arr.length-1-i; j++){
               if(arr[j]>arr[j+1]){
               int temp = arr[j];
               arr[j] = arr[j + 1];
               arr[j + 1] = temp;
               swap = true;
               }
           }
           if(!swap){
               break;
           }
       }
    }
    public static void stringBubbleSort(String[] arr){
        for(int i=0; i<arr.length-1; i++){
            boolean swap = false;
            for(int j =0; j<arr.length-1-i; j++){
                if(arr[j].compareTo(arr[j+1])>0){
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }
    }
    public static void SelectionSort(int[] arr){
        boolean condition = true;
        for(int i=0; i<arr.length-1; i++){
            int min_idx = i;
            for(int j =min_idx+1; j<arr.length; j++) {
                if(arr[j]<arr[min_idx]) {
                    min_idx = j;
                    condition = false;
                }
            }
            if(condition){break;}

            int temp = arr[min_idx];
            arr[min_idx]=arr[i];
            arr[i]=temp;
        }
    }

    public static void sortedFreq(int[] arr) {

        int freqCount = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length -1 ; i++) {
            if (arr[i] == arr[i + 1]) {
                freqCount++;
            } else {
                System.out.println("The number " + arr[i] + " appears " + freqCount + " times");
                freqCount=1;
            }
        }
        System.out.println("The number " + arr[arr.length] + " appears " + freqCount + " times");
    }
}
