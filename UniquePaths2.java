import java.util.Arrays;

public class UniquePaths2 {
    // https://leetcode.com/problems/unique-paths-ii/
    class Solution {
        int dp[][];

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int n = obstacleGrid.length;
            int m = obstacleGrid[0].length;
            if (obstacleGrid[n - 1][m - 1] == 1 || obstacleGrid[0][0] == 1)
                return 0;
            if (n == 1 && m == 1)
                return 1;

            dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }
            helper(0, 0, obstacleGrid);
            return this.dp[0][0];
        }

        public int helper(int i, int j, int[][] obstacleGrid) {
            int n = obstacleGrid.length;
            int m = obstacleGrid[0].length;
            if (i >= n || j >= m)
                return 0;
            if (dp[i][j] != -1)
                return dp[i][j];
            if ((i == n - 2 && j == m - 1) || (i == n - 1 && j == m - 2)) {
                dp[i][j] = 1;
                return dp[i][j];
            }
            int right = 0;
            int down = 0;
            if (j < m - 1 && obstacleGrid[i][j + 1] == 0) {
                right = helper(i, j + 1, obstacleGrid);
            }
            if (i < n - 1 && obstacleGrid[i + 1][j] == 0) {
                down = helper(i + 1, j, obstacleGrid);
            }
            dp[i][j] = right + down;
            return dp[i][j];
        }
    }
}