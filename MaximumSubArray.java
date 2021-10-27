public class MaximumSubArray {
    public static void main(String[] args) {
        System.out.println((new Solution()).maxSubArray(new int[]{-2,-1}));
    }
    // https://leetcode.com/problems/maximum-subarray/
    public static class Solution {
        public int maxSubArray(int[] nums) {
            int i=0;
            int j=0;
            int sum = 0;
            int max = Integer.MIN_VALUE;
            for(int k : nums) {
                max = Math.max(max,k);
            }
            while(j<nums.length) {
                if(sum < 0) {
                    sum-=nums[i++];
                }else {
                    sum+=nums[j++];
                }
                if(i!=j)
                max = Math.max(max,sum);
            }
            return max;
        }
    }
}
