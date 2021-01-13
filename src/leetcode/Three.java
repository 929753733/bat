package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author lvyue
 * @since 2021/1/12
 */
public class Three {

    public static void main(String[] args) {

        int a = lengthOfLongestSubstring("abcabcbb");
        System.out.println(a);

    }

    /**
     * 主要思想就是滑动窗口
     */
    public static int lengthOfLongestSubstring(String s) {
        // HashSet记录每个字段是否出现过。
        Set<Character> occ = new HashSet<>();
        int n =  s.length();
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}


