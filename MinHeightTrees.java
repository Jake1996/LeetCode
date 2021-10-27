import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MinHeightTrees {
    // https://leetcode.com/problems/minimum-height-trees/
    class Solution {
        int height[];
        HashMap<Integer,HashSet<Integer>> map;
        boolean visited[];
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if(n==1) {
                return Arrays.asList(new Integer[]{n-1});
            }
            this.map = new HashMap<Integer,HashSet<Integer>>();
            for(int i=0;i<n-1;i++) {
                HashSet<Integer> list;
                list = this.map.getOrDefault(edges[i][0],new HashSet<Integer>());
                list.add(edges[i][1]);
                this.map.put(edges[i][0],list);
                list = this.map.getOrDefault(edges[i][1],new HashSet<Integer>());
                list.add(edges[i][0]);
                this.map.put(edges[i][1],list);
            }
            ArrayList<Integer> leaves = new ArrayList<>();
            for(int i=0;i<n;i++) {
                if(this.map.get(i).size()==1) {
                    leaves.add(i);
                }
            }
            int nodes = n;
            while(nodes>2) {
                ArrayList<Integer> newLeaves = new ArrayList<>();
                for(Integer v : leaves) {
                    HashSet<Integer> neighbors = this.map.get(v);
                    for(Integer ne : neighbors) {
                        map.get(ne).remove(v);
                        if(map.get(ne).size()==1) {
                            newLeaves.add(ne);
                        }
                    }
                    nodes--;
                }
                leaves = newLeaves;
            }
            return new ArrayList<Integer>(leaves);
        }
        
    }
}