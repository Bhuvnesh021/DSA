package dsa;

import utility.Utility;

public class FindLargestIslandProblem {
    public static void main(String[] args) {
        int[][] array = Utility.getBinaryArray(5, 5);
        System.out.println("Total Number of Islands Found : " + findIslands(array));
    }
    private static int findIslands(int[][] array) {
        int noOfIslands = 0;
        int maxArea = 0;
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array.length; column++) {
                if(array[row][column] == 1) {
                    noOfIslands++;
                    dfs(array, row, column, 0);
                }
            }
        }
        return noOfIslands;
    }
    private static void dfs(int[][] array, int row, int column, int totalArea) {
        if(row < 0 || column < 0 || row > array.length - 1 || column > array[0].length - 1 || array[row][column] == 0) {
            return;
        }
        array[row][column] = 0;
        dfs(array, row + 1, column, totalArea++);
        dfs(array, row - 1, column, totalArea++);
        dfs(array, row, column + 1, totalArea++);
        dfs(array, row, column - 1, totalArea++);
    }
}
