import java.util.Stack;

public class AsteroidCollision {
    // https://leetcode.com/problems/asteroid-collision
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < asteroids.length; i++) {
                if (st.empty() || st.peek() < 0 || asteroids[i] > 0) {
                    st.push(asteroids[i]);
                } else {
                    int size = Math.abs(asteroids[i]);
                    while (!st.empty() && st.peek() > 0 && st.peek() < size) {
                        st.pop();
                    }
                    if (st.empty()) {
                        st.push(asteroids[i]);
                    } else if (st.peek() > 0 && st.peek() == size) {
                        st.pop();
                    } else if (st.peek() < 0) {
                        st.push(asteroids[i]);
                    }
                }
            }
            Stack<Integer> st2 = new Stack<>();
            while (!st.empty()) {
                st2.push(st.pop());
            }
            int arr[] = new int[st2.size()];
            int i = 0;
            while (!st2.empty()) {
                arr[i++] = st2.pop();
            }
            return arr;
        }
    }
}
