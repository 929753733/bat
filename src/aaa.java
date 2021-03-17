import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;

/**
 * @author lvyue
 * @since 2021/2/1
 */
public class aaa {
    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String dateString = formatter.format(DateUtil.now());
        String now = DateUtil.today();
        System.out.println(now);
//        System.out.println(dateString);
    }
}
