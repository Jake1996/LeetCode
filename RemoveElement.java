public class RemoveElement {
    // https://leetcode.com/problems/remove-element/
    class Solution {
        public int removeElement(int[] nums, int val) {
            int i = 0;
            int j = 0;
            int count = 0;
            while (j < nums.length && i < nums.length) {
                if (nums[j] == val) {
                    while (j < nums.length && nums[j] == val)
                        j++;
                }
                if (j < nums.length) {
                    nums[i] = nums[j];
                    count++;
                }
                i++;
                j++;
            }
            return count;
        }
    }
}
