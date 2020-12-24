package proxy;

import java.lang.reflect.Proxy;

/**
 * @author lvyue
 * @since 2020/11/18
 */
public class Client {

    public static void main(String[] args) {
        User user = new User();
        user.setName("张三");
        user.setAge(0);
        UserService us = new UserServiceImpl();
        UserServiceProxy usp = new UserServiceProxy(us);
        UserService proxy = (UserService) Proxy.newProxyInstance(us.getClass().getClassLoader(), us.getClass().getInterfaces(), usp);
        proxy.addUser(user);

    }
}
