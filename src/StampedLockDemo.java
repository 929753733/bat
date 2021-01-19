import sun.security.x509.IPAddressName;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @author lvyue
 * @since 2021/1/17
 */
public class StampedLockDemo {

    static ExecutorService service = Executors.newFixedThreadPool(10);
    static StampedLock lock = new StampedLock();
    static long milli = 5000;
    static int count = 0;

    private static long writeLock() {
        System.out.println("222222222");
        long stamp = lock.writeLock();
        count+=1;
        lock.unlockWrite(stamp);
        System.out.println("数据写入完成");
        return System.currentTimeMillis();
    }

    private static void optimisticRead() {
        service.submit(() -> {
            System.out.println("111111111");
            long stamp = lock.tryOptimisticRead();
            System.out.println(lock.validate(stamp));
            int currentCount = count;
            try {
                System.out.println("开始等待===");
                TimeUnit.MILLISECONDS.sleep(milli);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!lock.validate(stamp)) {
                System.out.println("只能获取读锁");
                stamp = lock.readLock();
                try {
                    currentCount = count;
                    System.out.println("赋值成功！");
                } finally {
                    lock.unlockRead(stamp);
                }
            }

            System.out.println("optimisticRead==" + currentCount);
        });
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        optimisticRead();
        long l2 = writeLock();
        System.out.println(l2 - l1);
    }


}
