public class ReduntantConnection {
    // https://leetcode.com/problems/redundant-connection/
    class Solution {
        int parent[];
        int rank[];
        public int[] findRedundantConnection(int[][] edges) {
            parent = new int[edges.length+1];
            rank = new int[edges.length+1];
            for(int i=0;i<parent.length;i++) {
                parent[i] = i;
                rank[i] = 1;
            }
            for(int edge[] : edges) {
                if(!union(edge)) return edge;
            }
            return new int[]{};
        }
        public boolean union(int[] edge) {
            int rx = root(edge[0]);
            int ry = root(edge[1]);
            if(rx == ry) {
                return false;
            }else if(rank[rx] > rank[ry]) {
                parent[ry]  = rx;
                rank[rx]+=rank[ry];
            }else if(rank[ry] > rank[rx]){
                parent[rx]  = ry;
                rank[ry]+=rank[rx];
            }else {
                parent[ry] = rx;
                rank[rx]++;
            }
            return true;
        }
        public int root(int x) {
            if(parent[x] == x) return x;
            parent[x] = root(parent[x]);
            return parent[x];
        }
    }
}
