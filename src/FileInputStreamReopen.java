import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lvyue
 * @since 2020/12/9
 */
public class FileInputStreamReopen {

    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        FileInputStream inputStream = new FileInputStream("E:\\aaa.txt");
        FileOutputStream outputStream = new FileOutputStream("E:\\bbb.txt");
        FileOutputStream outputStream2 = new FileOutputStream("E:\\ccc.txt");
        int len;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }

        if (inputStream.read() == -1) {
            /**
             * 返回此Object的运行时类。 返回的类对象是被表示类的static synchronized方法锁定的对象。
             */
            Class in = inputStream.getClass();
            /**
             * getDeclaredMethod(String name, 类<?>... parameterTypes)
             * 返回一个方法对象，它反映此表示的类或接口的指定声明的方法类对象。
             * name参数是一个String ，它指定了所需方法的简单名称，
             * parameterTypes参数是以声明顺序标识方法的形式参数类型的类对象的数组。
             */
            Method openp = in.getDeclaredMethod("open0", String.class);
            /**
             * 将此对象的accessible标志设置为指示的布尔值。 true的值表示反射对象应该在使用时抑制Java语言访问检查。
             * false的值表示反映的对象应该强制执行Java语言访问检查。
             */
            openp.setAccessible(true);
            /**
             * public Object invoke(Object obj, Object... args)
             * 在具有指定参数的方法对象上调用此方法对象表示的基础方法。 个别参数自动解包以匹配原始形式参数，原始参考参数和参考参数都需要进行方法调用转换。
             * 参数：
             * obj:从底层方法被调用的对象
             * args:用于方法调用的参数
             *
             */
            openp.invoke(inputStream, "E:\\aaa.txt");
        }
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream2.write(bytes, 0, len);
        }
        outputStream.close();
    }
}
