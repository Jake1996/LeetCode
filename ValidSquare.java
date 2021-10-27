public class ValidSquare {
    // https://leetcode.com/problems/valid-square/
    class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            return checkValid(p1, p2, p3, p4) || checkValid(p1, p3, p2, p4) || checkValid(p1, p2, p4, p3);
        }

        public boolean checkValid(int[] p1, int[] p2, int[] p3, int[] p4) {
            int side = dist(p1, p2);
            int diagonal = dist(p1, p3);
            return side > 0 && diagonal > 0 && side == dist(p2, p3) && side == dist(p4, p3) && side == dist(p4, p1)
                    && diagonal == dist(p2, p4);
        }

        public int dist(int[] p1, int[] p2) {
            return (int) Math.pow(p2[0] - p1[0], 2) + (int) Math.pow(p2[1] - p1[1], 2);
        }
    }
}
