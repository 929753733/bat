package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author lvyue
 * @since 2021/2/15
 */
public class StreamApi3Test {

    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }
}
