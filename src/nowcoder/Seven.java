package nowcoder;

/**
 * @author lvyue
 * @since 2021/1/22
 */
public class Seven {

    public static void main(String[] args) {
        int[] prices = {2, 4, 1};
//        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));

    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buyDay;
        int sellDay;
        if (prices.length > 0) {
            int pricesLength = prices.length;
            for (int i = 0; i < pricesLength; i++) {
                for (int j = i + 1; j < pricesLength; j++) {
                    int dayProfit = prices[j] - prices[i];
                    if (dayProfit > profit) {
                        profit = dayProfit;
                        buyDay = i;
                        sellDay = j;
                    }
                }
            }
            return profit;
        } else {
            return 0;
        }
    }
    
    public static int maxProfit2(int[] prices) {
        int minPrice = prices[0];
        int profit = 0;
        if (prices.length > 0) {
            for (int i = 0; i < prices.length; i++) {
                minPrice = Math.min(minPrice, prices[i]);
                profit = Math.max(profit, prices[i] - minPrice);
            }
            return profit;
        } else {
            return 0;
        }
    }
}
