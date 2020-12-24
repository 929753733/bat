package waitnotify;

import communcation.MyList;
import communcation.Run;

/**
 * @author lvyue
 * @since 2020/11/15
 */
public class WaitThreadB extends Thread {

    private Object lock;

    public WaitThreadB(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        try {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    WaitList.add();
                    if (WaitList.size() == 5) {
                        lock.notify();
                        System.out.println("已经发出了通知");
                    }
                    System.out.println("添加了" + (i + 1) + "个元素！");
                    Thread.sleep(1000);
                    System.out.println("b over");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
