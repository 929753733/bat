/**
 * 字符串常量Java内部加载。
 *
 * @author lvyue
 * @since 2020/12/22
 */
public class StringPoolDemo {
    public static void main(String[] args) {
        String str1 = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());

        System.out.println();

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());

        System.out.println();

        String str3 = new StringBuilder("re").append("dis").toString();
        System.out.println(str3);
        System.out.println(str3.intern());
        System.out.println(str3 == str3.intern());
    }
}
