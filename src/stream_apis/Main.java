package stream_apis;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // "Java is very popular programming language"
        String str = "JavaJ iss very popular programming language";
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(!str.substring(i+1, charArray.length).contains(String.valueOf(charArray[i]))) {
                System.out.println("First non-repeating char : " + charArray[i]);
                break;
            }
        }
        Character c1 = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream().filter(e -> e.getValue() == 1).findFirst().map(Map.Entry::getKey).get();
        System.out.println(c1);

    }
}