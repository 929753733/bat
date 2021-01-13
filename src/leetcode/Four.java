package leetcode;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * @author lvyue
 * @since 2021/1/13
 */
public class Four {

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3, 4};
        double dd = findMedianSortedArrays(a, b);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int[] newNum = new int[nums1Length + nums2Length];
        int m = 0;
        int n = 0;
        int r = 0;
        while (m < nums1Length || n < nums2Length) {
            if (nums1.length > 0 && nums2.length > 0) {
                if (nums1[0] < nums2[0]) {
                    newNum[r++] = nums1[0];
                    int[] a = new int[nums1.length - 1];
                    int j = 0;
                    for (int i = 1; i < nums1.length; i++) {
                        a[j++] = nums1[i];
                    }
                    nums1 = a;
                    m++;
                } else {
                    newNum[r++] = nums2[0];
                    int[] a = new int[nums2.length - 1];
                    int j = 0;
                    for (int i = 1; i < nums2.length; i++) {
                        a[j++] = nums2[i];
                    }
                    nums2 = a;
                    n++;
                }
            } else {
                if (m == nums1Length && n < nums2Length) {
                    for (int i = 0; i < nums2.length; i++) {
                        newNum[r++] = nums2[i];
                        n++;
                    }
                }
                if (n == nums2Length && m < nums1Length) {
                    for (int i = 0; i < nums1.length; i++) {
                        newNum[r++] = nums1[i];
                        m++;
                    }
                }
            }
        }

        double dd = 0;
        if (newNum.length % 2 == 0) {
            int aa = newNum.length;
            int bb = (aa + 1) / 2;
            int cc = (aa - 1) / 2;
            dd = (newNum[bb] + newNum[cc]) / 2.0;
        } else {
            int aa = newNum.length;
            int bb = aa / 2;
            dd = newNum[bb];
        }

        return dd;
    }
}
