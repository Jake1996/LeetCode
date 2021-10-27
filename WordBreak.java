import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        System.out.print((new Solution()).wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                Arrays.asList("aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa",
                        "ba")));
    }

    // https://leetcode.com/problems/word-break/
    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length()];
            HashSet<String> hs = new HashSet<>();
            for (String word : wordDict) {
                hs.add(word);
            }
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; !dp[i] && j <= i; j++) {
                    String cur = s.substring(j, i + 1);
                    if (hs.contains(cur)) {
                        if (j > 0)
                            dp[i] = dp[i] || dp[j - 1];
                        else
                            dp[i] = true;
                    }
                }
            }
            return dp[s.length() - 1];
        }
    }
}
