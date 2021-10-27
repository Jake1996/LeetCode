public class NQueens2 {
    // https://leetcode.com/problems/n-queens-ii/
    class Solution {
        int ans;
        int n;
        int count;

        public int totalNQueens(int n) {
            this.n = n;
            helper(0, 0, new int[n * 2 + 1], new int[n * 2 + 1], new int[n * 2 + 1]);
            return ans;
        }

        public void helper(int k, int j, int ld[], int rd[], int row[]) {
            if (k == n) {
                ans++;
            }
            if (j == n)
                return;
            for (int i = 0; i < n; i++) {
                if (ld[i + j] == 0 && rd[n + i - j] == 0 && row[i] == 0) {
                    ld[i + j] = 1;
                    rd[n + i - j] = 1;
                    row[i] = 1;
                    helper(k + 1, j + 1, ld, rd, row);
                    ld[i + j] = 0;
                    rd[n + i - j] = 0;
                    row[i] = 0;
                }
            }
        }
    }
}
