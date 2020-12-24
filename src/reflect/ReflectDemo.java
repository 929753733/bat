package reflect;

import java.lang.reflect.Method;

/**
 * @author lvyue
 * @since 2020/11/22
 */
public class ReflectDemo {

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("java.lang.String");
            String aaa = (String) clazz.newInstance();
            try {
                Method method = clazz.getMethod("equals");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
