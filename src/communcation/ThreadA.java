package communcation;

/**
 * @author lvyue
 * @since 2020/11/15
 */
public class ThreadA extends Thread {

    private CommunicationDemo communicationDemo;

    public ThreadA(CommunicationDemo communicationDemo) {
        this.communicationDemo = communicationDemo;
    }

    @Override
    public void run() {
        super.run();
        communicationDemo.methodA();
    }

}
