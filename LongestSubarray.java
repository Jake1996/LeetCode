import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestSubarray {
    // https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
    static class Solution {
        public int longestSubarray(int[] nums, int limit) {
            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
            int start = 0;
            int end = 0;
            int max = 1;
            while (start <= end && end < nums.length) {
                minQ.add(nums[end]);
                maxQ.add(nums[end]);
                int minN = minQ.peek();
                int maxN = maxQ.peek();
                if (Math.abs(maxN - minN) <= limit) {
                    end++;
                    max = Math.max(max, end - start);
                } else {
                    minQ.remove(nums[start]);
                    maxQ.remove(nums[start]);
                    end++;
                    start++;
                }
            }
            return max;
        }
    }
}