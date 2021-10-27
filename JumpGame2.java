public class JumpGame2 {
    // https://leetcode.com/problems/jump-game-ii
    class Solution {
        public int jump(int[] nums) {
            int[] minS = new int[nums.length];
            int index = nums.length - 2;
            while (index >= 0) {
                if (nums[index] + index >= nums.length - 1) {
                    minS[index] = 1;
                } else {
                    int min = nums.length * 2;
                    for (int i = index + 1; i <= index + nums[index]; i++) {
                        min = Math.min(min, minS[i]);
                    }
                    minS[index] = min + 1;
                }
                index--;
            }
            return minS[0];
        }
    }
}