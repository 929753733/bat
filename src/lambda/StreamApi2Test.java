package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lvyue
 * @since 2021/2/15
 */
public class StreamApi2Test {

    @Test
    public void test5() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream().map((x) -> x.toUpperCase()).forEach(System.out::println);

        System.out.println("==============================");

        Stream<Stream<Character>> stream = list.stream().map(StreamApi2Test::filterCharacter);
        /**
         * map将上述的list整合成的流的格式为{{a, a, a}, {b, b, b}}
         */
        stream.forEach((sm) -> {
            sm.forEach(System.out::println);
        });

        System.out.println("==============================");

        /**
         * flatMap将上述的list整合成的流的格式为{a, a, a, b, b, b}
         */
        Stream<Character> sm = list.stream().flatMap(StreamApi2Test::filterCharacter);
        sm.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    @Test
    public void test7() {
        List<String> list = Arrays.asList("ccc", "aaa", "bbb", "ddd", "eee");
        list.stream().sorted().forEach(System.out::println);
    }
}
