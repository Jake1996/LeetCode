public class SentenceScreenFitting {
    public static void main(String[] args) {
        System.out.print((new Solution()).wordsTyping(new String[] { "a", "b", "e" }, 20000, 20000));
    }
    // https://leetcode.com/problems/sentence-screen-fitting/
    public static class Solution {
        public int wordsTyping(String[] sentence, int rows, int cols) {
            int cur = 0;
            for (int i = 0; i < rows; i++) {
                int oc = 0;
                int curWordL = sentence[cur % sentence.length].length();
                while (oc >= 0 && curWordL <= cols - oc) {
                    oc = oc + curWordL + 1;
                    cur++;
                    curWordL = sentence[cur % sentence.length].length();
                }
            }
            return cur / sentence.length;
        }
    }
}
