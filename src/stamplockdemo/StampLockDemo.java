package stamplockdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * 此demo实现的是传统的读写锁的读锁和写锁，这与ReentranReadWriteLocak读写的效果是一样的。
 * 读锁会占用锁，会阻塞写入的操作。
 */
/**
 * @author lvyue
 * @since 2020/11/28
 */
public class StampLockDemo {

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

    // 这是悲观读锁
    private static void readLock() {
        service.submit(() -> {
            int currentCount = 0;
            long stamp = lock.readLock();
            try {
                currentCount = count;
                TimeUnit.MILLISECONDS.sleep(milli);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(stamp);
            }
            System.out.println("readLock==" + currentCount);
        });
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        readLock();
        long end = writeLock();
        System.out.println(end - start);
    }
}
