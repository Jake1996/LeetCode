import java.util.Arrays;

public class CombinationSum4 {
    // https://leetcode.com/problems/combination-sum-iv/
    class Solution {
        int dp[];

        public int combinationSum4(int[] nums, int target) {
            dp = new int[target + 1];
            Arrays.sort(nums);
            Arrays.fill(dp, -1);
            return helper(nums, target);
        }

        public int helper(int nums[], int target) {
            if (target < 1)
                return 0;
            if (dp[target] != -1)
                return dp[target];
            int ways = 0;
            int i = 0;
            while (i < nums.length && nums[i] <= target) {
                if (nums[i] == target) {
                    ways += 1;
                } else {
                    ways += helper(nums, target - nums[i]);
                }
                i++;
            }
            dp[target] = ways;
            return ways;
        }
    }
}
