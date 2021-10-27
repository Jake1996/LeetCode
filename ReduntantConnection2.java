import java.util.HashMap;

public class ReduntantConnection2 {
    public static void main(String[] args) {
        int[] ans = (new Solution())
                // .findRedundantDirectedConnection(new int[][] { { 5, 2 }, { 5, 1 }, { 3, 1 },
                // { 3, 4 }, { 3, 5 } });
                .findRedundantDirectedConnection(new int[][] { { 2, 1 }, { 3, 1 }, { 4, 2 }, { 1, 4 } });
        System.out.println(ans[0] + " " + ans[1]);
    }

    // https://leetcode.com/problems/redundant-connection-ii/
    static class Solution {
        int parent[];

        public int[] findRedundantDirectedConnection(int[][] edges) {

            parent = new int[edges.length + 1];
            int ans1[] = null, ans2[] = null;
            HashMap<Integer, Integer> incoming = new HashMap<>();
            for (int[] edge : edges) {
                if (incoming.get(edge[1]) != null) {
                    ans1 = edge; // latest
                    ans2 = new int[] { incoming.get(edge[1]), edge[1] };
                } else {
                    incoming.put(edge[1], edge[0]);
                }
            }
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            for (int edge[] : edges) {
                if (ans1 != null && same(ans1, edge))
                    continue;
                if (!union(edge)) { // cycle detected
                    if (ans1 == null)
                        return edge;
                    return ans2;
                }
            }
            return ans1;
        }

        public boolean union(int[] edge) {
            int rx = root(edge[0]);
            int ry = root(edge[1]);
            if (rx == ry) {
                return false;
            } else {
                parent[ry] = rx;
            }
            return true;
        }

        public int root(int x) {
            if (parent[x] == x)
                return x;
            parent[x] = root(parent[x]);
            return parent[x];
        }

        public boolean same(int[] e1, int[] e2) {
            return e1[0] == e2[0] && e1[1] == e2[1];
        }
    }
}
