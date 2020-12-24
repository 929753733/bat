package communcation;

/**
 * @author lvyue
 * @since 2020/11/15
 */
public class ThreadB extends Thread {

    private CommunicationDemo communicationDemo;

    public ThreadB(CommunicationDemo communicationDemo) {
        this.communicationDemo = communicationDemo;
    }

    @Override
    public void run() {
        super.run();
        communicationDemo.methodB();
    }
}
