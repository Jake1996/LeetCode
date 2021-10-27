public class MinSwapsBalancedString {
    class Solution {
        public int minSwaps(String s) {
             int result = 0;
            int left = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '[') {
                    left++;
                } else {
                    if (left > 0) {
                        left--;
                    } else {
                        //we have additional left bracket after swapping
                        left++;
                        result++;
                    }
                }
            }
            return result;
        }
    }
}
