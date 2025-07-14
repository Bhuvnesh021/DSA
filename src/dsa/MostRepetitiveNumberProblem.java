package dsa;

public class MostRepetitiveNumberProblem {
    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,1,1,1,5,6,7,8,9,10};
        int number = Integer.MAX_VALUE;
        int count = 1;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != number) {
                count--;
            }else {
                count++;
            }
            if(count == 0) {
                number = array[i];
                count++;
            }
        }
    }
}