import java.util.Arrays;

public class CoinChange2 {
    // https://leetcode.com/problems/coin-change-2
    class Solution {
        public int change(int amount, int[] coins) {
            Arrays.sort(coins);
            int m = coins.length;
            long arr[][] = new long[amount + 1][m];
            if (amount < coins[0])
                return 1;
            for (int i = 0; i < m; i++) {
                arr[coins[0]][i] = 1;
            }
            for (int i = coins[0]; i <= amount; i += coins[0]) {
                arr[i][0] = 1;
            }
            for (int i = coins[0] + 1; i <= amount; i++) {
                for (int j = 1; j < m; j++) {
                    int k = 0;
                    if (i % coins[j] == 0)
                        arr[i][j]++;
                    while (i - coins[j] * k > 0) {
                        arr[i][j] += arr[i - coins[j] * k][j - 1];
                        k++;
                    }
                }
            }
            return (int) arr[amount][m - 1];
        }
    }
}
