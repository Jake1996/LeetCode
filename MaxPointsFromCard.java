public class MaxPointsFromCard {
    // https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int max = 0;
            int[] leftSum = new int[cardPoints.length];
            int[] rightSum = new int[cardPoints.length];
            int n = cardPoints.length;
            leftSum[0] = cardPoints[0];
            rightSum[n-1] = cardPoints[n-1];
            for(int i=1;i<n;i++) {
                leftSum[i] = cardPoints[i] + leftSum[i-1];
                rightSum[n-i-1] = cardPoints[n-i-1] + rightSum[n-i];
            }
            max = Math.max(leftSum[k-1],rightSum[n-k]);
            for(int i=1;i<k;i++) {
                max = Math.max(max,leftSum[i-1]+rightSum[n-k+i]);
                
            }
            return max;
        }
    }
}