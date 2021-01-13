package leetcode;

/**
 * 1.两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 *
 * @author lvyue
 * @since 2021/1/11
 */
public class One {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = sum(nums, target);
        if (result.length > 0) {
            for (int res : result) {
                System.out.println(res);
            }
        }
    }

    public static int[] sum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = (i + 1); j < nums.length; j++) {
                    int sum = nums[i] + nums[j];
                    if (sum == target) {
                        result[0] = i;
                        result[1] = j;
                        break;
                    } else {
                        continue;
                    }
                }
            }
        }
        return result;
    }

}
