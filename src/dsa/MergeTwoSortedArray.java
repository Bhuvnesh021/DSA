package dsa;

import utility.Utility;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] first = Utility.generateSortedArray();
        int[] second = Utility.generateSortedArray();
        Arrays.fill(second, first[0]);
        System.out.println(Arrays.toString(solve(first, second)));
    }

    private static int[] solve(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int firstCounter = 0;
        int secondCounter = 0;
        for (int i = 0; i < result.length; i++) {
            if(firstCounter == first.length ) {
                while (secondCounter < second.length) {
                    result[i] = second[secondCounter];
                    secondCounter++;
                }
                break;
            }
            if(secondCounter == second.length ) {
                while (firstCounter < first.length) {
                    result[i] = second[firstCounter];
                    firstCounter++;
                }
                break;
            }
            if(first[firstCounter] < second[secondCounter]) {
                result[i] = first[firstCounter];
                firstCounter++;
            }else if(first[firstCounter] == second[secondCounter]) {
                result[i] = first[firstCounter];
//                result[++i] = second[secondCounter];
                firstCounter++;
                secondCounter++;
            }else {
                result[i] = second[secondCounter];
                secondCounter++;
            }
        }
        return result;
    }
}
