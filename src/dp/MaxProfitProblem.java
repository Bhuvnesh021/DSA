package dp;

public class MaxProfitProblem {
    public static void main(String[] args) {
        int[] wt = {1,3,5,6,8};
        int[] val = {2,1,3,5,6};
        int knapsack = knapsack(wt, val,    7, wt.length);
        System.out.println(knapsack);
    }
    private static int knapsack(int[] wt, int[] val, int capacity, int size) {
        if(capacity == 0 || size == 0) return 0;
        if(wt[size -1] <= capacity) {
            return Math.max(val[size -1] + knapsack(wt, val, capacity - wt[size -1], size - 1) , knapsack(wt, val, capacity, size -1 ));
        } else {
            return knapsack(wt, val, capacity, size - 1);
        }
    }
}
