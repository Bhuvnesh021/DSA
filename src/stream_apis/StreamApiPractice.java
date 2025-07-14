package stream_apis;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApiPractice {
    public static void main(String[] args) {
        filterEvenNumber();
        squareNumber();
        groupEmployeesByDept();
        countWordFrequency();
        highestPaidEmployeeInEachDept();
        partitionNumberIntoOddAndEven();
        summarizingEmployee();
        flattenAndSort();
        removeDuplicatesAndSort();
        findFirstRepeatedChar();
        findDuplicateElements();
        findTopNRepeatedElements();
        splitAndFlatten();
        findLongestString();
    }

    private static void findLongestString() {
//        List<String> words = Arrays.asList("elephant", "cat", "hippopotamus", "dog");
//        Optional<Integer> first = words.stream().collect(Collectors.groupingBy());
//        System.out.println(first.get());
    }

    private static void splitAndFlatten() {
        List<String> csv = Arrays.asList("a,b,c", "d,e", "f");
        List<String> list = csv.stream().flatMap(str -> Arrays.stream(str.split(","))).toList();
        System.out.println(list);

    }

    private static void findTopNRepeatedElements() {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple", "kiwi", "kiwi");
        List<Map.Entry<String, Long>> list = words.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .toList();
        System.out.println(list);
    }

    private static void findDuplicateElements() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6);
        Set<Integer> seen = new HashSet<>();
        Set<Integer> collect = numbers.stream().filter(n -> !seen.add(n)).collect(Collectors.toSet());
        System.out.println(collect);
    }

    private static void findFirstRepeatedChar() {
        String input = "jsjwwiss";
        Optional<Map.Entry<Character, Long>> first = input.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new, Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .findFirst();
        System.out.println(first.get().getKey() + " repeated");

    }

    private static void removeDuplicatesAndSort() {
        List<Integer> numbers = Arrays.asList(5, 3, 7, 3, 2, 2, 9, 1, 5);
        List<Integer> list = numbers.stream().distinct().sorted().toList();
        System.out.println(list);
    }

    private static void flattenAndSort() {
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(3, 5),
                Arrays.asList(1, 2),
                Arrays.asList(4, 6)
        );
        List<Integer> list = nested.stream().flatMap(Collection::stream).sorted().toList();
        System.out.println(list);
    }

    private static void summarizingEmployee() {
        List<Employee> employees = getEmployeeData();
        DoubleSummaryStatistics collect = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Total salary " + collect.getSum());
        System.out.println("Average salary " + collect.getAverage());
        System.out.println("Max salary " + collect.getMax());
        System.out.println("Min salary " + collect.getMin());
        System.out.println("Count of employees " + collect.getCount());
    }

    private static void partitionNumberIntoOddAndEven() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Map<Boolean, List<Integer>> collect = numbers.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println(collect);
    }

    private static void highestPaidEmployeeInEachDept() {

        Map<String, Optional<Employee>> collect = getEmployeeData().stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

        System.out.println(collect);


    }

    private static void countWordFrequency() {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange",  "orange","banana", "apple");
        Map<String, Long> collect = words.stream().collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        System.out.println(collect);
    }

    private static void groupEmployeesByDept() {
        List<Employee> employees = getEmployeeData();
        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(collect);
    }

    private static List<Employee> getEmployeeData() {
        return Arrays.asList(
                new Employee("Alice", 10000, "HR"),
                new Employee("Bob", 12000, "IT"),
                new Employee("Charlie", 9000, "HR"),
                new Employee("David", 11000, "IT")
        );
    }

    private static void squareNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list = numbers.stream().map(num -> num * num).filter(num -> num > 10).toList();
        System.out.println(list);
    }

    private static void filterEvenNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> collect = numbers.stream().filter(num -> num % 2 == 0).toList();
        System.out.println(collect);
    }

}
