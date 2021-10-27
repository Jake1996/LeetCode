public class UniquePaths {
    public static void main(String args[]) {
        System.out.println((new Solution()).uniquePaths(10, 10));
    }

    // https://leetcode.com/problems/unique-paths/
    public static class Solution {
        public int uniquePaths(int m, int n) {
            m--;
            n--;
            long ans = 1;
            int max = Math.max(m, n);
            int min = Math.min(m, n);
            int j = 2;
            for (int i = max + 1; i <= m + n; i++) {
                ans *= i;
                if (ans % j == 0 && j <= min) {
                    ans /= j;
                    j++;
                }
            }
            while (j <= min) {
                ans /= j;
                j++;
            }
            return (int) ans;
        }
    }
}
