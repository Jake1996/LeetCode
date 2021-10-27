public class StoneGame3 {
    public static void main(String[] args) {
        System.out.print((new Solution()).stoneGameIII(new int[] { 1, 2, 3, 7 }));
    }

    // https://leetcode.com/problems/stone-game-iii/
    static class Solution {
        int dp[];

        public String stoneGameIII(int[] stoneValue) {
            dp = new int[stoneValue.length];
            int total = 0;
            for (int i = 0; i < stoneValue.length; i++) {
                dp[i] = -1;
                total += stoneValue[i];
            }
            dp[dp.length - 1] = stoneValue[dp.length - 1];
            helper(0, total, stoneValue);
            int alice = dp[0];
            if (alice > total - alice) {
                return "Alice";
            } else if (alice < total - alice) {
                return "Bob";
            }
            return "Tie";
        }

        public int helper(int start, int remaining, int[] stoneValue) {
            if (start >= stoneValue.length)
                return 0;
            if (start == stoneValue.length - 1) {
                return remaining;
            }

            if (dp[start] != -1)
                return dp[start];
            int otherPerson = Integer.MAX_VALUE;
            int currentPerson = stoneValue[start];
            if (start + 1 <= stoneValue.length)
                otherPerson = Math.min(otherPerson, helper(start + 1, remaining - currentPerson, stoneValue));
            if (start + 2 <= stoneValue.length) {
                currentPerson += stoneValue[start + 1];
                otherPerson = Math.min(otherPerson, helper(start + 2, remaining - currentPerson, stoneValue));
            }
            if (start + 3 <= stoneValue.length) {
                currentPerson += stoneValue[start + 2];
                otherPerson = Math.min(otherPerson, helper(start + 3, remaining - currentPerson, stoneValue));
            }
            if (otherPerson != Integer.MAX_VALUE)
                dp[start] = remaining - otherPerson;
            return dp[start];
        }
    }
}
