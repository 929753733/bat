package lambda;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author lvyue
 * @since 2021/2/15
 */
public class ForkJoinTest {

    @Test
    public void test1() {
        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0, 100000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("耗费时间为" + Duration.between(start, end).toMillis());
    }

    @Test
    public void test3() {
        Instant start = Instant.now();
        LongStream.rangeClosed(0, 10000000000L).parallel().reduce(0, Long::sum);
        Instant end = Instant.now();
        System.out.println("耗费时间为" + Duration.between(start, end).toMillis());
    }
}
