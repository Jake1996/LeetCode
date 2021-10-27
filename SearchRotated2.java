public class SearchRotated2 {
    // https://leetcode.com/problems/search-in-rotated-sorted-array-ii
    class Solution {
        public boolean search(int[] nums, int target) {
            return helper(nums, target, 0, nums.length - 1);
        }

        public boolean helper(int[] nums, int target, int start, int end) {
            int i = start;
            int j = end;
            if (start > end)
                return false;
            if (start == end) {
                if (nums[start] == target) {
                    return true;
                } else {
                    return false;
                }
            }
            while (i <= j) {
                int mid = (i + j) / 2;
                if (nums[mid] == target)
                    return true;
                if (nums[i] < nums[mid]) {
                    if (target >= nums[i] && target < nums[mid]) {
                        j = mid - 1;
                    } else {
                        i = mid + 1;
                    }
                } else if (nums[j] > nums[mid]) {
                    if (target > nums[mid] && target <= nums[j]) {
                        i = mid + 1;
                    } else {
                        j = mid - 1;
                    }
                } else {
                    return helper(nums, target, start, mid - 1) || helper(nums, target, mid + 1, end);
                }
            }
            return false;

        }
    }
}