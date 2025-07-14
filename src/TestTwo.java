import java.util.stream.Stream;

public class TestTwo {
    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        integerStream.filter(integer -> integer % 2 == 0).map(integer -> integer * integer)
                .forEach(integer -> System.out.println("printing number : " + integer));
    }
}
