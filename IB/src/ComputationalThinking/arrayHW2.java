package ComputationalThinking;
import java.util.Scanner;

public class arrayHW2 {
    int [] arr = {1, 10, 0, 127, -10, 41};


    public static void AverageScore(int[] arr){
        double sum=0;
        double average =0;
        int aboveAvg=0;
        int belowAvg=0;
        for(int j: arr){
            sum+= j;
        }
        average = sum / arr.length;
        for (int i=0; i<arr.length; i++){
            if (arr[i]>=average){
                aboveAvg++;
            }
            else{belowAvg++;}
        }
        System.out.println(-1);
    }

    public static String distintNumber(int[] arr){
        String result= "";
        for (int i=0; i<arr.length; i++) {
            for (int j = i + 1; i < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    break;
                } else {
                    result += arr[i] + ", ";
                }
            }
        }
        return result;
    }

    public static int[] RandomCount(){
        int[] Random = new int[100];
        int[] result = new int [10];
        for(int i =0; i<Random.length; i++){
            int Generate = (int)(Math.random() *10);
            Random[i] = Generate;
            if (Generate == 0){
                result[0]++;
            }
            else if(Generate == 1){
                result[1]++;
            }
            else if(Generate == 2){
                result[2]++;
            }
            else if(Generate == 3){
                result[3]++;
            }
            else if(Generate == 4){
                result[4]++;
            }
            else if(Generate == 5){
                result[5]++;;
            }
            else if(Generate == 6){
                result[6]++;
            }
            else if(Generate == 7){
                result[7]++;
            }
            else if(Generate == 8){
                result[8]++;
            }
            else{
                result[9]++;
            }
        }
        return result;
    }

    public String[] Occurance(int[] arr){
        String[] result = new String[arr.length];
        int count = 1;
        String Time= "time";
        for (int i=0; i<arr.length; i++) {
            for (int j = i + 1; i < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if(count!= 1){
                Time = "times";
            }
            else{Time = "time";}
            result[i] += arr[i] + " occurs " + count + " " + Time;
            count = 1;
        }
        return result;
    }
}
