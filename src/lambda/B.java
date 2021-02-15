package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author lvyue
 * @since 2021/2/15
 */
public class B implements A {

    final static String salutation = "Hello! ";

    @Override
    public String b() {
        return null;
    }

    public static void main(String[] args) {
//        A.show();
//        GreetingService greetingService = message -> System.out.println(salutation + message);
//        greetingService.sayMessage("aaa");

//        Random random = new Random();
//        random.ints().limit(10).forEach(System.out::println);

        // filter方法用于通过设置的条件过滤出元素。
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        long count = strings.stream().filter(s -> s.isEmpty()).count();
        System.out.println(count);
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}
