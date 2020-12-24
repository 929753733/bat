package single;

/**
 * @author lvyue
 * @since 2020/8/16
 */
public class Singleton4 {
    private static Singleton4 instance;
    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if (null == instance) {
            instance = new Singleton4();
        }
        return instance;
    }
}
