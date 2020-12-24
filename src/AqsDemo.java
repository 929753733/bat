import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvyue
 * @since 2020/10/27
 */
public class AqsDemo implements Lock, Serializable {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Object.class.equals("");
        String.class.equals("");
    }

    private static class Sync extends AbstractQueuedSynchronizer {

        /**
         * 该线程是否正在独占资源。
         */
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        /**
         * 独占方式，尝试获取资源。成功则返回true，失败则返回false。
         */
        @Override
        public boolean tryAcquire(int acquires) {
            assert acquires == 1;
            // 如果通过CAS成功将state由0改为1，说明成功获取到了资源，则返回true。
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int release) {
            assert release == 1;
            /**
             * 既然来释放资源，那getState()肯定是1了。但是这里是进行多一步判断。
             */
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            // 释放资源，放弃占有状态。
            setState(0);
            return true;
        }

    }

    /**
     * 真正同步类的实现都依赖继承于
     */
    private final Sync sync = new Sync();


    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }
}
