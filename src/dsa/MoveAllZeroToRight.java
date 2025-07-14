package dsa;

import utility.Utility;

import java.util.Arrays;

public class MoveAllZeroToRight {
    public static void main(String[] args) {
        int[] array = Utility.generateIntArrayWithSomeZeros();
        System.out.println("Input Array:\n" + Arrays.toString(array));
        System.out.println(Arrays.toString(solve(array)));
    }

    private static int[] solve(int[] array) {
        // First Solution
//        for (int i = 0; i < array.length; i++) {
//            if(array[i] == 0) {
//                for (int i1 = i + 1; i1 < array.length; i1++) {
//                    if(array[i1] != 0) {
//                        int temp = array[i1];
//                        array[i1] = array[i];
//                        array[i] = temp;
//                        break;
//                    }
//                }
//            }
//        }
        // Second Solution
        int j = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                j = i;
                break;
            }

        }
        if (j == -1) return array;
        for (int i = j + 1; i < array.length; i++) {
            if (array[i] != 0) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                j++;
            }
        }
        return array;
    }
}
