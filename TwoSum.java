import java.util.HashMap;

public class TwoSum {
    // https://leetcode.com/problems/two-sum
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int i = 0; i < nums.length - 1; i++) {
                hm.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                if (hm.get(target - nums[i]) != null && hm.get(target - nums[i]) != i) {
                    return new int[] { i, hm.get(target - nums[i]) };
                }
            }
            return new int[0];
        }
    }
}
