import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author lvyue
 * @since 2020/7/8
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args) {
    }

    /**
     * 解决方案：
     *      1 new ConcurrentHashMap<>()
     *      2 Collections.synchronizedMap(new HashMap<>())
     */
    public static void mapNotSafe() {
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    public static void setNotSafe() {
        /**
         * 解决方案：
         *      1 Collections.synchronizedSet(new HashSet<>())
         *      2 new CopyOnWriteArraySet<>()
         */
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    public static void listNotSafe() {
        /**
         * 1.故障现象
         *      java.util.ConcurrentModificationException
         *
         * 2.导致原因
         *      并发争抢修改导致。
         *
         * 3.解决方案
         *      3.1 new Vector<>()
         *      3.2 Collections.synchronizedList(new ArrayList<>())
         *      3.3 new CopyOnWriteArrayList<>()----写时复制
         */
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
