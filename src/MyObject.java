import java.util.HashMap;

/**
 * @author lvyue
 * @since 2020/10/25
 */
public class MyObject {

    synchronized public void methodA() {
        System.out.println("执行A方法");
    }

    synchronized public void methodB() {
        System.out.println("执行B方法");
    }

}

class ThreadA extends Thread{
    private MyObject myObject;

    @Override
    public void run() {
        super.run();
        myObject.methodA();
    }
}

class ThreadB extends Thread{
    private MyObject myObject;

    @Override
    public void run() {
        super.run();
        myObject.methodB();
    }
}

class Run {

    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        ThreadA threadA = new ThreadA();
    }

}
