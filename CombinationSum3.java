import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    // https://leetcode.com/problems/combination-sum-iii/
    class Solution {
        List<List<Integer>> ans;
        int[] list = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        public List<List<Integer>> combinationSum3(int k, int n) {
            ans = new ArrayList<>();
            helper(0, 0, k, n, new ArrayList<>());
            return ans;
        }

        public void helper(int i, int j, int k, int target, ArrayList<Integer> l) {
            if (j == k) {
                if (target == 0) {
                    ans.add(new ArrayList<>(l));
                }
                return;
            }
            for (; i < list.length; i++) {
                if (target - list[i] >= 0) {
                    ArrayList<Integer> a = new ArrayList<>(l);
                    a.add(list[i]);
                    helper(i + 1, j + 1, k, target - list[i], a);
                } else {
                    break;
                }
            }
        }
    }
}
