package ComputationalThinking;

import java.util.Arrays;

public class TwoDArray {
    public static void main(String[] args) {
        int[][] arr = new int[3][4];
        System.out.println(Arrays.toString(arr));

        for(int[] row: arr){
            System.out.println(Arrays.toString(row));
        }

        int[][] arr2 = {{1,2,3},{4,5,6},{7,8,9}};
        //{{row1},{row2},{row3}}

        //arr.length - number of rows
        //arr[].length - number of columns only for rectangular array
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[0].length; j++){
                arr[i][j] = (int)(Math.random()*101) + 100;
            }
        }
    }
    public int largest(int[][] arr){
        int largest = arr[0][0];
        for(int [] row : arr){
            for(int col : row){
                if(col>largest){
                    largest = col;
                }
            }
        }
        return largest;
    }

    public int largestByRow(int[][] arr, int rowNumber){
        if(arr.length>=rowNumber){
            int largest = arr[rowNumber-1][0];
            for(int num : arr[rowNumber-1]){
                if(num > largest){
                    largest = num;
                }
            }
            return largest;
        }
        else {return 0;}
    }

    public int largest2(int[][] arr){
        int largest = largestByRow(arr, 0);
        for(int i = 0; i<arr.length; i++) {
            if (largestByRow(arr, i) > largest) {
                largest = largestByRow(arr, i);
            }
        }
        return largest;
    }
}
