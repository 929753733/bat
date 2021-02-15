package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author lvyue
 * @since 2021/2/12
 */
public class LambdaTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.forEach(item -> {
            System.out.println(item);
        });
        System.out.println("===================");
        list.forEach(System.out::println);
    }

    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
    }
}
