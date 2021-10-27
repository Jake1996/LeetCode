public class JumpGame {
    // https://leetcode.com/problems/jump-game/
    class Solution {
        public boolean canJump(int[] nums) {
            if(nums.length == 1) return true; 
            int i=0;
            int fuel = nums[0];
            while(fuel>=0 && i < nums.length) {
                if(fuel ==0 && nums[i]==0) break;
                fuel = Math.max(fuel,nums[i]);
                fuel--;
                i++;
            }
            if(i>=nums.length-1) return true;
            return false;
        }
    }
}
