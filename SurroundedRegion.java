import java.util.ArrayList;

public class SurroundedRegion {
    // https://leetcode.com/problems/surrounded-regions/
    class Solution {
        public void solve(char[][] board) {
            for (int i = 1; i < board.length - 1; i++) {
                for (int j = 1; j < board[i].length - 1; j++) {
                    if (board[i][j] == 'O') {
                        boolean[][] visited = new boolean[board.length][board[0].length];
                        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();
                        if (helper(board, visited, i, j, list)) {
                            for (Pair<Integer, Integer> p : list) {
                                board[p.getKey()][p.getValue()] = 'X';
                            }
                        }
                    }
                }
            }
        }

        public boolean helper(char[][] board, boolean[][] visited, int i, int j,
                ArrayList<Pair<Integer, Integer>> list) {
            if (visited[i][j])
                return true;
            list.add(new Pair<Integer, Integer>(i, j));
            visited[i][j] = true;
            if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) {
                return false;
            }
            if (board[i - 1][j] == 'O' && !visited[i - 1][j] && !helper(board, visited, i - 1, j, list)) {
                return false;
            }
            if (board[i + 1][j] == 'O' && !visited[i + 1][j] && !helper(board, visited, i + 1, j, list)) {
                return false;
            }
            if (board[i][j - 1] == 'O' && !visited[i][j - 1] && !helper(board, visited, i, j - 1, list)) {
                return false;
            }
            if (board[i][j + 1] == 'O' && !visited[i][j + 1] && !helper(board, visited, i, j + 1, list)) {
                return false;
            }
            return true;
        }
    }
}