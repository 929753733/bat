import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

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

/**
 * 静态内部类方式
 */
class Singleton2 {
    private Singleton2() {};
    private static class Singleton2Holder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    public static final Singleton2 getInstance() {
        return Singleton2Holder.INSTANCE;
    }
}

class Singleton3 {
    private Singleton3() {};
    private static Singleton3 INSTANCE = new Singleton3();
    public static Singleton3 getInstance() {
        return INSTANCE;
    }

}
