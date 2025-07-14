import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatternMatchingProblem {
    public static void main(String[] args) {
        String[] input = {"abc", "deq", "mee", "aqq", "dkd", "ccc", "asda"};
        String pattern = "sss";
        List<String> list = new ArrayList<>();
        for (String s : input) {
            if(pattern.length() == s.length()) {
                if(matchesPattern(s, pattern)){
                    list.add(s);
                }
            }
        }
        System.out.println(list);
    }
    private static boolean matchesPattern(String word, String pattern) {
        if (word.length() != pattern.length()) return false;

        Map<Character, Character> pToW = new HashMap<>();
        Map<Character, Character> wToP = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char pChar = pattern.charAt(i);
            char wChar = word.charAt(i);

            if (pToW.containsKey(pChar)) {
                if (pToW.get(pChar) != wChar) return false;
            } else {
                pToW.put(pChar, wChar);
            }

            if (wToP.containsKey(wChar)) {
                if (wToP.get(wChar) != pChar) return false;
            } else {
                wToP.put(wChar, pChar);
            }
        }
        return true;
    }
}
