package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonCharProblem {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("ac"));
//        System.out.println(solution.checkPalindrome("asdsssdsa"));
        System.out.println(solution.balancedStringSplit("LLLLRRRR"));
        System.out.println(Solution.commonChars1(new String[]{"ocool","loocok","cook"}));
    }
}
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() < 3) return s;
        char[] charArray = s.toCharArray();
        String largestPalindrome = "";
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i; j < charArray.length; j++) {
                String substring = s.substring(i, j + 1);
                if(checkPalindrome(substring)) {
                    if(substring.length() > largestPalindrome.length()) {
                        largestPalindrome = substring;
                    }
                }
            }
        }
        return largestPalindrome;
    }

    public boolean checkPalindrome(String substring) {
        char[] charArray = substring.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] != charArray[charArray.length -1 - i]){
                return false;
            }
        }
        return true;
    }

    public static List<String> commonChars1(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : words) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i]-- > 0) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }

        return result;
    }
    public List<String> commonChars(String[] words) {
        String str = words[0];
        int small = words[0].length();
        for (int i = 0; i < words.length; i++) {
            if(small > words[i].length()) {
                small = words[i].length();
                str = words[i];
            }
        }
        System.out.println("small : " + small + " word " + str);
        List<String> list = new ArrayList<>();
        char[] strArray = str.toCharArray();
        for (int i = 0; i < strArray.length; i++) {
            boolean isCharMatch = false;
            for (String word : words) {
                if(word.equals(str)) continue;
                char[] charArray = word.toCharArray();
                boolean isMatch = false;
                for (int i1 = 0; i1 < charArray.length; i1++) {
                    if(charArray[i1] == strArray[i]) {
                        charArray[i1] = '_';
                        isMatch = true;
                        break;
                    }
                }
                if(!isMatch) {
                    isCharMatch = false;
                    break;
                }
                isCharMatch = true;
            }
            if(isCharMatch) list.add(String.valueOf(strArray[i]));
        }
        return list;
    }
    public int balancedStringSplit(String s) {
        char[] charArray = s.toCharArray();
        int rCounter = 0;
        int lCounter = 0;
        int result =0;
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == 'L') {
                lCounter++;
                rCounter--;
            } else  {
                lCounter--;
                rCounter++;
            }
            if(rCounter == 0 && lCounter == 0) {
                result++;
            }

        }
        return result;
    }
}