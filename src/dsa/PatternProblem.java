package dsa;

public class PatternProblem {
    public static void main(String[] args) {
        int n = 8;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n * 2; j++) {
                if(j <= i || j > (n * 2) - i ) {
                    System.out.print("*");
                } else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
