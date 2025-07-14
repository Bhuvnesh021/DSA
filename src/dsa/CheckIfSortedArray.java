package dsa;

public class CheckIfSortedArray {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 100, 132, 2222};
        System.out.println(solve(array));
    }

    private static boolean solve(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) return true;
            if (!(array[i] <= array[i + 1])) return false;
        }
        return true;
    }
}
