import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    // https://leetcode.com/problems/3sum/
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> list = new ArrayList<>();
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                hm.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1])
                        continue;
                    int opp = -1 * (nums[i] + nums[j]);
                    int index = hm.getOrDefault(opp, -1);
                    if (index > j && index != i && index != j) {
                        list.add(Arrays.asList(new Integer[] { nums[i], nums[j], opp }));
                    }
                }
            }
            return list;
        }
    }
}
