package stamplockdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @author lvyue
 * @since 2020/11/28
 */
public class StampLockDemo2 {

    static ExecutorService service = Executors.newFixedThreadPool(10);
    static StampedLock lock = new StampedLock();
    static long milli = 5000;
    static int count = 0;

    private static long writeLock() {
        // 获取排他写锁
        long stamp = lock.writeLock();
        count+=1;
        // 释放写锁
        lock.unlockWrite(stamp);
        System.out.println("数据写入完成");
        return System.currentTimeMillis();
    }

    private static void optimisticRead() {
        service.submit(() -> {
            // 尝试获取乐观锁
            long stamp = lock.tryOptimisticRead();
            int currentCount = count;
            try {
                TimeUnit.MILLISECONDS.sleep(milli);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 判断是否进入写模式
            if (!lock.validate(stamp)) {
                // 已经进入写模式，就老老实实获取读锁。
                stamp = lock.readLock();
                currentCount = count;
                lock.unlockRead(stamp);
            }
            // 走到这里，说明count还没有被写，那么可以不用加读锁，减少了读锁的开销。
            System.out.println("optimisticRead==" + currentCount);
        });
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        optimisticRead();
        long end = writeLock();
        System.out.println(end - start);
    }
}
