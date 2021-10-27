import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    // https://leetcode.com/problems/n-queens
    class Solution {
        List<List<String>> ans;
        int n;

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            ans = new ArrayList<>();
            char[][] arr = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(arr[i], '.');
            }

            helper(0, 0, new int[n * 2 + 1], new int[n * 2 + 1], new int[n * 2 + 1], arr);
            return ans;
        }

        public void helper(int k, int j, int ld[], int rd[], int row[], char arr[][]) {
            if (k == n) {
                addAns(arr);
            }
            if (j == n)
                return;
            for (int i = 0; i < n; i++) {
                if (ld[i + j] == 0 && rd[n + i - j] == 0 && row[i] == 0) {
                    arr[i][j] = 'Q';
                    ld[i + j] = 1;
                    rd[n + i - j] = 1;
                    row[i] = 1;
                    helper(k + 1, j + 1, ld, rd, row, arr);
                    arr[i][j] = '.';
                    ld[i + j] = 0;
                    rd[n + i - j] = 0;
                    row[i] = 0;
                }
            }
        }

        public void addAns(char[][] arr) {
            ArrayList<String> a = new ArrayList<>();
            for (char[] ca : arr) {
                a.add(new String(ca));
            }
            ans.add(a);
        }
    }
}
