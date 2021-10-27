import java.util.ArrayList;
import java.util.List;

public class Permutations {
    // https://leetcode.com/problems/permutations
    class Solution {
        List<List<Integer>> ans;
        public List<List<Integer>> permute(int[] nums) {
            ans = new ArrayList<>();
            recurse(new ArrayList<Integer>(),nums,new boolean[nums.length]);
            return ans;
        }
        public void recurse(ArrayList<Integer> cur,int[] nums,boolean[] visited) {
            if(cur.size()==nums.length) {
                ans.add(new ArrayList<>(cur));
                return;
            }
            for(int i=0;i<nums.length;i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    cur.add(nums[i]);
                    recurse(cur,nums,visited);
                    cur.remove(cur.size()-1);
                    visited[i] = false;
                }
            }
        }
    }
}
