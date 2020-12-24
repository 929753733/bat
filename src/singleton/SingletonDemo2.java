package singleton;

import sun.security.jca.GetInstance;

/**
 * @author lvyue
 * @since 2020/11/28
 */
public class SingletonDemo2 {

    private static SingletonDemo2 INSTANCE = null;

    private SingletonDemo2() {

    }

    // DCL机制（双端检索机制）
    public static SingletonDemo2 getInstance() {
        if (null == INSTANCE) {
            synchronized (SingletonDemo2.class) {
                if (null == INSTANCE) {
                    INSTANCE = new SingletonDemo2();
                }
            }
        }
        return INSTANCE;
    }
}
