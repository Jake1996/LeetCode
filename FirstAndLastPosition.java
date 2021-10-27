public class FirstAndLastPosition {
    public static void main(String[] args) {
        System.out.println((new Solution()).searchRange(new int[]{5,7,7,8,8,10}, 8));
    }
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            if(nums.length == 0 ) {
                return new int[]{-1,-1};
            }
            int index = helper(nums,0,nums.length-1,target);
            if(index == -1 ) {
                return new int[]{-1,-1};
            }
            int start = index;
            int end = index;
            while(start>0 && nums[start-1]==target) {
                start--;
            }
            while(end<nums.length-1 && nums[end+1]==target) {
                end++;
            }
            return new int[]{start,end};
        }
        public int helper(int[] nums,int start, int end,int target) {
            if(start >= end && nums[start]!=target) return -1;
            int mid = (start+end)/2;
            if(nums[mid]== target) {
                return mid;
            }else if(nums[mid]>target) {
                return helper(nums,start,mid-1,target);
            }else {
                return helper(nums,mid+1,end,target);
            }
        }
    }
}
