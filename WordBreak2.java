import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak2 {
    public static void main(String[] args) {
        System.out.print((new Solution()).wordBreak("catsanddog",
        Arrays.asList(new String[]{"cat","cats","and","sand","dog"})
        ));
    }
    // https://leetcode.com/problems/word-break-ii/
    static class Solution {
        List<String> ans;
        HashSet<String> hs;

        public List<String> wordBreak(String s, List<String> wordDict) {
            ans = new ArrayList<>();
            hs = new HashSet<>();
            hs = new HashSet<>();
            for (String word : wordDict) {
                hs.add(word);
            }

            helper(0, "", s);
            return ans;
        }

        public void helper(int i, String prev, String s) {
            if (i == s.length()) {
                ans.add(prev.trim());
                return;
            }
            for (int j = i; j < s.length(); j++) {
                if (hs.contains(s.substring(i, j + 1))) {
                    helper(j + 1, prev + " " + s.substring(i, j + 1), s);
                }
            }   
        }
    }
}
