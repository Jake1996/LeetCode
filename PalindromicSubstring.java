public class PalindromicSubstring {
    // https://leetcode.com/problems/palindromic-substrings/
    class Solution {
        public int countSubstrings(String s) {
            int count = 1;
            boolean pal[][] = new boolean[s.length() + 1][s.length() + 1];
            pal[0][0] = true;
            for (int i = 1; i < s.length(); i++) {
                pal[i][i] = true;
                count++;
                if (s.charAt(i) == s.charAt(i - 1)) {
                    count++;
                    pal[i - 1][i] = true;
                }
            }
            for (int k = 3; k <= s.length(); k++) {
                for (int i = 0; i < s.length() - k + 1; i++) {
                    int j = i + k - 1;
                    if (s.charAt(i) == s.charAt(j) && pal[i + 1][j - 1]) {
                        pal[i][j] = true;
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
