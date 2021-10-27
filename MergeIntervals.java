import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/merge-intervals/
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            int i = 0;
            while (i < intervals.length) {
                ArrayList<Integer> in = new ArrayList<>();
                in.add(intervals[i][0]);
                int end = intervals[i][1];
                while (i < intervals.length && intervals[i][0] <= end) {
                    end = Math.max(end, intervals[i][1]);
                    i++;
                }
                in.add(end);
                arr.add(in);
            }
            int ans[][] = new int[arr.size()][2];
            for (i = 0; i < ans.length; i++) {
                ans[i][0] = arr.get(i).get(0);
                ans[i][1] = arr.get(i).get(1);
            }
            return ans;
        }
    }
}
