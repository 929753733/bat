import java.util.HashMap;

/**
 * @author lvyue
 * @since 2020/12/9
 */
public class TryCatchDemo implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("关闭！！！");
    }

    public void open() {
        System.out.println("打开！！！");
    }
}

class Test {
    public static void main(String[] args) {
        try (TryCatchDemo tryCatchDemo = new TryCatchDemo()) {
            tryCatchDemo.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
