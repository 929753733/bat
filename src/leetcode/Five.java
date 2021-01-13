package leetcode;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * @author lvyue
 * @since 2021/1/13
 */
public class Five {

    public static void main(String[] args) {
        String d = longestPalindrome("aacabdkacaa");
        System.out.println(d);

    }

    public static String longestPalindrome(String s) {
        int x = 0;
        int y = 0;
        int num = 0;
        if (s.length() > 0) {
            int strLength = s.length();
            for (int i = 0; i < strLength; i++) {
                Character a = s.charAt(i);
                for (int j = i + 1; j < strLength; j++) {
                    Character b = s.charAt(j);
                    if (a.equals(b)) {
                        int c = j - i;
                        if (c > num) {
                            String dd = s.substring(i, j+ 1);
                            // 通过字符反转来判断是不是回文子串。
                            String ee = new StringBuffer(dd).reverse().toString();
                            if (dd.equals(ee)) {
                                x = i;
                                y = j;
                                num = c;
                            }
                        }
                    }
                }
            }
        }
        String d = s.substring(x, y + 1);
        return d;
    }
}
