package singleton;

/**
 * 单例模式-静态内部类模式。
 *
 * @author lvyue
 * @since 2020/11/29
 */
public class SingletonDemo3 {

    private SingletonDemo3() {
    }

    private static class SingleTonHolder {
        private static SingletonDemo3 INSTANCE = new SingletonDemo3();
    }

    public static SingletonDemo3 getInstance() {
        return SingleTonHolder.INSTANCE;
    }

}
