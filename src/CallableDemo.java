import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author lvyue
 * @since 2020/7/23
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread());

        Thread thread1 = new Thread(futureTask, "AA");
        thread1.start();

        Thread thread2 = new Thread(futureTask2, "BB");
        thread2.start();

        System.out.println(Thread.currentThread().getName() + "***************");
        int result01 = 100;
        int result02 = futureTask.get();
        System.out.println("*******result:" + (result01 + result02));
    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("*********come in callable");
        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}

class Aa implements Runnable {

    @Override
    public void run() {

    }
}

class Bb implements Callable<String> {

    @Override
    public String call() throws Exception {
        return null;
    }
}
