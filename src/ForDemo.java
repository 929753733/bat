/**
 * @author lvyue
 * @since 2020/12/11
 */
public class ForDemo {

    public static void main(String[] args) {
        int a = 0;
        a:for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                a++;
                System.out.println("b");
                if (a == 7) {
                    break a;
                }
            }
            System.out.println("a");
        }
    }
}
