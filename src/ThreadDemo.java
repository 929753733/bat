/**
 * @author lvyue
 * @since 2020/7/23
 */
public class ThreadDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("aaa");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo());
        thread.start();

        new Thread(() -> {

        }, "A").start();
    }
}
