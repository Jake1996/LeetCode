import java.util.Arrays;

public class StoneGame2 {
    // https://leetcode.com/problems/stone-game-ii/
    class Solution {
        int dp[][];

        public int stoneGameII(int[] piles) {
            int totalSum = 0;
            for (int stone : piles)
                totalSum += stone;
            dp = new int[piles.length][piles.length + 1];
            for (int i = 0; i < piles.length; i++) {
                Arrays.fill(dp[i], -1);
            }
            return helper(0, 1, totalSum, piles);
        }

        public int helper(int start, int m, int remaining, int piles[]) {
            if (start + 2 * m >= piles.length) {
                return remaining;
            }
            if (dp[start][m] != -1) {
                return dp[start][m];
            }
            int otherPerson = Integer.MAX_VALUE;
            int left = remaining;
            for (int i = 1; i <= 2 * m; i++) {
                left -= piles[start + i - 1];
                otherPerson = Math.min(otherPerson, helper(start + i, Math.max(i, m), left, piles));
            }
            dp[start][m] = remaining - otherPerson;
            return dp[start][m];
        }
    }
}
