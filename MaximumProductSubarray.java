public class MaximumProductSubarray {
    // https://leetcode.com/problems/maximum-product-subarray/
    class Solution {
        public int maxProduct(int[] nums) {
            int temp = 1;
            int max = Integer.MIN_VALUE;
            for(int k : nums) {
                temp*=k;
                max = Math.max(max,temp);
                if(temp == 0) temp=1; 
            }
            temp = 1;
            for(int i=nums.length-1;i>=0;i--) {
                temp*=nums[i];
                max = Math.max(max,temp);
                if(temp == 0) temp=1; 
            }
            return max;
        }
    }
}