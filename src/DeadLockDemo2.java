/**
 * @author lvyue
 * @since 2021/1/7
 */
public class DeadLockDemo2 {

    private static String a = "a";
    private static String b = "b";

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (a) {
                try {
                    Thread.sleep(1000);
                    synchronized (b) {
                        System.out.println("aaa");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            synchronized (b) {
                try {
                    Thread.sleep(1000);
                    synchronized (a) {
                        System.out.println("bbb");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }

}
