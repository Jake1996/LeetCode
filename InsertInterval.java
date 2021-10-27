import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    // https://leetcode.com/problems/insert-interval/
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<List<Integer>> arr = new ArrayList<>();
            if(intervals.length == 0) {
                arr.add(Arrays.asList(newInterval[0],newInterval[1]));
                return getOutput(arr);
            }
            int i=0;
            boolean added = false;
            while(i < intervals.length) {
                if(intervals[i][1] < newInterval[0]) {
                    arr.add(Arrays.asList(intervals[i][0], intervals[i][1]));
                } else if(newInterval[1] < intervals[i][0] && !added) {
                    arr.add(Arrays.asList(newInterval[0], newInterval[1]));
                    arr.add(Arrays.asList(intervals[i][0], intervals[i][1]));
                    added = true;
                } else if(newInterval[1] < intervals[i][0] && added) {
                    arr.add(Arrays.asList(intervals[i][0], intervals[i][1]));
                } else if(newInterval[1] >= intervals[i][0]) {
                    newInterval = mergeInterval(newInterval,intervals[i]);
                }
                i++;
            }
            if(!added) {
                arr.add(Arrays.asList(newInterval[0], newInterval[1]));
            }
            return getOutput(arr);
    
        }
        public int[] mergeInterval(int[] i1,int[] i2) {
            return new int[]{Math.min(i1[0],i2[0]),Math.max(i1[1],i2[1])};
        }
        public int[][] getOutput(List<List<Integer>> list) {
            int out[][] = new int[list.size()][2];
            for(int i=0;i<list.size();i++) {
                out[i][0] = list.get(i).get(0);
                out[i][1] = list.get(i).get(1);
            }
            return out;
        }
    }
}
