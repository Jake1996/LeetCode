import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule4 {
    // https://leetcode.com/problems/course-schedule-iv/
    class Solution {
        Map<Integer, ArrayList<Integer>> map;

        public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
            if (prerequisites.length == 0 || queries.length == 0) {
                Boolean t[] = new Boolean[queries.length];
                Arrays.fill(t, false);
                return Arrays.asList(t);
            }
            HashMap<Integer, HashSet<Integer>> pre = new HashMap<>();
            map = new HashMap<>();
            int incoming[] = new int[numCourses];

            for (int[] edge : prerequisites) {
                ArrayList<Integer> a = map.getOrDefault(edge[0], new ArrayList<Integer>());
                a.add(edge[1]);
                map.put(edge[0], a);
                incoming[edge[1]]++;
            }
            Queue<Integer> leaves = new LinkedList<>();
            for (int i = 0; i < incoming.length; i++) {
                if (incoming[i] == 0)
                    leaves.add(i);
            }
            while (!leaves.isEmpty()) {
                int u = leaves.remove();
                for (int v : map.getOrDefault(u, new ArrayList<>())) {
                    incoming[v]--;
                    HashSet<Integer> hs = pre.getOrDefault(v, new HashSet<>());
                    hs.add(u);
                    for (Integer i : pre.getOrDefault(u, new HashSet<>())) {
                        hs.add(i);
                    }
                    pre.put(v, hs);
                    if (incoming[v] <= 0)
                        leaves.add(v);
                }
            }

            List<Boolean> ans = new ArrayList<>();
            for (int[] q : queries) {
                if ((pre.getOrDefault(q[1], new HashSet<>())).contains(q[0]))
                    ans.add(true);
                else
                    ans.add(false);
            }
            return ans;
        }
    }
}
