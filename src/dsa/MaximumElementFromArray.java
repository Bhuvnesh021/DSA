package dsa;

public class MaximumElementFromArray {
    public static void main(String[] args) {
        int[] array = new int[] {1111,2,3,4,1,11,2222,10000,132,1,4,6,4,2222};
        System.out.println(solve(array));
    }
    private static int solve(int[] array) {
        int max = 0;
        for(int i = 0; i < array.length / 2; i++) {
            if(max < array[i]) {
                max = array[i];
            }
            if(max < array[(array.length-1) - i]) {
                max = array[(array.length-1) - i];
            }
        }
        return max;
    }
}
