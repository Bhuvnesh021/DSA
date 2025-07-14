package stream_apis;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        String str = "pwwkew";
        char[] charArray = str.toCharArray();
        int count = 0;
        StringBuilder builder = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < charArray.length; i++) {
            if(set.add(charArray[i])) {
                builder.append(charArray[i]);
                if(builder.length() > count) {
                    count = builder.length();
                }
            } else {
                set.clear();
//                builder.delete(0, builder.length());
               builder = new StringBuilder();
            }

        }
        System.out.println("count : "+count);
    }
}


/***
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */