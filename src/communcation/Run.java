package communcation;

/**
 * @author lvyue
 * @since 2020/11/15
 */
public class Run {

    public static void main(String[] args) {
        CommunicationDemo communicationDemo = new CommunicationDemo();

        ThreadA a = new ThreadA(communicationDemo);
        ThreadB b = new ThreadB(communicationDemo);
        a.start();
        b.start();

    }
}
