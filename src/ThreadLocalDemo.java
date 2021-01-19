import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author lvyue
 * @since 2020/12/8
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {
//        ThreadLocal threadLocal1 = new ThreadLocal();
//        threadLocal1.set("dddd");
//        System.out.println(threadLocal1.get());
//
//        ThreadLocal threadLocal2 = new ThreadLocal();
//        threadLocal2.set("eee");
//        System.out.println(threadLocal2.get());

        bbb();
    }

    public static void bbb() {
        ThreadLocal<String> local = new ThreadLocal<>();
        Random random = new Random();
        IntStream.range(0, 5).forEach(a -> new Thread(() -> {
            local.set(a + " " + random.nextInt(10));
            System.out.println(local.toString());
            System.out.println("线程为：" + a + "，local值为：" + local.get());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start());
    }

    public static void aaa() {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("main");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                ThreadLocal threadLocal1 = new ThreadLocal();
                threadLocal1.set("eeeeee");
                threadLocal1.set("33333");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "--" + threadLocal1.get());
            }).start();
        }
        System.out.println(Thread.currentThread().getName() + "--" + threadLocal.get());
    }
}
