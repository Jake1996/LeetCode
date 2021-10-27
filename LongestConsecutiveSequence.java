import java.util.HashSet;

public class LongestConsecutiveSequence {
    // https://leetcode.com/problems/longest-consecutive-sequence
    class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0)
                return 0;
            int max = 1;
            HashSet<Integer> hs = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                hs.add(nums[i]);
            }
            for (int i = 0; i < nums.length; i++) {
                if (!hs.contains(nums[i]))
                    continue;
                int count = 1;
                hs.remove(nums[i]);
                int cur = nums[i] - 1;
                while (hs.contains(cur)) {
                    hs.remove(cur);
                    cur--;
                    count++;
                }
                cur = nums[i] + 1;
                while (hs.contains(cur)) {
                    cur++;
                    count++;
                }
                max = Math.max(max, count);
            }
            return max;
        }
    }
}
