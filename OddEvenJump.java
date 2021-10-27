import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {
    public static void main(String[] args) {
        System.out.print((new Solution()).oddEvenJumps(new int[] { 5, 1, 3, 4, 2 }));
    }
    // https://leetcode.com/problems/odd-even-jump/
    static class Solution {
        int jump[][];
        Boolean dp[][];

        public int oddEvenJumps(int[] arr) {
            // 0 - odd
            // 1 - even
            dp = new Boolean[arr.length][2];
            dp[arr.length - 1][0] = dp[arr.length - 1][1] = true;
            jump = new int[arr.length][2];
            for (int k = 0; k < arr.length; k++) {
                jump[k][0] = jump[k][1] = -1;

            }
            int i = arr.length - 1;
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            while (i >= 0) {
                Map.Entry<Integer, Integer> oddJ = tm.ceilingEntry(arr[i]);
                Map.Entry<Integer, Integer> evenJ = tm.floorEntry(arr[i]);
                if (oddJ != null) {
                    jump[i][0] = (int) oddJ.getValue();
                }
                if (evenJ != null) {
                    jump[i][1] = (int) evenJ.getValue();
                }
                tm.put(arr[i], i);
                i--;
            }
            for (i = 0; i < arr.length; i++) {
                if (dp[i][0] == null) {
                    dfs(i, true);
                }
            }
            int count = 0;
            for (i = 0; i < arr.length; i++) {
                if (dp[i][0] != null && dp[i][0] == true)
                    count++;
            }
            return count;
        }

        public boolean dfs(int i, boolean odd) {
            if (i == jump.length - 1)
                return true;
            int j = odd ? 0 : 1;
            if (dp[i][j] != null)
                return dp[i][j];
            int next = jump[i][j];
            if (next == -1)
                return false;
            boolean ans = dfs(next, !odd);
            dp[i][j] = ans;
            return ans;
        }
    }
}
