public class LongestPalandromicSubstring {
    // https://leetcode.com/problems/longest-palindromic-substring/
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            String maxS = "";
            if (s.length() == 0 || s.length() == 1) {
                return s;
            }
            boolean pal[][] = new boolean[n][n];
            for (int i = 0; i < n - 1; i++) {
                pal[i][i] = true;
                if (s.charAt(i) == s.charAt(i + 1)) {
                    pal[i][i + 1] = true;
                    maxS = "" + s.charAt(i) + s.charAt(i + 1);
                }
            }
            pal[n - 1][n - 1] = true;
            if (maxS.length() == 0) {
                maxS = "" + s.charAt(0);
            }
            for (int k = 3; k <= n; k++) {
                for (int i = 0; i < n - k + 1; i++) {
                    int j = i + k - 1;
                    if (pal[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                        pal[i][j] = true;
                        maxS = s.substring(i, j + 1);
                    }
                }
            }
            return maxS;
        }
    }
}