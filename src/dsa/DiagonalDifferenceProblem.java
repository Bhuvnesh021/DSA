package dsa;

import utility.Utility;

public class DiagonalDifferenceProblem {
    public static void main(String[] args) {
        int[][] array = Utility.getRandomIntegerArray(6,6);
        int sumL = 0;
        int sumR = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; true; j++) {
                sumL+=array[i][j];
                sumR+=array[i][(array.length - 1) - j];
                break;
            }

        }
        System.out.println(sumL);
        System.out.println(sumR);
        System.out.println("Difference : " + (sumR - sumL));

    }
}
