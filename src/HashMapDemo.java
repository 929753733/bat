import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyue
 * @since 2020/10/17
 */
public class HashMapDemo {

    public static void main(String[] args) {
        HashMap a = new HashMap();
        a.put("a", "aaa");
        a.put("b", "bbb");
        a.put("a", "ccc");
        String b = (String) a.get("a");
    }
}
