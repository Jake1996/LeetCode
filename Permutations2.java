import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    // https://leetcode.com/problems/permutations-ii
    class Solution {
        List<List<Integer>> ans;
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
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
                if(visited[i] == true || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] != true)) {
                    continue;
                }
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
