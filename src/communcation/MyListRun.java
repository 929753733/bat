package communcation;

/**
 * @author lvyue
 * @since 2020/11/15
 */
public class MyListRun {

    public static void main(String[] args) {
        MyList service = new MyList();

        MyListThreadA a = new MyListThreadA(service);
        a.setName("A");
        a.start();

        MyListThreadB b = new MyListThreadB(service);
        b.setName("B");
        b.start();
    }
}
