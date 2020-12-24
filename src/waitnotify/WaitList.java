package waitnotify;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyue
 * @since 2020/11/15
 */
public class WaitList {

    private static List<String> list = new ArrayList<>();
    public static void add() {
        list.add("anything");
    }

    public static int size() {
        return list.size();
    }
}
