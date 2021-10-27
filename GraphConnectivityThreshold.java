import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphConnectivityThreshold {
    // https://leetcode.com/problems/graph-connectivity-with-threshold
    class Solution {
        int parent[];
        int rank[];

        public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
            Arrays.fill(rank, 1);
            for (int i = threshold + 1; i <= n; i++) {
                for (int j = 2; j * i <= n; j++) {
                    union(i, i * j);
                }
            }
            ArrayList<Boolean> ans = new ArrayList<>();
            for (int[] query : queries) {
                ans.add(root(query[0]) == root(query[1]));
            }
            return ans;
        }

        public void union(int a, int b) {
            int ra = root(a);
            int rb = root(b);
            if (rank[ra] > rank[rb]) {
                parent[rb] = ra;
                rank[ra] += rank[rb];
            } else {
                parent[ra] = rb;
                rank[rb] += rank[ra];
            }
        }

        public int root(int a) {
            if (parent[a] == a)
                return a;
            parent[a] = root(parent[a]);
            return parent[a];
        }
    }
}
