package lambda;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author lvyue
 * @since 2021/2/15
 */
public class StreamApi4Test {

    /**
     * 1.给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
     * 给定[1,2,3,4,5],应该返回[1,4,9,16,25]。
     */
    @Test
    public void test1() {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
        Arrays.stream(nums).map((x) -> x * x).forEach(System.out::println);
    }
}
