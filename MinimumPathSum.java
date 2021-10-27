import java.util.Arrays;

public class MinimumPathSum {
    // https://leetcode.com/problems/minimum-path-sum
    class Solution {
        public int minPathSum(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int dp[][] = new int[n][m];
            for(int i=0;i<n;i++) {
                Arrays.fill(dp[i],-1);
            }
            dp[n-1][m-1] = grid[n-1][m-1];
            return dfs(0,0,dp,grid);
        }
        public int dfs(int i,int j,int[][] dp,int[][] grid) {
            if(dp[i][j]!=-1) {
                return dp[i][j];
            }
            long sum = Integer.MAX_VALUE;
            if(i < dp.length-1)
                sum = Math.min(sum,dfs(i+1,j,dp,grid));
            if(j < dp[0].length-1)
                sum = Math.min(sum,dfs(i,j+1,dp,grid));
            dp[i][j] = (int) sum + grid[i][j];
            return dp[i][j];
        }
    }
}
