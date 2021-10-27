import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    // https://leetcode.com/problems/combination-sum-ii/
    class Solution {
        List<List<Integer>> ans;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            this.ans = new ArrayList<>();
            helper(candidates, 0, target, new ArrayList<Integer>());
            return ans;
        }

        public void helper(int[] candidates, int start, int target, List<Integer> l) {
            if (target == 0) {
                this.ans.add(l);
            }
            if (target < 0)
                return;
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1])
                    continue;
                if (candidates[i] <= target) {
                    List<Integer> lc = new ArrayList<>(l);
                    lc.add(candidates[i]);
                    helper(candidates, i + 1, target - candidates[i], lc);
                }
            }
        }
    }
}
