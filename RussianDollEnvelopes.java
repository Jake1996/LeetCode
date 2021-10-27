import java.util.Arrays;

public class RussianDollEnvelopes {
    // https://leetcode.com/problems/russian-doll-envelopes/
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (c1, c2) -> {
                if (c1[0] != c2[0])
                    return c1[0] - c2[0];
                return c1[1] - c2[1];
            });
            int[] dp = new int[envelopes.length];
            Arrays.fill(dp, 1);
            for (int i = 0; i < envelopes.length; i++) {
                for (int j = i + 1; j < envelopes.length; j++) {
                    if (fits(envelopes, i, j)) {
                        dp[j] = Math.max(dp[j], dp[i] + 1);
                    }
                }
            }
            int max = 0;
            for (int t : dp) {
                max = Math.max(max, t);
            }
            return max;
        }

        public boolean fits(int[][] envelopes, int i, int j) {
            if (envelopes[i][0] < envelopes[j][0] && envelopes[i][1] < envelopes[j][1])
                return true;
            return false;
        }
    }
}
