package single;

/**
 * @author lvyue
 * @since 2020/8/16
 */
public class Test {

    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.INSTANCE;
        Singleton1 singleton2 = Singleton1.INSTANCE;
        System.out.println(singleton1 == singleton2);
    }
}
