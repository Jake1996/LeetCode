import java.util.Stack;

public class LargestRectangleHistogram {
    // https://leetcode.com/problems/largest-rectangle-in-histogram/
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int leftMin[] = new int[heights.length];
            int rightMin[] = new int[heights.length];
            for(int i=0;i<heights.length;i++) {
                leftMin[i] = -1;
                rightMin[i] = heights.length;
            }
            Stack<Integer> s = new Stack<>();
            int i=0;
            while(i<heights.length) {
                while(!s.empty() && heights[s.peek()] > heights[i]) {
                    rightMin[s.peek()] = i;
                    s.pop();
                }
                if(i!=0 && heights[i]==heights[i-1]) {
                    leftMin[i] = leftMin[i-1];
                }
                else if(!s.empty()) {
                    leftMin[i] = s.peek();
                }
                s.push(i++);
            }
            int max = 0;
            for(i=0;i<heights.length;i++) {
                max = Math.max(max,(rightMin[i]-leftMin[i]-1)*heights[i]);
            }
            return max;
        }
    }
}