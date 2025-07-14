package dp;

public class SubsetSumProblem {
    public static void main(String[] args) {
        int[] array = {2,3,7,8,10};
        int sum = 5;
        boolean[][] dp = new boolean[array.length + 1][sum + 1];
        for (int i = 0; i <= array.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= array.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if(array[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - array[i-1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i -1][j];
                }
            }
        }
        System.out.println(dp[array.length][sum]);
    }
}
