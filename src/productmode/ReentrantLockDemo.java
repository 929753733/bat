package productmode;

import sun.security.provider.MD2;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map3 = new HashMap<>();





//        m2();
//
        Lock lock = new ReentrantLock();
//        lock.lock();
//        try {
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
            lock.unlock();
//        }
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
