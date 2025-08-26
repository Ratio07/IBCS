package ComputationalThinking;

public class Practice2 {
    public static void main(String[] args) {


        int[] scores = {10, 27, 0, 99, 87, 56, 56, 67, 67, 56, 67, 67, 67};
        //mode is 56

        System.out.println("The mode is " + mode(scores));
    }

    public static int mode(int[] scores) {
        int[] grades = new int[101];
        int index = 0;
        for (int k : scores) {
            grades[k]++;
        }
        for (int i = 0; i < grades.length; i++) {
            if (grades[index] < grades[i]) {
                index = i;
            }
        }
        return index;
    }
}
