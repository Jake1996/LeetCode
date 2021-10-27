public class BullsAndCows {
    // https://leetcode.com/problems/bulls-and-cows/
    class Solution {
        public String getHint(String secret, String guess) {
            int x = 0, y = 0;
            int[] sm = new int[10];
            int[] gm = new int[10];
            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) == guess.charAt(i)) {
                    x++;
                } else {
                    sm[secret.charAt(i) - '0']++;
                    gm[guess.charAt(i) - '0']++;
                }
            }
            for (int i = 0; i < 10; i++) {
                y += Math.min(sm[i], gm[i]);
            }
            return x + "A" + y + "B";
        }
    }
}
