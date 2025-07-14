package stream_apis;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String input = "Java is very popular programming language";

        Character result = input.chars() // IntStream of character code points
                .mapToObj(c -> (char) c) // Convert to Character Stream
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new, // Preserve order of insertion
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1) // Filter non-repeating
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null); // Return null if none found

        if (result != null) {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
