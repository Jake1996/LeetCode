import java.util.Stack;

public class NumberClosedIsland {
    // https://leetcode.com/problems/number-of-closed-islands/
    class Solution {
        boolean visited[][];

        public int closedIsland(int[][] grid) {
            visited = new boolean[grid.length][grid[0].length];
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (!this.visited[i][j] && grid[i][j] == 0) {
                        if (dfs(grid, i, j)) {
                            count++;
                        }
                    }
                }
            }
            return count;
        }

        public boolean dfs(int[][] grid, int i, int j) {
            Stack<Pair<Integer, Integer>> st = new Stack<>();
            st.push(new Pair<Integer, Integer>(i, j));
            boolean il = true;
            visited[i][j] = true;
            while (!st.isEmpty()) {
                Pair<Integer, Integer> p = st.pop();
                if (isEdge(grid, p)) {
                    il = false;
                }
                if (p.getKey() > 0 && grid[p.getKey() - 1][p.getValue()] == 0
                        && !visited[p.getKey() - 1][p.getValue()]) {
                    visited[p.getKey() - 1][p.getValue()] = true;
                    st.push(new Pair<Integer, Integer>(p.getKey() - 1, p.getValue()));
                }
                if (p.getKey() < grid.length - 1 && grid[p.getKey() + 1][p.getValue()] == 0
                        && !visited[p.getKey() + 1][p.getValue()]) {
                    visited[p.getKey() + 1][p.getValue()] = true;
                    st.push(new Pair<Integer, Integer>(p.getKey() + 1, p.getValue()));
                }
                if (p.getValue() > 0 && grid[p.getKey()][p.getValue() - 1] == 0
                        && !visited[p.getKey()][p.getValue() - 1]) {
                    visited[p.getKey()][p.getValue() - 1] = true;
                    st.push(new Pair<Integer, Integer>(p.getKey(), p.getValue() - 1));
                }
                if (p.getValue() < grid[p.getKey()].length - 1 && grid[p.getKey()][p.getValue() + 1] == 0
                        && !visited[p.getKey()][p.getValue() + 1]) {
                    visited[p.getKey()][p.getValue() + 1] = true;
                    st.push(new Pair<Integer, Integer>(p.getKey(), p.getValue() + 1));
                }

            }
            return il;
        }

        public boolean isEdge(int[][] grid, Pair<Integer, Integer> i) {
            if (i.getKey() == 0 || i.getValue() == 0 || i.getKey() == grid.length - 1
                    || i.getValue() == grid[i.getKey()].length - 1) {
                return true;
            }
            return false;
        }
    }
}
