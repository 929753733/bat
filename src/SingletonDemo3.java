/**
 * @author lvyue
 * @since 2021/1/7
 */
public class SingletonDemo3 {

    private static volatile SingletonDemo3 instance = null;

    public SingletonDemo3 getInstance() {
        if (null == instance) {
            synchronized (SingletonDemo3.class) {
                if (null == instance) {
                    instance = new SingletonDemo3();
                }
            }
        }
        return instance;
    }

}
