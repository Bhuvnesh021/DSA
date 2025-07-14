import java.util.stream.Stream;

public class TestFour {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        integerStream.forEach(integer -> System.out.println("printing number : " + integer));
    }
}
