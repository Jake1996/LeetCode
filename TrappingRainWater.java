public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println((new Solution()).trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }
    // https://leetcode.com/problems/trapping-rain-water/
    static class Solution {
        public int trap(int[] height) {
            int leftMax[] = new int[height.length];
            int rightMax[] = new int[height.length];
            int i = 0;
            int left = height[0];
            int right = height[height.length - 1];
            for (i = 1; i < height.length; i++) {
                leftMax[i] = left;
                rightMax[height.length - 1 - i] = right;
                left = Math.max(left, height[i]);
                right = Math.max(right, height[height.length - 1 - i]);
            }
            int ans = 0;
            for (i = 1; i < height.length - 1; i++) {
                int min = Math.min(leftMax[i], rightMax[i]);
                if (min == 0 || min <= height[i])
                    continue;
                ans += min - height[i];
            }
            return ans;
        }
    }
}
