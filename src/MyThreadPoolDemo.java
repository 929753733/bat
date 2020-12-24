import java.util.Hashtable;
import java.util.concurrent.*;

/**
 * 线程池。
 * public ThreadPoolExecutor(int corePoolSize,// 线程池中的常驻核心线程数
 *                           int maximumPoolSize,// 线程池中能够容纳同时执行的最大线程数，此值必须大于1.
 *                           long keepAliveTime,// 多余的空闲线程的存活时间。
 *                           TimeUnit unit,// keepAliveTime的单位。
 *                           BlockingQueue<Runnable> workQueue,// 任务队列，被提交但尚未被执行的任务。
 *                           ThreadFactory threadFactory,// 表示生成线程池中工作线程的线程工厂，用于创建线程，一般用默认的即可。
 *                           RejectedExecutionHandler handler// 拒绝策略，表示当队列满了并且工作线程大于等于线程池的最大线程数。
 *                        ) {
 *         if (corePoolSize < 0 ||
 *             maximumPoolSize <= 0 ||
 *             maximumPoolSize < corePoolSize ||
 *             keepAliveTime < 0)
 *             throw new IllegalArgumentException();
 *         if (workQueue == null || threadFactory == null || handler == null)
 *             throw new NullPointerException();
 *         this.acc = System.getSecurityManager() == null ?
 *                 null :
 *                 AccessController.getContext();
 *         this.corePoolSize = corePoolSize;
 *         this.maximumPoolSize = maximumPoolSize;
 *         this.workQueue = workQueue;
 *         this.keepAliveTime = unit.toNanos(keepAliveTime);
 *         this.threadFactory = threadFactory;
 *         this.handler = handler;
 *     }
 *
 * @author lvyue
 * @since 2020/7/23
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        // ExecutorService service = Executors.newCachedThreadPool();
        ExecutorService threadPool = new ThreadPoolExecutor(2, 5, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 1; i <= 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 办理业务！");
            });
        }
    }

    public static void threadPoolInit() {
        System.out.println(Runtime.getRuntime().availableProcessors());

        // 一池5个处理线程（执行长期的任务，性能好很多）
        // ExecutorService threadPool = Executors.newFixedThreadPool(5);

        // 一池1个处理线程（一个任务一个任务执行的场景）
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        // 一池N个处理线程（适用于执行很多短期异步的小程序或者负载较轻的服务器）
//        ExecutorService threadPool = Executors.newCachedThreadPool();

        for (int i = 1; i <= 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 办理业务！");
            });
        }
    }
}
