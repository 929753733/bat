import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lvyue
 * @since 2020/12/2
 */
public class SynchronizedDemo {

    private Integer bbb;

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    private static volatile int a = 0;

    private static int getA() {
        int a1 = a;
        return a1;
    }

    private void aaaaaa() {
        synchronized (bbb) {

        }
    }

    private static synchronized void innerA() {
        int a2 = getA();
        a = a2 + 1;
    }

    public int getA2() {
        reentrantReadWriteLock.readLock().lock();
        int a2 = 0;
        try {
            a2 = getA();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }
        return a2;
    }

    public void putA2() {
        reentrantReadWriteLock.writeLock().lock();
        try {
            a = a + 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    private static void aaa() throws InterruptedException {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
//                innerA();
                synchronizedDemo.putA2();
                System.out.println(a);
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("计算完毕");
    }

    public static void main(String[] args) throws InterruptedException {

        long aa  = System.currentTimeMillis();
        aaa();
        long bb = System.currentTimeMillis();
        System.out.println("=====" + a);
        System.out.println("time ===" + (bb - aa));

    }
}
