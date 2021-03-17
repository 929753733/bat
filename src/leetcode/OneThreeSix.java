package leetcode;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？（这也就是说我们采用遍历、HashMap等的运算就不被允许了）
 *
 * @author lvyue
 * @since 2021/3/17
 */
public class OneThreeSix {

    /**
     * 对于以上问题，可以使用位运算--异或。
     * 异或运算有以下三个性质：
     * 1.任何数和0做异或运算，结果仍然是原来的数，即a ^ 0 = a。
     * 2.任何数和其自身做异或运算，结果是0，即a ^ a = 0。
     * 3.异或运算满足交换律和结合律，即a ^ b ^ a = b ^ a ^ a = b ^ ( a ^ a ) = b ^ 0 = b。
     */

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        int single = singleNumber(nums);
        System.out.println(single);
    }

    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }


}
