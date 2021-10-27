public class ReverseString {
    // https://leetcode.com/problems/reverse-integer/
    class Solution {
        public int reverse(int x) {
            if(x == 0) return 0;
            long reverse = 0;
            int sign = x < 0 ? -1 : 1;
            x = x*sign;
            while(x!=0) {
                reverse*=10;
                reverse+=x%10;
                x/=10;
            }
            if(reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE) return 0;
            return (int)reverse*sign;
            
        }
    }
}
