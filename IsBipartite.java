import java.util.LinkedList;
import java.util.Queue;

public class IsBipartite {
    // https://leetcode.com/problems/is-graph-bipartite
    class Solution {
        boolean visited[];
        int color[];

        public boolean isBipartite(int[][] graph) {
            color = new int[graph.length];
            visited = new boolean[graph.length];
            for (int i = 0; i < graph.length; i++) {
                if (!visited[i]) {
                    if (!helper(i, graph))
                        return false;
                }
            }
            return true;
        }

        public boolean helper(int i, int[][] graph) {
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 1;
            while (!q.isEmpty()) {
                int u = q.remove();
                int c = color[u];
                int nc = -1 * c;
                for (int v : graph[u]) {
                    if (color[v] == c)
                        return false;
                    color[v] = nc;
                    if (!visited[v])
                        q.add(v);
                    visited[v] = true;
                }
            }
            return true;
        }
    }
}
