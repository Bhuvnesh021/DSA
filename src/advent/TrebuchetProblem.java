package advent;

import java.util.Scanner;

public class TrebuchetProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println("Trebuchet line : " + line);
        System.out.println("Calibration value of " + line + " is ~~ " + findCalibrationValue(line));
    }

    private static Integer findCalibrationValue(String str) {
        char[] charArray = str.toCharArray();
        String firstIndex = null;
        String lastIndex = null;
        for (int i = 0; i < charArray.length; i++) {
            if (firstIndex == null && Character.isDigit(charArray[i])) {
                firstIndex = String.valueOf(charArray[i]);
            }
            if (lastIndex == null && Character.isDigit(charArray[charArray.length - 1 - i])) {
                lastIndex = String.valueOf(charArray[charArray.length - 1 - i]);
            }
            if (firstIndex != null && lastIndex != null) break;
        }
        return Integer.parseInt(firstIndex + lastIndex);
    }
}
