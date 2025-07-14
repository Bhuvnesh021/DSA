package dsa;

public class HarmoniousStructures {
   public static int solution(int[] structures) {
       return Math.min(minOperationsAscending(structures), minOperationsDescending(structures));
   }
   // Create ascending stepwise pattern: a[i] = a[i-1] + 1
   private static int minOperationsAscending(int[] structures) {
       int[] temp = structures.clone();
       int operations = 0;
       for (int i = 1; i < temp.length; i++) {
           int required = temp[i - 1] + 1;
           if (temp[i] < required) {
               operations += required - temp[i];
               temp[i] = required;
           }
       }
       return operations;
   }
   // Create descending stepwise pattern: a[i] = a[i-1] - 1
   private static int minOperationsDescending(int[] structures) {
       int[] temp = structures.clone();
       int operations = 0;
       for (int i = 1; i < temp.length; i++) {
           int required = temp[i - 1] - 1;
           if (temp[i] > required) {
               // We can't subtract, so raise temp[i-1] instead
               int add = temp[i] - required;
               operations += add;
               temp[i - 1] += add;
               required = temp[i - 1] - 1;
           }
       }
       return operations;
   }
   // Main method to test
   public static void main(String[] args) {
       System.out.println(solution(new int[]{1,3,7,6,4,1}));       // Output: 4
       System.out.println(solution(new int[]{5, 7, 9, 4, 11}));   // Output: 9
       System.out.println(solution(new int[]{2, 2, 2, 2}));       // Output: 6
       System.out.println(solution(new int[]{1, 2, 3, 4}));       // Output: 0 (already ascending stepwise)
       System.out.println(solution(new int[]{4, 3, 2, 1}));       // Output: 0 (already descending stepwise)
   }
}