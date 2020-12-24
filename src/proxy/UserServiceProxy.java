package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lvyue
 * @since 2020/11/18
 */
public class UserServiceProxy implements InvocationHandler {
    private Object realObj;

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        if (objects != null && objects.length > 0 && objects[0] instanceof User) {
            User user = (User) objects[0];
            if (user.getAge() <= 0) {
                throw new RuntimeException("用户年龄不符合");

            }
        }
        Object ret = method.invoke(realObj, objects);
        return ret;
    }

    public Object getRealObj() {
        return realObj;
    }

    public void setRealObj(Object realObj) {
        this.realObj = realObj;
    }

    @Override
    public String toString() {
        return "UserServiceProxy{" +
                "realObj=" + realObj +
                '}';
    }

    public UserServiceProxy(Object realObj) {
        super();
        this.realObj = realObj;
    }
}
