import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class JumpGame6 {
    // https://leetcode.com/problems/jump-game-vi/
    class Solution {
        public int maxResult(int[] nums, int k) {
            int longest[] = new int[nums.length];
            Arrays.fill(longest,Integer.MIN_VALUE);
            longest[0] = nums[0];
            Deque<Integer> deque = new LinkedList<Integer>();
            deque.add(0);
            for(int i=1;i<nums.length;i++){
                longest[i] = longest[deque.peekFirst()] + nums[i];
                while(!deque.isEmpty() && longest[deque.peekLast()] <= longest[i]) {
                    deque.removeLast();
                }
                deque.addLast(i);
                if(i-k >=0 && deque.peekFirst() <= i-k) {
                    deque.removeFirst();
                }
            }
            return longest[nums.length-1];
        }
    }
}
