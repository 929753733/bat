import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lvyue
 * @since 2020/7/7
 */
public class AtomicIntegerDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2020) + "\t" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2020) + "\t" + atomicInteger.get());
    }
}
