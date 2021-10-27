public class LongestIncreasingPath {
    // https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
    class Solution {
        boolean visited[][];
        int greater[][];

        public int longestIncreasingPath(int[][] matrix) {
            visited = new boolean[matrix.length][matrix[0].length];
            greater = new int[matrix.length][matrix[0].length];
            int max = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (!visited[i][j])
                        max = Math.max(max, helper(matrix, i, j));
                }
            }
            return max;
        }

        public int helper(int[][] matrix, int i, int j) {
            if (this.visited[i][j])
                return greater[i][j];
            int max = 1;
            if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
                max = Math.max(max, helper(matrix, i + 1, j) + 1);
            }
            if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
                max = Math.max(max, helper(matrix, i - 1, j) + 1);
            }
            if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
                max = Math.max(max, helper(matrix, i, j + 1) + 1);
            }
            if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
                max = Math.max(max, helper(matrix, i, j - 1) + 1);
            }
            greater[i][j] = max;
            visited[i][j] = true;
            return max;
        }
    }
}