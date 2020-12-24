package waitnotify;

/**
 * @author lvyue
 * @since 2020/11/15
 */
public class WaitRun {

    public static void main(String[] args) {
        try {
            Object lock = new Object();

            WaitThreadA a = new WaitThreadA(lock);
            a.start();

            Thread.sleep(50);

            WaitThreadB b = new WaitThreadB(lock);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
