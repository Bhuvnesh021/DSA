import java.util.Collections;
import java.util.stream.Stream;

public class TestThree {
    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(6,3,4,2,1,5,7,8);
        integerStream.sorted(Collections.reverseOrder())
                .forEach(integer -> System.out.println("printing number : " + integer));
    }
}
