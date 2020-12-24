package proxydemo;

/**
 * @author lvyue
 * @since 2020/12/11
 */
public class Hello implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }

    @Override
    public void sayGoodBay() {
        System.out.println("goodbay!");
    }
}
