public class DetermineByRotation {
    // https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
    class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            if(checkEqual(mat,target)) return true;
            transpose(mat);
            reflect(mat);
            if(checkEqual(mat,target)) return true;
            transpose(mat);
            reflect(mat);
            if(checkEqual(mat,target)) return true;
            transpose(mat);
            reflect(mat);
            if(checkEqual(mat,target)) return true;
            return false;
        }
        public void transpose(int[][] matrix) {
                int n = matrix.length;
                for (int i = 0; i < n; i++) {
                    for (int j = i; j < n; j++) {
                        int tmp = matrix[j][i];
                        matrix[j][i] = matrix[i][j];
                        matrix[i][j] = tmp;
                    }
                }
            }
            
            public void reflect(int[][] matrix) {
                int n = matrix.length;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n / 2; j++) {
                        int tmp = matrix[i][j];
                        matrix[i][j] = matrix[i][n - j - 1];
                        matrix[i][n - j - 1] = tmp;
                    }
                }
            }
            public boolean checkEqual(int[][] mat1,int[][] mat2) {
                int n = mat1.length;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n ; j++) {
                        if(mat1[i][j]!=mat2[i][j]) return false;
                    }
                }
                return true;
            }
    }
}
