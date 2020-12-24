import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lvyue
 * @since 2020/7/6
 */
public class VolatileDemo {

    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            }, String.valueOf(i)).start();
        }

        /**
         * 默认有两个线程是一直存在的，一个是主线程，另外一个GC线程，如果当前线程的数量大于2时，就会进入就绪状态，让其他线程执行。
         */
        while (Thread.activeCount() > 2) {
            /**
             * Thread.yield()方法，使当前线程由执行状态，变为就绪状态，让出cpu时间，让其他线程执行。
             */
            Thread.yield();
        }
        System.out.println(myData.number);
        System.out.println(myData.atomicInteger);
    }

    /**
     * volatile可以保证可见性，及时通知其他线程，主物理内存的值已经被修改。
     */
    public static void seeOkByVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTO60();
            System.out.println(Thread.currentThread().getName() + "\t update number value:" + myData.number);
        }, "AAA").start();

        while (myData.number == 0) {

        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over, main get number value:" + myData.number);
    }
}

class MyData {
    /**
     * volatile增强可见性，主内存的数值发生变化时，会立即使工作内存失效并且刷新。
     */
    volatile int number = 0;

    public void addTO60() {
        this.number = 60;
    }

    public synchronized void addPlusPlus() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}
