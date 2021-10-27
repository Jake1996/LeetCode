import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    // https://leetcode.com/problems/combination-sum
    class Solution {
        List<List<Integer>> ans;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            this.ans = new ArrayList<>();
            helper(candidates, 0, target, new ArrayList<Integer>());
            return ans;
        }

        public void helper(int[] candidates, int start, int target, List<Integer> l) {
            if (target == 0) {
                this.ans.add(l);
            }
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] <= target) {
                    List<Integer> lc = new ArrayList<>(l);
                    lc.add(candidates[i]);
                    helper(candidates, i, target - candidates[i], lc);
                }
            }
        }
    }
}
