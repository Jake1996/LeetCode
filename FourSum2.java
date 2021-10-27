import java.util.HashMap;

public class FourSum2 {
    // https://leetcode.com/problems/4sum-ii/
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            int count = 0;
            HashMap<Integer,Integer> hm = new HashMap<>();
            for(int i=0;i<nums1.length;i++) {
                for(int j=0;j<nums2.length;j++) {
                    int sum = nums1[i] + nums2[j];
                    int c = hm.getOrDefault(sum,0);
                    hm.put(sum,c+1);
                }
            }
            for(int i=0;i<nums3.length;i++) {
                for(int j=0;j<nums4.length;j++) {
                    int sum = nums3[i] + nums4[j];
                    int c = hm.getOrDefault(-1*sum,0);
                    count+=c;
                }
            }
            return count;
        }
    }
}
