public class JoinDemo extends Thread {
    int i;
    /**
     * 上一个线程
     */
    Thread previousThread;

    public JoinDemo(Thread previousThread, int i) {
        this.previousThread = previousThread;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            // 调用上一个线程的join方法，大家可以自己演示的时候可以把这行代码注释掉
            previousThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("num:" + i);
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread previousThread = Thread.currentThread();
//        for (int i = 0; i < 10; i++) {
//            JoinDemo joinDemo = new JoinDemo(previousThread, i);
//            joinDemo.start();
//            previousThread = joinDemo;
////            System.out.println("aaa");
//        }
//        Thread.sleep(3000);
//        System.out.println("bbb");

        Thread t1 = new Thread(() -> {

            try {
                Thread.sleep(2000);
                System.out.println("aaa");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
                System.out.println("bbb");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");
        t2.start();

    }
}
