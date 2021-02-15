package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lvyue
 * @since 2021/2/13
 */
public class StreamApi1Test {

    @Test
    public void test1() {

        // 1.可以通过Collection系列集合提供的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        // 2.通过Arrays中的静态方法stream()获取数据流。
        String[] strs = new String[10];
        Stream<String> stream2 = Arrays.stream(strs);

        // 3.通过Stream类中静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        // 4.创建无限流
        // 迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);

        // 生成
        Stream.generate(() -> Math.random()).limit(5).forEach(System.out::println);

    }
}
