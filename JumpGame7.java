import java.util.LinkedList;
import java.util.Queue;

public class JumpGame7 {
    // https://leetcode.com/problems/jump-game-vii/
    class Solution {
        public boolean canReach(String s, int minJump, int maxJump) {
            if (s.charAt(s.length() - 1) == '1')
                return false;
            int maxReach = 0;
            Queue<Integer> Q = new LinkedList<>();
            Q.add(0);
            while (!Q.isEmpty()) {
                int i = Q.remove();

                for (int j = Math.max(i + minJump, maxReach); j <= Math.min(s.length() - 1, i + maxJump); j++) {
                    if (s.charAt(j) == '0') {
                        if (j == s.length() - 1)
                            return true;
                        Q.add(j);
                    }
                }
                maxReach = Math.min(i + maxJump, s.length() - 1);
            }
            return false;
        }
    }
}
