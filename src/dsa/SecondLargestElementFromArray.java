package dsa;

public class SecondLargestElementFromArray {
    public static void main(String[] args) {
        int[] array = new int[] {111,2,3,4,1,11,22221,100,132,1,4,6,4,22222};
        System.out.println(solve(array));
    }
    private static int solve(int[] array) {
        int first = array[0];
        int second = array[1];
        for (int i = 0; i < array.length; i++) {
            if(first < array[i]) {
                second = first;
                first = array[i];
            }else if(second < array[i]) {
                second = array[i];
            }
        }
        System.out.println(first);
        return second;
    }
}
