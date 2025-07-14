package dsa;

public class NumberOfIslands {
    /**
     *  1,1,1,0,0,0
     *  1,1,1,0,0,0
     *  0,0,0,1,0,0
     *  0,0,0,0,1,1
     *  0,0,0,0,0,0
     */
    private static final int[][] DIRECTIONS = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    public static void main(String[] args) {
        int[][] array = {
                {1, 0, 1, 0, 1, 1},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 0}
        };
        int result = checkForTheIslands(array);
        System.out.println("number of islands : "+result);
    }

    private static int checkForTheIslands(int[][] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(array[i][j] == 1) {
                    result++;
                    makeAdjacentToZero(array, i, j);
                }
            }
        }
        return result;
    }

    private static void makeAdjacentToZero(int[][] array, int i, int j) {
       if(i < 0 || i > array.length - 1 || j < 0 || j > array[0].length - 1 || array[i][j] == 0) {

       } else {
           array[i][j] = 0;
           makeAdjacentToZero(array, i + 1, j);
           makeAdjacentToZero(array, i - 1, j);
           makeAdjacentToZero(array, i , j + 1);
           makeAdjacentToZero(array, i, j - 1);
       }
    }

    private static void makeAdjacentToZero(int[][] array) {

    }

    private static boolean boundaryCheck() {
        return false;
    }
    private static void assignIslandsToBucket(int[][] bucket) {
        bucket[0][0] = 0;
        bucket[0][1] = 1;
        bucket[0][2] = 1;
        bucket[1][0] = 1;
        bucket[1][1] = 0;
        bucket[1][2] = 0;
        bucket[2][0] = 1;
        bucket[2][1] = 1;
        bucket[2][2] = 2;
//        bucket[2][4] = 1;
    }
}
