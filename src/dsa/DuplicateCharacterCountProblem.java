package dsa;

import utility.Utility;

public class DuplicateCharacterCountProblem {
    public static void main(String[] args) {
        char[] input = Utility.getStringInput().toCharArray();
        int counter = 0;
        for (int i = 0; i < input.length; i++) {
            if(i != input.length - 1 && input[i] == input[i+1]) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
