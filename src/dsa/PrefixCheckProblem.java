package dsa;

public class PrefixCheckProblem {
    public static void main(String[] args) {
        System.out.println(Math.floor(45.55));
        System.out.println(Math.ceil(45.45));
        System.out.println(Math.sqrt(26));
//        System.out.println(Integer.numberOfLeadingZeros(5));
//        PrefixCheckProblem prefixCheckProblem = new PrefixCheckProblem();
////        System.out.println(prefixCheckProblem.kthCharacter(6));
////        System.out.println(prefixCheckProblem.maxAscendingSum(new int[] {6}));
//        System.out.println(prefixCheckProblem.areAlmostEqual("bank", "kanb"));
    }
    public static int sqrt(int number) {
        int i = 1;
        while (i < number) {
           if(number == i * i) return i;
           i++;
        }
        return 0;
    }
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;
        int[] store = new int[2];
        int counter = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(counter >= 2) return false;
                store[counter++] = i;
            }
        }
        return counter == 2 && s1.charAt(store[0]) == s2.charAt(store[1])
                && s1.charAt(store[1]) == s2.charAt(store[0]);
    }
    public int maxAscendingSum(int[] nums) {
        int total = nums[0];
        int max = total;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[ i + 1]) {
                total+=nums[i+1];
            } else {
                total = nums[i + 1];
            }
            if(max < total) max = total;
        }
        return max;
    }
    public char kthCharacter(int k) {
        String word = "b";
        while(word.length() < k) {
            String generatedString = generateString(word);
            word = word + generatedString;
        }
        System.out.println(word);
        return word.charAt(k);
    }
    public String generateString(String word) {
        char[] charArray = word.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            int ch = charArray[i];
            builder.append((char) (ch + 1));
        }
        return builder.toString();
    }
}
