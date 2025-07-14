package utility;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Utility {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    public static int takeIntegerInput() {
        System.out.println("Please enter an Integer Number: ");
        return scanner.nextInt();
    }
    public static int getRandomNumber() {
        return random.nextInt();
    }
    public static int getBinaryNumber() {
        return random.nextBoolean() ? 0 : 1;
    }
    public static int getRandomNumber(int lowerBoundary, int upperBoundary) {
        return random.nextInt((upperBoundary - lowerBoundary) + 1) + lowerBoundary;
    }
    public static int[] generateIntArrayWithSomeZeros() {
        System.out.println("How many zeros you want in array ?");
        int input = takeIntegerInput();
        int[] array = generateIntegerArray(15);
        int[] result = Arrays.copyOf(array, array.length + input);
        shuffleArray(result);
        return result;
    }
    public static int[] generateIntegerArrayOfNthLength() {
        return generateIntegerArray(takeIntegerInput());
    }
    public static int[] generateSortedArray(){
        int[] array = generateIntegerArray(takeIntegerInput());
        Arrays.sort(array);
        print(array);
        return array;
    }
    public static int[] generateIntegerArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(1000);
        }
        print(array);
        return array;
    }
    public static int[] generateIntegerArrayOfPositiveAndNegativeOfNthLength() {
        return generateIntegerArrayOfPositiveAndNegative(takeIntegerInput());
    }
    public static int[] generateIntegerArrayOfPositiveAndNegative(int n) {
        int[] array = new int[n];
        int min = -500; // Minimum value (negative range)
        int max = 500; // Maximum value (positive range)
        array[0] = random.nextInt(max - 1) + 1; // A positive number in the range [1, max]
        array[1] = random.nextInt(-min - 1) - 1; // A negative number in the range [min, -1]

        // Fill the rest of the array with random numbers in the range [min, max]
        for (int i = 2; i < n; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }

        // Shuffle the array to randomize the positions of positive and negative numbers
        shuffleArray(array);
        print(array);
        return array;
    }
    public static String getStringInput() {
        return scanner.next();
    }
    public static int[][] getBinaryArray(int row, int column) {
        int[][] array = new int[row][column];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = getBinaryNumber();
            }
        }
        for (int[] ints : array) {
            print(ints);
        }
        return array;
    }
    public static int[][] getRandomIntegerArray(int row, int column) {
        int[][] array = new int[row][column];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = getRandomNumber(0,5);
            }
        }
        for (int[] ints : array) {
            print(ints);
        }
        return array;
    }
    public static void shuffleArray(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    private static void print(int[] array){
        System.out.println(Arrays.toString(array));
    }
}
