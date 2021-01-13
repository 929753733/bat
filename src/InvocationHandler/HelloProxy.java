package InvocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lvyue
 * @since 2021/1/7
 */
public class HelloProxy implements InvocationHandler {

    private Object object;
    public HelloProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke" + method.getName());
        method.invoke(object, args);
        System.out.println("Before invoke" + method.getName());
        return null;
    }

    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        InvocationHandlerDemo invocationHandlerDemo = new InvocationHandlerImpl();
        InvocationHandler handler = new HelloProxy(invocationHandlerDemo);
        InvocationHandlerDemo proxyHello = (InvocationHandlerDemo) Proxy.newProxyInstance(invocationHandlerDemo.getClass().getClassLoader(), invocationHandlerDemo.getClass().getInterfaces(), handler);
        proxyHello.sayHello();
    }
}
