package dsa;

public class PossibleDecodingWaysProblem {
    public static void main(String[] args) {
        System.out.println("12".substring(1 , 2));
        String str = "31551";
        int[] dp = new int[str.length() + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= str.length(); i++) {
            int oneDigit = Integer.parseInt(str.substring((i - 1), i));
            int twoDigit = Integer.parseInt(str.substring((i - 2), i));

            if(oneDigit >= 1 && oneDigit <= 9) {
                dp[i]+=dp[i - 1];
            }
            if(twoDigit >= 10 && twoDigit <= 26) {
                dp[i]+=dp[i - 2];
            }
        }
        System.out.println(dp[str.length()]);
    }
}
