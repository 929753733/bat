/**
 * @author lvyue
 * @since 2020/12/8
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("main");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                ThreadLocal threadLocal1 = new ThreadLocal();
                threadLocal1.set("eeeeee");
                threadLocal1.set("33333");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "--" + threadLocal1.get());
            }).start();
        }
        System.out.println(Thread.currentThread().getName() + "--" + threadLocal.get());
    }
}
