import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MostStonesRemoved {
    public static void main(String[] args) {
        System.out.print((new Solution()).removeStones(new int[][]{{0,3},{0,2},{1,0},{1,2},{1,1},{3,2},{2,2}}));
    }
    // https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
    static class Solution {
        int limit = 10000;
        HashMap<Integer,HashSet<Integer>> map;
        public int removeStones(int[][] stones) {
            map = new HashMap<>();
            for(int[] stone : stones) {
                addStone(stone);
            }
            int count = 0;
            for(int i=0;i<limit;i++) {
                if(map.get(i)!=null && map.get(i).size() >0) {
                    count++;
                    bfs(i);
                }
            }
            return stones.length - count;
        }
        public void bfs(int i) {
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()) {
                int e = q.remove();
                ArrayList<Integer> arr = new ArrayList<>(map.getOrDefault(e,new HashSet<Integer>()));
                for(Integer j : arr) {
                    removeStone(new int[]{e,j});
                    q.add(j);
                }
            }
        }
        public void addStone(int[] s) {
            HashSet<Integer> hs = map.getOrDefault(s[0],new HashSet<Integer>());
            hs.add(s[1]+limit);
            map.put(s[0],hs);
            hs = map.getOrDefault(s[1]+limit,new HashSet<Integer>());
            hs.add(s[0]);
            map.put(s[1]+limit,hs);
        }
        public void removeStone(int[] s) {
            map.getOrDefault(s[0],new HashSet<Integer>()).remove(s[1]);
            map.getOrDefault(s[1],new HashSet<Integer>()).remove(s[0]);
        }
    }
}
