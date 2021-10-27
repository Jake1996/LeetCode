public class PartitionArrayDisjointInterval {
    // https://leetcode.com/problems/partition-array-into-disjoint-intervals/submissions/
    class Solution {
        public int partitionDisjoint(int[] nums) {
            int max = 0;
            int ans = 1;
            int tM = 0;
            for(int i=1;i<nums.length;i++) {
                if(nums[i] < nums[max]) {
                    ans = i+1;
                    max = tM;
                }
                if(nums[tM] < nums[i]) {
                    tM = i;
                }
            }
            return ans;
        }
    }
}
