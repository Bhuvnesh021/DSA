package advent;

import java.util.ArrayList;

public class IndexOfSubArraySum {
    public static void main(String[] args) {
        ArrayList<Integer> integers = subarraySum(new int[]{1, 2, 3, 4, 6}, 16);
        System.out.println(integers);
    }
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            for (int i1 = i+1; i1 < arr.length; i1++) {
                sum+=arr[i1];
                if(sum == target) {
                    result.clear();
                    result.add(i+1);
                    result.add(i1+1);
                    return result;
                }
            }
            if(result.contains(-1) && arr[i] == target) {
                result.clear();
                result.add(i+1);
                result.add(i+1);
                return result;
            }
        }
        return result;
    }
}
