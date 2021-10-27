import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseSchedule3 {
    // https://leetcode.com/problems/course-schedule-iii/
    static class Solution {
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, (a, b) -> a[1] - b[1]);
            PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((p1, p2) -> p2.getKey() - p1.getKey());

            int time = 0;
            for (int i = 0; i < courses.length; i++) {
                if (time + courses[i][0] <= courses[i][1]) {
                    pq.add(new Pair<Integer, Integer>(courses[i][0], courses[i][1]));
                    time += courses[i][0];
                } else if (!pq.isEmpty() && pq.peek().getKey() > courses[i][0]
                        && (time - pq.peek().getKey() + courses[i][0]) <= courses[i][1]) {
                    time -= pq.poll().getKey();
                    pq.add(new Pair<Integer, Integer>(courses[i][0], courses[i][1]));
                    time += courses[i][0];
                }
            }
            return pq.size();
        }
    }
}