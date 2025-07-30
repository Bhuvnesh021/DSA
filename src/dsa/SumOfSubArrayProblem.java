package dsa;

import utility.Utility;

import java.util.Arrays;

public class SumOfSubArrayProblem {
    public static void main(String[] args) {
        int[] array = {-2};
        Arrays.sort(array);
        int totol = array[array.length - 1];
        for (int i = array.length - 2; i > 0; i--) {
            if(array[i] == array[i-1]) {
                continue;
            } else if(totol > (totol + array[i - 1])) {
                break;
            }
            totol+=array[i];
        }
        System.out.println(totol);
    }
}
