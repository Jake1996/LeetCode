import java.util.LinkedList;
import java.util.Queue;

public class JumpGame3 {
    // https://leetcode.com/problems/jump-game-iii/
    class Solution {
        public boolean canReach(int[] arr, int start) {
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(start);
            boolean visited[] = new boolean[arr.length];
            visited[start] = true;
    
            while(!q.isEmpty()) {
                int index = q.remove();
                
                if(arr[index] == 0) return true;
                if(index+arr[index] < arr.length && !visited[index+arr[index] ]) {
                    q.add(index+arr[index]); 
                    visited[index+arr[index]] = true;
                }
                
                if(index-arr[index] >=0 && !visited[index-arr[index] ]) {
                    q.add(index-arr[index]); 
                    visited[index-arr[index]] = true;
                }
            }
            return false;
        }
    }
}
