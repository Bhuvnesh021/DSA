package dsa;

public class HarmoniousStructure {

    public static int maxHarmoniousSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n]; // dp[i] = max sum ending at i with harmonious structure
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = arr[i]; // at least the number itself
            for (int j = 0; j < i; j++) {
                if (Math.abs(arr[i] - arr[j]) == 2) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3, 7, 6, 4, 1};
        int[] a2 = {5, 7, 9, 4, 11};
        int[] a3 = {2, 2, 2, 2};
        int[] a4 = {1, 2, 3, 4};
        int[] a5 = {4, 3, 2, 1};

        System.out.println(maxHarmoniousSum(a1)); // 17
        System.out.println(maxHarmoniousSum(a2)); // 9
        System.out.println(maxHarmoniousSum(a3)); // 6
        System.out.println(maxHarmoniousSum(a4)); // 0
        System.out.println(maxHarmoniousSum(a5)); // 0
    }
}
