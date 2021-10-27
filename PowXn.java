public class PowXn {
    // https://leetcode.com/problems/powx-n/
    class Solution {
        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return x;
            }
            if (n < 0) {
                if (n == Integer.MIN_VALUE) {
                    n = Integer.MAX_VALUE - 1;
                } else {
                    n *= -1;
                }
                return myPow(1 / x, n);
            }
            double result = myPow(x, n / 2);
            result *= result;
            if (n % 2 == 1) {
                result *= x;
            }
            return result;
        }
    }
}
