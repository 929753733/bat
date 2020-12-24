package communcation;

/**
 * @author lvyue
 * @since 2020/11/15
 */
public class MyListThreadA extends Thread {

    private MyList list;

    public MyListThreadA(MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                list.add();
                System.out.println("添加了" + (i + 1) + "个元素");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
