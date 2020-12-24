package communcation;

/**
 * @author lvyue
 * @since 2020/11/15
 */
public class MyListThreadB extends Thread {

    private MyList list;

    public MyListThreadB(MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                if (list.size() == 5) {
                    System.out.println("==5，线程b准备退出了");
                    throw new InterruptedException();
                } else {
                    System.out.println("不等于5");
                }
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
