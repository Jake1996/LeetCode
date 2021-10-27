import java.util.Arrays;

public class JumpGame5 {
    // https://leetcode.com/problems/jump-game-v/
    class Solution {
        int dp[];

        public int maxJumps(int[] arr, int d) {
            this.dp = new int[arr.length];
            Arrays.fill(this.dp, -1);
            if (arr.length == 0)
                return 0;
            if (arr.length == 1)
                return 1;
            if (arr[0] < arr[1])
                dp[0] = 1;
            if (arr[arr.length - 1] < arr[arr.length - 2])
                dp[arr.length - 1] = 1;
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] <= arr[i + 1] && arr[i] <= arr[i - 1]) {
                    dp[i] = 1;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                helper(i, arr, d);
            }
            int max = 1;
            for (int num : this.dp) {
                max = Math.max(num, max);
            }
            return max;
        }

        public int helper(int i, int[] arr, int d) {
            if (this.dp[i] != -1)
                return this.dp[i];
            int max = 0;
            int j = 0;
            for (j = i + 1; j <= i + d && j < arr.length; j++) {
                if (arr[j] >= arr[i]) {
                    break;
                } else {
                    this.dp[i] = Math.max(this.dp[i], helper(j, arr, d) + 1);
                }
                max = Math.max(max, arr[j]);
            }
            for (j = i - 1; j >= i - d && j >= 0; j--) {
                if (arr[j] >= arr[i]) {
                    break;
                } else {
                    this.dp[i] = Math.max(this.dp[i], helper(j, arr, d) + 1);
                }
                max = Math.max(max, arr[j]);
            }
            return this.dp[i];
        }
    }
}
