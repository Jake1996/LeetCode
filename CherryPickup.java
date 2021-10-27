import java.util.Arrays;

public class CherryPickup {
    // https://leetcode.com/problems/cherry-pickup/
    class Solution {
        int dp[][][];
        int MIN = -99999;

        public int cherryPickup(int[][] grid) {
            int n = grid.length;
            dp = new int[n][n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(dp[i][j], MIN);
                }
            }
            return Math.max(0, dp(0, 0, 0, grid));
        }

        public int dp(int r1, int c1, int c2, int[][] grid) {
            int r2 = r1 + c1 - c2;
            int n = grid.length;
            if (r1 == n || r2 == n || c1 == n || c2 == n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
                return MIN;
            }
            if (r1 == n - 1 && c1 == n - 1)
                return grid[r1][c1];
            if (this.dp[r1][c1][c2] != MIN)
                return this.dp[r1][c1][c2];
            int ans = grid[r1][c1];
            if (c1 != c2)
                ans += grid[r2][c2];
            ans += Math.max(Math.max(dp(r1 + 1, c1, c2, grid), dp(r1, c1 + 1, c2, grid)),
                    Math.max(dp(r1, c1 + 1, c2 + 1, grid), dp(r1 + 1, c1, c2 + 1, grid)));
            this.dp[r1][c1][c2] = ans;
            return ans;
        }
    }
}
