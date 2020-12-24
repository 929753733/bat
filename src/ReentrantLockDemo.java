import sun.security.provider.MD2;

/**
 * @author lvyue
 * @since 2020/12/23
 */
public class ReentrantLockDemo {

    static Object objectLockA = new Object();

    public static void m2() {
        synchronized (objectLockA) {
            System.out.println("-----hello-----");
        }
    }
    

    public static void main(String[] args) {
        m2();
    }
//
//    public static void m1() {
//        new Thread(() -> {
//            synchronized (objectLockA) {
//                System.out.println(Thread.currentThread().getName() + "\t" + "外层调用");
//                synchronized (objectLockA) {
//                    System.out.println(Thread.currentThread().getName() + "\t" + "中层调用");
//                    synchronized (objectLockA) {
//                        System.out.println(Thread.currentThread().getName() + "\t" + "内层调用");
//                    }
//                }
//            }
//        }).start();
//    }

}
