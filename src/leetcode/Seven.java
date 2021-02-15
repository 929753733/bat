package leetcode;

/**
 * @author lvyue
 * @since 2021/1/23
 */
public class Seven {

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(1234 / 10);

        System.out.println(reverse2(-2147483648));
    }

    public static int reverse(int x) {
        String a;
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            a = String.valueOf(- x);
        } else {
            a = String.valueOf(x);
        }
        StringBuffer stringBuffer = new StringBuffer(a);
        String b = stringBuffer.reverse().toString();
        Double c = Double.valueOf(b);
        if (c > Integer.MAX_VALUE) {
            return 0;
        } else {
            if (x < 0) {
                return (- Integer.valueOf(b));
            } else {
                return Integer.valueOf(b);
            }
        }
    }

    public static int reverse2(int x) {
        int ans = 0;
        while (x != 0) {
            int b = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && b > 7)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && b < 8)) {
                return 0;
            }
            ans = ans * 10 + b;
            x /= 10;
        }
        return ans;
    }
}
