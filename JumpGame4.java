import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class JumpGame4 {
    public static void main(String[] args) {
        System.out.println(
                (new Solution()).minJumps(new int[] { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 11 }));
    }

    // https://leetcode.com/problems/jump-game-iv/
    public static class Solution {
        public int minJumps(int[] arr) {
            HashMap<Integer, PriorityQueue<Integer>> hm = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                PriorityQueue<Integer> l = hm.getOrDefault(arr[i],
                        new PriorityQueue<Integer>(Collections.reverseOrder()));
                l.add(i);
                hm.put(arr[i], l);
            }
            Queue<Integer> q = new LinkedList<>();
            boolean visited[] = new boolean[arr.length];
            q.add(0);
            q.add(-1);
            int steps = 0;
            while (!q.isEmpty()) {
                int index = q.poll();
                if (index == -1) {
                    steps++;
                    if (!q.isEmpty()) {
                        q.add(-1);
                        continue;
                    } else {
                        break;
                    }
                }
                if (index == arr.length - 1) {
                    break;
                }
                ;
                visited[index] = true;
                if (index != 0 && !visited[index - 1]) {
                    q.add(index - 1);
                    visited[index - 1] = true;
                }
                if (!visited[index + 1]) {
                    q.add(index + 1);
                    visited[index + 1] = true;
                }
                PriorityQueue<Integer> l = hm.getOrDefault(arr[index], new PriorityQueue<Integer>());
                while (!l.isEmpty()) {
                    int i = l.poll();
                    if (!visited[i] && i != index) {
                        q.add(i);
                        visited[i] = true;
                    }
                }
            }
            return steps;
        }
    }
}
