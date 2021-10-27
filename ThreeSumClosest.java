import java.util.Arrays;

public class ThreeSumClosest {
    // https://leetcode.com/problems/3sum-closest/
    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int ans = nums[0] + nums[1] + nums[2];
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                int j = i + 1;
                int k = nums.length - 1;
                int sum = nums[i] + nums[j] + nums[k];
                while (j < k && k > i && j < nums.length) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (sum > target) {
                        k--;
                    } else {
                        j++;
                    }
                    if (Math.abs(sum - target) < Math.abs(ans - target)) {
                        ans = sum;
                    }
                }

            }
            return ans;
        }
    }
}