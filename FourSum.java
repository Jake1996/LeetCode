import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FourSum {
    // https://leetcode.com/problems/4sum/
    public static class Solution {
        HashMap<Integer, ArrayList<Integer>> map;

        public List<List<Integer>> fourSum(int[] nums, int target) {
            this.map = new HashMap<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                ArrayList<Integer> tl = this.map.getOrDefault(nums[i], new ArrayList<Integer>());
                tl.add(i);
                this.map.put(nums[i], tl);
            }
            return kSum(nums, target, 0, 4);
        }

        public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
            if (k == 2)
                return twoSum(nums, target, start);
            List<List<Integer>> l = new ArrayList<>();
            for (int i = start; i < nums.length - 2; i++) {
                if (i > start && nums[i] == nums[i - 1])
                    continue;
                for (List<Integer> p : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    ArrayList<Integer> ans = new ArrayList<>(p);
                    ans.add(nums[i]);
                    l.add(ans);
                }
            }
            return l;
        }

        public List<List<Integer>> twoSum(int[] nums, int target, int start) {
            List<List<Integer>> l = new ArrayList<>();
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1])
                    continue;
                ArrayList<Integer> end = this.map.get(target - nums[i]);
                if (end != null) {
                    for (int j = end.size() - 1; j >= 0 && end.get(j) > i; j--) {
                        if (j < end.size() - 1 && nums[end.get(j)] == nums[end.get(j) + 1])
                            continue;
                        l.add(Arrays.asList(nums[i], nums[end.get(j)]));
                    }
                }
            }
            return l;
        }
    }
}
