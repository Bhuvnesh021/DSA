package dsa;

public class PatternPrinter {
    public static void main(String[] args) {
        int n = 8; // number of rows

        for (int i = 1; i <= n; i++) {
            // Print left stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Print spaces (2 * (n - i))
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }

            // Print right stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Move to next line
            System.out.println();
        }
    }
}
