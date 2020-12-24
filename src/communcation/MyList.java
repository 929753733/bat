package communcation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyue
 * @since 2020/11/15
 */
public class MyList {

    private List<String> list = new ArrayList<>();
    public void add() {
        list.add("elements");
    }

    public int size() {
        return list.size();
    }
}
