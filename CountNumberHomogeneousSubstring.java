public class CountNumberHomogeneousSubstring {
    // https://leetcode.com/problems/count-number-of-homogenous-substrings/
    class Solution {
        public int countHomogenous(String s) {
            int i = 0;
            int j = 0;
            long total = 0;
            int mod = 1000000007;
            while (j < s.length()) {
                while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                    j++;
                }
                long length = j - i;
                total = total + (length * (length + 1)) / 2;
                total %= mod;
                i = j;
            }
            return (int) total;
        }
    }
}
