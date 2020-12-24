package vector;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author lvyue
 * @since 2020/11/17
 */
public class Vectordemo {

    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.addElement("a");
        vector.addElement("b");
        vector.addElement("c");

        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            String val = enumeration.nextElement();
            if ("b".equals(val)) {
                vector.addElement("d");
            }
            System.out.println(val);
        }
    }

}
