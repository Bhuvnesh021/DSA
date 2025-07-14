package dsa;

public class PrimeNumberProblem {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
//            if( i > 0 && i <= 3) System.out.println(i);
            if(isPrime(i)) System.out.println(i);
        }
    }

    private static boolean isPrime(int i) {
        if(i != 2 && i % 2 == 0) return false;
        for (int j = 3; j <= Math.sqrt(i); j+=2) {
            if(i % j == 0) return false;
        }
        return true;
    }
}
