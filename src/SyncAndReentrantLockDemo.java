import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronized和Lock有什么区别？用新的Lock有什么好处？
 * 1.原始构成
 *  sychronized     是关键字，属于JVM层面。
 *                      monitorenter（底层是通过monitorenter对象来完成，其实wait/notify等方法也依赖于monitor对象，只有在同步块或者同步方法中才能调用wait/notify等方法）。
 *                      monitorexit
 *  Lock            是具体类（java.util.concurrent.locks.lock）是api层面的锁。
 * 2.使用方法
 *  synchronized    不需要用户去手动释放锁，当synchronized代码执行完后系统会自动让线程释放对锁的占用。
 *  lock            需要用户去手动释放锁，若没有主动释放锁，就有可能导致会出现死锁的现象。需要lock()和unlock()方法配合try/finally语句块来使用。
 * 3.等待是否可中断
 *  synchronized    不可中断，除非抛出异常或者正常运行完成。
 *  lock            可中断，（1）设置超时方法tryLock(long timeout, TimeUnit unit)
 *                         (2)lockInterruptibly()放代码块中，调用interrupt()方法可中断。
 * 4.加锁是否公平
 *  synchronized    非公平锁
 *  lock            两者都可以，默认公平锁。构造方法可以传入boolean值，true为公平锁，false为非公平锁。
 * 5.锁绑定多个条件Condition
 *  synchronized    没有
 *  lock            用来实现分组唤醒需要唤醒的线程们，可以精确唤醒，而不是像synchronized要么随机唤醒一个线程，要么唤醒全部线程。
 *
 * @author lvyue
 * @since 2020/7/22
 */
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print5();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print10();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print15();
            }
        }, "C").start();
    }
}

class ShareResource {

    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            // 判断
            while (number != 1) {
                c1.await();
            }
            // 干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 通知（唤醒）
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            // 判断
            while (number != 2) {
                c2.await();
            }
            // 干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 通知（唤醒）
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            // 判断
            while (number != 3) {
                c3.await();
            }
            // 干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 通知（唤醒）
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
