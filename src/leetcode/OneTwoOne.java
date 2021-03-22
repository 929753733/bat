package leetcode;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author lvyue
 * @since 2021/3/18
 */
public class OneTwoOne {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        /**
         * 我们只需要遍历价格数组一遍，记录历史最低点，然后在每一天考虑这么一个问题：如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？
         * 比如我在今天，我只需要考虑的是今天之前的最低点，今天之后的价格我们不需要进行考虑。
         * 就这样我们一直记录最低点的价格和最大的利润就行了。
         */
        // 购入的最低价格
        int minPrice = Integer.MAX_VALUE;
        // 最大利润
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

}
