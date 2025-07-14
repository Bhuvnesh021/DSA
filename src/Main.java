import utility.Utility;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[][] array = Utility.getBinaryArray(5, 5);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int top = i - 1;
            int bottom = i + 1;
            for (int j = 0; j < array.length; j++) {
                int left = j - 1;
                int right = j + 1;
                if (array[i][j] == 0) {
                    if (top >= 0 && array[top][j] == 1) {
                        array[top][j] = 0;
                    }
                    if (bottom < array.length && array[bottom][j] == 1) {
                        array[bottom][j] = 0;
                    }
                    if (left >= 0 && array[i][left] == 1) {
                        array[i][left] = 0;
                    }
                    if (right < array[0].length && array[i][right] == 1) {
                        array[i][right] = 0;
                    }
                }
            }
        }
        System.out.println(count);

        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }
}