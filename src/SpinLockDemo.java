import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvyue
 * @since 2020/7/9
 */
public class SpinLockDemo {

    Lock lock = new ReentrantLock();

    public void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t his is get method");
            set();
        } finally {
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t ******this is set method");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.get();
        }, "t1").start();

        new Thread(() -> {
            spinLockDemo.get();
        }, "t2").start();
    }
}
