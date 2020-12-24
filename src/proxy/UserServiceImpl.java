package proxy;

/**
 * @author lvyue
 * @since 2020/11/18
 */
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) {
        System.out.println("新增用户成功，数据为：" + user.toString());
    }
}
