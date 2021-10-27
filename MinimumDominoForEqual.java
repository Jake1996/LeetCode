import java.util.HashMap;

public class MinimumDominoForEqual {
    // https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
    class Solution {
        public int minDominoRotations(int[] tops, int[] bottoms) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int i = 0; i < tops.length; i++) {
                hm.put(tops[i], hm.getOrDefault(tops[i], 0) + 1);
                hm.put(bottoms[i], hm.getOrDefault(bottoms[i], 0) + 1);
            }
            int number = 0;
            for (Integer key : hm.keySet()) {
                if (hm.get(key) >= tops.length) {
                    number = key;
                }
            }
            if (number == 0)
                return -1;
            int topLength = 0;
            int bottomLength = 0;
            for (int i = 0; i < tops.length; i++) {
                if (tops[i] != number && bottoms[i] != number) {
                    return -1;
                }
                if (tops[i] != number) {
                    topLength++;
                }
                if (bottoms[i] != number) {
                    bottomLength++;
                }
            }
            return Math.min(topLength, bottomLength);
        }
    }
}