package dsa;

import utility.Utility;

import java.util.Arrays;

public class LeftRotateArrayByNthSpace {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(Utility.generateIntegerArray(20), Utility.takeIntegerInput())));
    }
    // 1,2,3,4,5,6,7
    //3,2,1,4,5,6,7
    //3,2,1,7,6,5,4
    //4,5,6,7,1,2,3
    private static int[] solve(int[] array, int nthSpace) {
        reverse(array, 0, nthSpace - 1);
        reverse(array, nthSpace, array.length - 1);
        reverse(array, 0, array.length - 1);
        return array;
    }

    private static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[end];
            array[end] = array[start];
            array[start] = temp;
            start++;
            end--;
        }
    }
}
