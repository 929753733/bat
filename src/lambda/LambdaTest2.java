package lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author lvyue
 * @since 2021/2/12
 *
 * 口诀：
 * 左右遇一括号省
 * 左侧推断类型省
 */
public class LambdaTest2 {

    /**
     * 无参数，无返回值
     * () -> System.out.println("Hello Lambda");
     */
    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };
        runnable.run();

        System.out.println("---------------------------");

        Runnable runnable1 = () -> System.out.println("Hello Lambda");
        runnable1.run();
    }

    /**
     * 有参数，无返回值。
     * (x) -> System.out.println(x);
     */
    @Test
    public void test2() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("哈哈哈哈哈");
    }

    /**
     * 若只有一个参数，小括号可以省略不写。
     */
    @Test
    public void test3() {
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("哈哈哈哈哈");
    }

    /**
     * 有两个以上的参数，有返回值，并且Lambda体中有多条语句。
     */
    @Test
    public void test4() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    /**
     * 若Lambad体中只有一条语句，return和大括号都可以省略不写。
     */
    @Test
    public void test5() {
       Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
    }

    /**
     * Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出数据类型，即“类型推断”。
     */
    @Test
    public void test6() {
        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);
    }

    public Integer operation(Integer num, MyFun mf) {
        return mf.getValue(num);
    }

    @Test
    public void test7() {
        op(100L, 200L, (x, y) -> x + y);
        op(100L, 200L, (x, y) -> x * y);
    }

    public void op(Long l1, Long l2, MyFun2<Long, Long> mf) {
        System.out.println(mf.getValue(l1, l2));
    }
}
