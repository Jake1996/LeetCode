public class CountAndSay {
    // https://leetcode.com/problems/count-and-say/
    class Solution {
        public String countAndSay(int n) {
            String output = "1";
            for (int i = 1; i < n; i++) {
                String newStr = "";
                int lastI = 0;
                for (int j = 1; j < output.length(); j++) {
                    if (output.charAt(j) != output.charAt(lastI)) {
                        newStr += j - lastI + "" + output.charAt(lastI);
                        lastI = j;
                    }
                }
                newStr += output.length() - lastI + "" + output.charAt(lastI);
                output = newStr;
            }
            return output;
        }
    }
}
