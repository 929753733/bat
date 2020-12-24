import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author lvyue
 * @since 2020/7/21
 */
public class SemaphoreDemo {

    public static void main(String[] args) {

        // 模拟3个停车位
        Semaphore semaphore = new Semaphore(3);
        // 模拟6部汽车
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 抢到车位");
                    // 暂停一会线程
                    try {
                        TimeUnit.MICROSECONDS.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t 停车3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
