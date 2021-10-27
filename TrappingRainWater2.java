import java.util.PriorityQueue;

public class TrappingRainWater2 {
    class Solution {
        public int trapRainWater(int[][] heightMap) {
            PriorityQueue<Element> q = new PriorityQueue<Element>((c1, c2) -> c1.val - c2.val);
            int n = heightMap.length;
            int m = heightMap[0].length;
            boolean visited[][] = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                q.add(new Element(i, 0, heightMap[i][0]));
                visited[i][0] = true;
                if (m > 1) {
                    q.add(new Element(i, m - 1, heightMap[i][m - 1]));
                    visited[i][m - 1] = true;
                }
            }
            for (int i = 1; i < m - 1; i++) {
                q.add(new Element(0, i, heightMap[0][i]));
                visited[0][i] = true;
                if (n > 1) {
                    visited[n - 1][i] = true;
                    q.add(new Element(n - 1, i, heightMap[n - 1][i]));
                }
            }
            int max = 0;
            int count = 0;
            while (!q.isEmpty()) {
                Element e = q.remove();
                max = Math.max(max, e.val);
                if (e.i > 0 && !visited[e.i - 1][e.j]) {
                    count += add(e.i - 1, e.j, q, heightMap, visited, max);
                }
                if (e.i < n - 1 && !visited[e.i + 1][e.j]) {
                    count += add(e.i + 1, e.j, q, heightMap, visited, max);
                }
                if (e.j > 0 && !visited[e.i][e.j - 1]) {
                    count += add(e.i, e.j - 1, q, heightMap, visited, max);
                }
                if (e.j < m - 1 && !visited[e.i][e.j + 1]) {
                    count += add(e.i, e.j + 1, q, heightMap, visited, max);
                }
            }
            return count;
        }

        public int add(int i, int j, PriorityQueue<Element> q, int[][] heightMap, boolean[][] visited, int max) {
            visited[i][j] = true;
            q.add(new Element(i, j, heightMap[i][j]));
            if (heightMap[i][j] < max) {
                return max - heightMap[i][j];
            }
            return 0;
        }

        public class Element {
            int i;
            int j;
            int val;

            public Element(int a, int b, int c) {
                i = a;
                j = b;
                val = c;
            }
        }
    }
}
