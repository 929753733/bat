package communcation;

/**
 * @author lvyue
 * @since 2020/11/15
 */
public class CommunicationDemo {
    synchronized public void methodA() {
        System.out.println("i am method a");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }

    }

    synchronized public void methodB() {
        System.out.println("i am method b");
    }
}
