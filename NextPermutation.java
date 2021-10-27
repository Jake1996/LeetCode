public class NextPermutation {
    // https://leetcode.com/problems/next-permutation/
    class Solution {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            int j = nums.length - 1;
            while (i >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            if (i >= 0)
                swap(nums, i, j);
            reverse(nums, i + 1);
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void reverse(int nums[], int start) {
            int i = 0;
            int count = (nums.length - start) / 2;
            while (i < count) {
                swap(nums, start + i, nums.length - 1 - i);
                i++;
            }
        }
    }
}