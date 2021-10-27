import java.util.ArrayList;

public class PerfectSquares {
    // https://leetcode.com/problems/perfect-squares/
    class Solution {
        ArrayList<Integer> squares;

        public int numSquares(int n) {
            this.squares = new ArrayList<>();
            for (int i = 1; i * i <= n; i++) {
                this.squares.add(i * i);
            }
            int dp[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = i;
                int min = Integer.MAX_VALUE;
                for (int j = 1; j < this.squares.size() && this.squares.get(j) <= i; j++) {
                    min = Math.min(min, dp[i - this.squares.get(j)] + 1);
                }
                dp[i] = Math.min(dp[i], min);
            }
            return dp[n];
        }
    }
}
