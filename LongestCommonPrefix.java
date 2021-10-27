public class LongestCommonPrefix {
    // https://leetcode.com/problems/longest-common-prefix/
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String out = "";
            boolean c = true;
            int j = 0;
            while (c) {
                if (j >= strs[0].length()) {
                    c = false;
                    break;
                }
                char ch = strs[0].charAt(j);
                for (int i = 0; i < strs.length; i++) {
                    if (j >= strs[i].length() || strs[i].charAt(j) != ch) {
                        c = false;
                        break;
                    }
                }
                j++;
                if (c)
                    out = out + ch;
            }
            return out;
        }
    }
}
