import java.util.ArrayList;

/**
 * @author lvyue
 * @since 2020/8/23
 */
public class HeapTest {

    byte[] a = new byte[1024 * 100];

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> list = new ArrayList<>();
        while (true) {
            list.add(new HeapTest());
            Thread.sleep(20);
        }


    }
}
