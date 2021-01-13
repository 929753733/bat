import java.util.concurrent.TimeUnit;

/**
 * 死锁是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象，若无外力干涉那它们都将无法推进下去。
 *
 * @author lvyue
 * @since 2020/7/29
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA, lockB)).start();
        new Thread(new HoldLockThread(lockB, lockA)).start();
    }

}

class HoldLockThread implements Runnable {

    private String lock1;
    private String lock2;

    public HoldLockThread(String lock1, String lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lock1 + "\t 尝试获得：" + lock2);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lock2 + "\t 尝试获得：" + lock1);
            }
        }
    }
}
