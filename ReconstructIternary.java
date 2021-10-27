import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructIternary {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] t = new String[][] { { "AXA", "EZE" }, { "EZE", "AUA" }, { "ADL", "JFK" }, { "ADL", "TIA" },
                { "AUA", "AXA" }, { "EZE", "TIA" }, { "EZE", "TIA" }, { "AXA", "EZE" }, { "EZE", "ADL" },
                { "ANU", "EZE" }, { "TIA", "EZE" }, { "JFK", "ADL" }, { "AUA", "JFK" }, { "JFK", "EZE" },
                { "EZE", "ANU" }, { "ADL", "AUA" }, { "ANU", "AXA" }, { "AXA", "ADL" }, { "AUA", "JFK" },
                { "EZE", "ADL" }, { "ANU", "TIA" }, { "AUA", "JFK" }, { "TIA", "JFK" }, { "EZE", "AUA" },
                { "AXA", "EZE" }, { "AUA", "ANU" }, { "ADL", "AXA" }, { "EZE", "ADL" }, { "AUA", "ANU" },
                { "AXA", "EZE" }, { "TIA", "AUA" }, { "AXA", "EZE" }, { "AUA", "SYD" }, { "ADL", "JFK" },
                { "EZE", "AUA" }, { "ADL", "ANU" }, { "AUA", "TIA" }, { "ADL", "EZE" }, { "TIA", "JFK" },
                { "AXA", "ANU" }, { "JFK", "AXA" }, { "JFK", "ADL" }, { "ADL", "EZE" }, { "AXA", "TIA" },
                { "JFK", "AUA" }, { "ADL", "EZE" }, { "JFK", "ADL" }, { "ADL", "AXA" }, { "TIA", "AUA" },
                { "AXA", "JFK" }, { "ADL", "AUA" }, { "TIA", "JFK" }, { "JFK", "ADL" }, { "JFK", "ADL" },
                { "ANU", "AXA" }, { "TIA", "AXA" }, { "EZE", "JFK" }, { "EZE", "AXA" }, { "ADL", "TIA" },
                { "JFK", "AUA" }, { "TIA", "EZE" }, { "EZE", "ADL" }, { "JFK", "ANU" }, { "TIA", "AUA" },
                { "EZE", "ADL" }, { "ADL", "JFK" }, { "ANU", "AXA" }, { "AUA", "AXA" }, { "ANU", "EZE" },
                { "ADL", "AXA" }, { "ANU", "AXA" }, { "TIA", "ADL" }, { "JFK", "ADL" }, { "JFK", "TIA" },
                { "AUA", "ADL" }, { "AUA", "TIA" }, { "TIA", "JFK" }, { "EZE", "JFK" }, { "AUA", "ADL" },
                { "ADL", "AUA" }, { "EZE", "ANU" }, { "ADL", "ANU" }, { "AUA", "AXA" }, { "AXA", "TIA" },
                { "AXA", "TIA" }, { "ADL", "AXA" }, { "EZE", "AXA" }, { "AXA", "JFK" }, { "JFK", "AUA" },
                { "ANU", "ADL" }, { "AXA", "TIA" }, { "ANU", "AUA" }, { "JFK", "EZE" }, { "AXA", "ADL" },
                { "TIA", "EZE" }, { "JFK", "AXA" }, { "AXA", "ADL" }, { "EZE", "AUA" }, { "AXA", "ANU" },
                { "ADL", "EZE" }, { "AUA", "EZE" } };
        List<List<String>> g = new ArrayList<>();
        for (int i = 0; i < t.length - 1; i++) {
            // System.out.print("[\""+s[i]+"\",\""+s[i+1]+"\"],");
            g.add(Arrays.asList(t[i]));
        }
        // System.out.println();
        System.out.println(solution.findItinerary(g).toString());
    }

    // https://leetcode.com/problems/reconstruct-itinerary/
    static class Solution {
        HashMap<String, PriorityQueue<String>> graph;
        ArrayList<String> answer;

        public List<String> findItinerary(List<List<String>> tickets) {
            graph = new HashMap<>();
            answer = new ArrayList<>();
            for (int i = 0; i < tickets.size(); i++) {
                addEdge(tickets.get(i).get(0), tickets.get(i).get(1));
            }
            answer.add("JFK");
            helper("JFK");
            return this.answer;
        }

        public void addEdge(String from, String to) {
            PriorityQueue<String> list = this.graph.getOrDefault(from, new PriorityQueue<String>());
            list.add(to);
            this.graph.put(from, list);
        }

        public void removeEdge(String from, String to) {
            this.graph.get(from).remove(to);
        }

        public void dfs(String v, HashSet<String> visited) {
            if (visited.contains(v))
                return;
            visited.add(v);
            for (String u : this.graph.getOrDefault(v, new PriorityQueue<String>())) {
                dfs(u, visited);
            }
        }

        public void helper(String v) {
            int maxNodes = -1;
            PriorityQueue<String> toList = this.graph.getOrDefault(v, new PriorityQueue<String>());
            if (toList.size() == 0)
                return;
            String next = toList.peek();
            String[] arr = toList.toArray(new String[] {});
            Arrays.sort(arr);
            List<String> it = Arrays.asList(arr);
            for (String u : it) {
                HashSet<String> count1 = new HashSet<>();
                HashSet<String> count2 = new HashSet<>();
                dfs(u, count1);
                removeEdge(v, u);
                dfs(u, count2);
                addEdge(v, u);
                if (count1.size() <= count2.size() && count1.size() > maxNodes) {
                    next = u;
                    maxNodes = count1.size();
                }
            }
            if (next != null) {
                this.answer.add(next);
                removeEdge(v, next);
                helper(next);
            }
        }
    }
}
