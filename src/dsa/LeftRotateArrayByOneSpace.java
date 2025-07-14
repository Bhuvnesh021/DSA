package dsa;

import java.util.Arrays;

public class LeftRotateArrayByOneSpace {
    public static void main(String[] args) {
        int[] array = new int[]{111,2,3,4,1,11,2222,100,132,1,4,6,4,2222};
        System.out.println(Arrays.toString(solve(array)));
    }
    private static int[] solve(int[] array) {
        int first = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i+1];
        }
        array[array.length - 1] = first;
        return array;
    }
}
