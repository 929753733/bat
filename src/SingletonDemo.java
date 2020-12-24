import java.io.FileInputStream;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lvyue
 * @since 2020/7/7
 */
public class SingletonDemo {

    // 禁止指令重排。
    private static volatile SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonDemo");
    }

    /**
     * DCL(double check lock双端检索机制)
     */
    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
            }).start();
        }
    }
}
