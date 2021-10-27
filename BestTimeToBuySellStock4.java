public class BestTimeToBuySellStock4 {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices.length < 2)
                return 0;
            int profit[][] = new int[k + 1][prices.length + 1];
            for (int i = 1; i <= k; i++) {
                int curProfit = -1 * prices[0];
                for (int j = 1; j <= prices.length; j++) {
                    curProfit = Math.max(curProfit, profit[i - 1][j - 1] - prices[j - 1]);
                    profit[i][j] = Math.max(profit[i][j - 1], curProfit + prices[j - 1]);
                }
            }
            return profit[k][prices.length];
        }
    }
}