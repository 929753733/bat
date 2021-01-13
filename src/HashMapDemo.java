import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyue
 * @since 2020/10/17
 */
public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>(4);
        String a = (String) hashMap.put("1", "1");
        String b = (String) hashMap.put("2", "2");
        String c = (String) hashMap.put("3", "3");
        String d = (String) hashMap.put("4", "4");
        String e = (String) hashMap.put("1", "5");
        String f = (String) hashMap.put("2", "6");
        String g = (String) hashMap.put("7", "7");
        String h = (String) hashMap.put("8", "8");
    }
}
