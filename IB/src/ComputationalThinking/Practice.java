package ComputationalThinking;

import java.util.Arrays;

public class Practice {

    public static void main(String[] args) {
        int [] arr = {1, 10, 0, 127, -10, 41};


        //linear search
        //search the biggest
        int largest = arr[0];
        for (int i=0; i<arr.length; i++){
            if(arr[i]>largest){
                largest = arr[i];
            }
            System.out.print(largest);
        }
        int smallest = arr[0];
        for (int i=0; i<arr.length;i++){
            if(arr[i]<smallest){
                smallest=arr[i];
            }
            System.out.print(smallest);
        }
    }
    public static double average(int[] arr){
        double sum = 0;
        for(int j: arr){
            sum += j;
        }
        return sum/arr.length;
    }
    public static boolean isEven(int[] arr){
        for(int j: arr){
            if(j%2 !=0){
                return false;
            }
        }
        return false;
    }
    public static int[] doubleValue(int[] arr){
        int[] DoubleArr = new int[arr.length*2];
        for(int i=0; i<DoubleArr.length;i++){
                DoubleArr[(2*i)+1]= arr[i];
                DoubleArr[2*i]= arr[i];
            }
        return DoubleArr;
        }


    public static int[] reverse(int[] arr){
        int hold;
        for(int i =0; i<arr.length/2;i++){
            hold = arr[arr.length-1-i];
            arr[arr.length-1-i] = arr[i];
            arr[i]= hold;
        }
        return arr;
    }

    public static int[] shiftRight(int[] arr){
        int temp =arr[arr.length-1];
        for (int i = arr.length-1; i>0; i++){
            arr[i] = arr [i-1];
        }
        arr[0] = temp;
        return arr;
    }

    }

