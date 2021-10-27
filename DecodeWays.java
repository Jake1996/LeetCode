public class DecodeWays {
    public static void main(String[] args) {
        System.out.print((new Solution()).numDecodings("27"));
    }

    // https://leetcode.com/problems/decode-ways/
    public static class Solution {
        public int numDecodings(String s) {
            int dp[] = new int[s.length()];
            if (s.charAt(0) != '0')
                dp[0] = 1;
            else
                return 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != '0') {
                    dp[i] = dp[i - 1];
                }
                if (isValid(s.substring(i - 1, i + 1))) {
                    if (i - 2 >= 0)
                        dp[i] += dp[i - 2];
                    else
                        dp[i] += 1;
                }
            }
            return dp[s.length() - 1];
        }

        public boolean isValid(String s) {
            int n = Integer.parseInt(s);
            if (n > 9 && n <= 26) {
                return true;
            }
            return false;
        }
    }
}