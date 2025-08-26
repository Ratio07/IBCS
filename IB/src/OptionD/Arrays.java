package OptionD;

import java.util.ArrayList;

public class Arrays {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie", "Alice", "David", "Bob"};
        System.out.println(java.util.Arrays.toString(noDupArr(names)));
    }


    public static String[] noDupArr(String[] arr){
    if(arr == null){
        return null;
    }
    //String[] NoDup = new String[arr.length];
    ArrayList<String> Nodup = new ArrayList<>();
    for(String s: arr){
        if(s != null && !Nodup.contains(s)){
            Nodup.add(s);
    }
    String[] array = new String[Nodup.size()];
        for (int i=0; i<array.length; i++){
            array[i] = Nodup.get(i);
        }
        return array;
    }


        return arr;
    }
    public double mean (int[][] a){
        int sum = 0;
        int count =0;
        for(int[] row : a){
            for(int value : row){
                sum += value;
                count++;
            }
        }
        return (double) sum/count;
    }


    public double sd(int[][] arr){
        double mean = mean(arr);
        double powDiff = 0;
        int count  = 0;
        for(int [] row: arr){
            for (int value: row){
                powDiff += Math.pow(value-mean,2);
                count++;
            }
        }
        return Math.sqrt(powDiff/count);
    }

    public int largest(int[][] arr){
        int largest = 0;
        for(int[] row : arr){
            for(int value : row){
                if(value > largest){
                    value = largest;
                }
            }
        }
        return largest;
    }

    public int largestByRow(int[][] arr, int row){
        int largest = 0;
        for(int value: arr[row]){
            if(value > largest) {
                value = largest;
            }
        }
        return largest;
    }

    public int largest2(int[][] arr){
        int largest = 0;
        int numRow = arr.length;
        while(numRow>0)
            if(largestByRow(arr, numRow) >largest){
                largest = largestByRow(arr, numRow);
                numRow--;
            }
        return largest;
        }
    }