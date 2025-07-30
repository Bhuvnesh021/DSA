package stream_apis;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RepeatedNonRepeatedCharProblem {
    public static void main(String[] args) {
        List<Character> charList = Arrays.asList('a', 'b', 'c', 'a', 'd', 'e', 'b', 'f');

        LinkedHashMap<Character, Long> collect = charList.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())
        );
        List<Character> list = collect.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).toList();
        System.out.println(list);
    }
}
