package waitnotify;

/**
 * @author lvyue
 * @since 2020/11/15
 */
public class WaitThreadA extends Thread {

    private Object lock;

    public WaitThreadA(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        try {
            synchronized (lock) {
                if (WaitList.size() != 5) {
                    System.out.println("wait begin");
                }
                lock.wait();
                System.out.println("wait end");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
