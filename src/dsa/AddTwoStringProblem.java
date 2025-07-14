package dsa;

import utility.Utility;

public class AddTwoStringProblem {
    public static void main(String[] args) {


        String first = Utility.getStringInput();   // e.g., "1234"
        String second = Utility.getStringInput();  // e.g., "789"

        // Make both strings the same length by padding the shorter one with leading zeros
        int maxLength = Math.max(first.length(), second.length());
        first = padWithZeros(first, maxLength);
        second = padWithZeros(second, maxLength);

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {
            int f = first.charAt(i) - '0';
            int s = second.charAt(i) - '0';
            builder.append(f + s);  // append digit sum (can be >= 10)
        }

        System.out.println(builder);
    }

    private static String padWithZeros(String str, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length - str.length(); i++) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }
}
