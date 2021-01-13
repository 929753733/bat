/**
 * @author lvyue
 * @since 2021/1/7
 */
public enum SingletonEnumDemo {

    /**
     * 实例。
     */
    INSTANCE;

    public void doSomething() {
        System.out.println("aaa");
    }

    public static void main(String[] args) {
        SingletonEnumDemo.INSTANCE.doSomething();
    }
}
