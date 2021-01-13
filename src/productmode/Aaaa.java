package productmode;

import java.util.HashSet;
import java.util.Properties;

/**
 * @author lvyue
 * @since 2021/1/12
 */
public class Aaaa {

    public static void main(String[] args) {
//        String a = "aaa";
//        String b = "bbb";
//        System.out.println(a.equals(b));
        HashSet hashSet = new HashSet();
        hashSet.add("aaa");
        hashSet.add("aaa");

    }

    public static void bbb() {
        // 获得所有系统属性
        Properties properties = System.getProperties();

        // 查看启动类加载器加载了什么
        String property = properties.getProperty("sun.boot.class.path");
        String[] split = property.split(";");
        for (String string : split) {
            System.out.println(string);
        }

        System.out.println("-------------------伟大的分割线----------------------");

        // 查看扩展类加载器加载了什么
        String property1 = properties.getProperty("java.ext.dirs");
        String[] split1 = property1.split(";");
        for (String string : split1) {
            System.out.println(string);
        }

        System.out.println("-------------------伟大的分割线----------------------");

        // 查看应用程序类加载器加载了什么
        String property2 = properties.getProperty("java.class.path");
        String[] split2 = property2.split(";");
        for (String string : split2) {
            System.out.println(string);
        }
    }
}


