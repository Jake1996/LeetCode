public class StringToInteger {
    // https://leetcode.com/problems/string-to-integer-atoi/
    class Solution {
        public int myAtoi(String s) {
            long num = 0;
            boolean neg = false;
            int sign = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ' && sign == 0) {
                    continue;
                } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + (s.charAt(i) - '0');
                    sign = 1;
                    if (num > Integer.MAX_VALUE)
                        return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                } else if (s.charAt(i) == '+' && sign == 0) {
                    neg = false;
                    sign = 1;
                } else if (s.charAt(i) == '-' && sign == 0) {
                    neg = true;
                    sign = 1;
                } else
                    break;
            }
            return neg ? -(int) num : (int) num;
        }
    }
}
