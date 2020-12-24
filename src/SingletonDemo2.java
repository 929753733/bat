import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvyue
 * @since 2020/11/24
 */
public class SingletonDemo2 {

    /**
     * 添加volatile防止指令重排。
     */
    private volatile SingletonDemo2 singletonDemo2 = null;

    /**
     * 这里我们使用DCL（Double Check Lock）机制。
     */
    public SingletonDemo2 getInstances() {
        if (null == singletonDemo2) {
            synchronized (SingletonDemo2.class) {
                // 再次检查
                if (null == singletonDemo2) {

                }
            }
        }
        return null;
    }


}
