package dsa;

import java.util.Arrays;

public class SpiralFillingProblem {
    public static void main(String[] args) {
        int num = 5;
        int[][] grid = new int[num][num];

        int top = 0;
        int bottom = grid.length - 1;
        int right = grid.length - 1;
        int left = 0;
        int count = 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                grid[left][i] = count++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                grid[i][right] = count++;
            }
            right--;
            for (int i = right; i >= left ; i--) {
                grid[bottom][i] = count++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                grid[i][left] = count++;
            }
            left++;
        }
        for (int[] ints : grid) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
