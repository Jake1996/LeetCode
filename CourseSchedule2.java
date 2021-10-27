import java.util.ArrayList;
import java.util.Collections;

public class CourseSchedule2 {
    // https://leetcode.com/problems/course-schedule-ii/
    class Solution {

        private ArrayList<ArrayList<Integer>> map;
        private boolean[] gVisited;
        private ArrayList<Integer> list;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            this.map = new ArrayList<>(numCourses);
            this.list = new ArrayList<>(numCourses);
            gVisited = new boolean[numCourses];
            for (int i = 0; i < numCourses; i++) {
                this.map.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < prerequisites.length; i++) {
                int ci = prerequisites[i][1];
                this.map.get(ci).add(prerequisites[i][0]);
            }
            for (int i = 0; i < numCourses; i++) {
                if (!gVisited[i] && !dfs(i, new boolean[numCourses]))
                    return new int[0];
            }
            Collections.reverse(list);
            return list.stream().mapToInt(i -> i).toArray();
        }

        public boolean dfs(int i, boolean[] visited) {
            if (visited[i]) {
                return false;
            }
            visited[i] = true;
            for (Integer v : this.map.get(i)) {
                if (!gVisited[i] && !dfs(v, visited))
                    return false;
            }
            visited[i] = false;
            if (!gVisited[i]) {
                gVisited[i] = true;
                this.list.add(i);
            }
            return true;
        }
    }
}