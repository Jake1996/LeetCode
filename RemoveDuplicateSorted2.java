import java.util.HashMap;

public class RemoveDuplicateSorted2 {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
    class Solution {
        public int removeDuplicates(int[] nums) {
            int i = 0;
            int j = 0;
            HashMap<Integer,Integer> hm = new HashMap<>();
            while( j < nums.length ) {
                int count = hm.getOrDefault(nums[j],0);
                hm.put(nums[j],count+1);
                if(count <= 1) {
                    nums[i++] = nums[j++];
                }else {
                    j++;
                }
            }
            return i;
        }
    }
}
