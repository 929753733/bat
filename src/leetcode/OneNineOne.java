package leetcode;

/**
 *191. 位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 *
 * @author lvyue
 */
public class OneNineOne {

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight2(n));

    }

    public static int hammingWeight(int n) {
        int m = 0;
        String a = String.valueOf(n);
        a = "00000000000000000000000000001011";
        if (a.length() > 0) {
            char[] b = a.toCharArray();
            for (int i = 0; i < b.length; i++) {
                if ('1' == b[i]) {
                    m++;
                }
            }
        }
        return m;
    }

    public static int hammingWeight2(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            System.out.println(1 << i);
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

}
