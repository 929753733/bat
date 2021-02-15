package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author lvyue
 * @since 2021/2/13
 */
public class LambdaTest3 {

    /**
     * Consumer<T>消费型接口
     */
    @Test
    public void test1() {
        happy(10000L, x -> System.out.println( x + "元"));
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    /**
     * Supplier<T>供给型接口
     */
    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer num : numList) {
            System.out.println(num);
        }
    }

    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

    /**
     * Function<T, R>函数型接口
     */
    @Test
    public void test3() {
        String newStr = strHandler("\t\t\t 哈哈哈哈哈哈  ", (x) -> x.trim());
        System.out.println(newStr);

    }

    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    /**
     * Predicate<T>断言型接口
     */
    @Test
    public void test4() {
        List<String> list = Arrays.asList("Hello", "atguigu", "lambda", "www", "ok");
        List<String> strList = filterStr(list, x -> x.length() > 3);
        for (String str : strList) {
            System.out.println(str);
        }
    }

    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }

    /**
     * 数组引用
     */
    @Test
    public void test5() {
        Function<Integer, String[]> fun = (x) -> new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);
        System.out.println("---------------------");
        Function<Integer, String[]> fun2 = String[]::new;
        String[] strs2 = fun2.apply(20);
        System.out.println(strs2.length);
    }

}
