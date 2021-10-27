public class PalindromeNumber {
    // https://leetcode.com/problems/palindrome-number/
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0)
                return false;
            if (x == 0)
                return true;
            if (x % 10 == 0)
                return false;
            int t = x;
            long rev = 0;
            while (t > 0) {
                rev += t % 10;
                t /= 10;
                rev *= 10;
            }
            rev /= 10;
            if (rev == x)
                return true;
            return false;
        }
    }
}