package singleton;

import single.Singleton1;

/**
 * @author lvyue
 * @since 2020/11/28
 */
/**
 * 饿汉模式。
 */
public class SingletonDemo1 {

    private final static SingletonDemo1 INSTANCE = new SingletonDemo1();

    /**
     * 将该类的构造方法私有化，则其他地方就无法通过该构造方法来实例化对象，
     * 只能通过此类提供的静态方法获取实例。
     */
    private SingletonDemo1() {

    }

    public static SingletonDemo1 getInstance() {
        return INSTANCE;
    }
}
