package dsa;

import java.util.Arrays;

public class SpiralFillingProblemTopBottom {
    public static void main(String[] args) {

        int num = 6;
        Object[][] grid = new Object[num][num];

        int top = 0;
        int bottom = grid.length - 1;
        int right = grid.length - 1;
        int left = 0;
        int count = 64;
        while (top <= bottom && left <= right) {
            for (int i = top; i <= bottom; i++) {
                grid[i][left] = getCounter(++count);
            }
            left++;
            for (int i = left; i <= right; i++) {
                grid[bottom][i] = getCounter(++count);
            }
            bottom--;
            for (int i = bottom; i >= top ; i--) {
                grid[i][right] = getCounter(++count);
            }
            right--;
            for (int i = right; i >= left; i--) {
                grid[top][i] =getCounter(++count);
            }
            top++;
        }
        for (Object[] ints : grid) {
            System.out.println(Arrays.toString(ints));
        }
    }
    private static Object getCounter(int count) {
        if(count > 90) {
            return count - 90;
        }else return (char)count;
    }
}
