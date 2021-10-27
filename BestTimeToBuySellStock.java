public class BestTimeToBuySellStock {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock
    class Solution {
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE;
            int ans = 0;
            for(int i=0;i<prices.length;i++) {
                if(prices[i]<min) {
                    min = prices[i];
                }else {
                    ans = Math.max(ans,prices[i]-min);
                }
            }
            return ans;
        }
    }
}