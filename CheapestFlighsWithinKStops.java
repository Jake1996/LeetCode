import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlighsWithinKStops {
    // https://leetcode.com/problems/cheapest-flights-within-k-stops/
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            HashMap<Integer, ArrayList<Pair<Integer, Integer>>> hm = new HashMap<>();
            Queue<Node> q = new LinkedList<Node>();
            for (int flight[] : flights) {
                ArrayList<Pair<Integer, Integer>> a = hm.getOrDefault(flight[0], new ArrayList<>());
                a.add(new Pair<Integer, Integer>(flight[1], flight[2]));
                hm.put(flight[0], a);
            }
            int dist[] = new int[n + 1];
            int steps[] = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            q.add(new Node(0, src, 0));
            dist[src] = 0;
            while (!q.isEmpty()) {
                Node e = q.poll();
                int inS = e.s;
                int inW = e.w;
                int u = e.v;
                for (Pair<Integer, Integer> p : hm.getOrDefault(u, new ArrayList<>())) {
                    int v = p.getKey();
                    int w = p.getValue();
                    if (w + inW < dist[v] && inS <= k) {
                        dist[v] = w + inW;
                        steps[v] = inS;
                        if (inS != k)
                            q.add(new Node(inS + 1, v, dist[v]));
                    } else if (inS < steps[v]) {
                        q.add(new Node(inS + 1, v, inW + w));
                    }
                }
            }
            return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
        }

        class Node {
            int s;
            int v;
            int w;

            public Node(int a, int b, int c) {
                s = a;
                v = b;
                w = c;
            }
        }
    }
}
