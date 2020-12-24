import java.util.Random;

/**
 * @author lvyue
 * @since 2020/7/29
 */
public class HelloGC {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("******HelloGC");
        try {
            String str = "inspur";
            while (true) {
                str += str + new Random().nextInt(77777777) + new Random().nextInt(88888888);
                str.intern();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
//        Thread.sleep(Integer.MAX_VALUE);
    }
}
