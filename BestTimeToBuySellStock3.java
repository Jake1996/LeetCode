public class BestTimeToBuySellStock3 {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
    class Solution {
        public int maxProfit(int[] prices) {
            int fw[] = new int[prices.length];
            int bw[] = new int[prices.length];
            int ans1 = 0, ans2 = 0;
            int min = Integer.MAX_VALUE;
            int max = 0;
            int n = prices.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                } else {
                    ans1 = Math.max(ans1, prices[i] - min);
                }
                if (prices[n - 1 - i] > max) {
                    max = prices[n - 1 - i];
                } else {
                    ans2 = Math.max(ans2, max - prices[n - 1 - i]);
                }
                fw[i] = ans1;
                bw[n - 1 - i] = ans2;
            }
            for (int i = 0; i < fw.length; i++) {
                ans = Math.max(ans, fw[i] + bw[i]);
            }
            return ans;
        }
    }
}