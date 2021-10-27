import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinations {
    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    static class Solution {
        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0)
                return new ArrayList<String>();
            List<String> ans = new ArrayList<String>();
            List<String> cur = getStrings(digits.charAt(0));
            if (digits.length() == 1)
                return cur;
            for (String s : cur) {
                for (String t : letterCombinations(digits.substring(1))) {
                    ans.add(s + t);
                }
            }
            return ans;
        }

        public List<String> getStrings(Character c) {
            List<String> ans = new ArrayList<String>();
            switch (c) {
                case '2':
                    return Arrays.asList(new String[] { "a", "b", "c" });
                case '3':
                    return Arrays.asList(new String[] { "d", "e", "f" });
                case '4':
                    return Arrays.asList(new String[] { "g", "h", "i" });
                case '5':
                    return Arrays.asList(new String[] { "j", "k", "l" });
                case '6':
                    return Arrays.asList(new String[] { "m", "n", "o" });
                case '7':
                    return Arrays.asList(new String[] { "p", "q", "r", "s" });
                case '8':
                    return Arrays.asList(new String[] { "t", "u", "v" });
                case '9':
                    return Arrays.asList(new String[] { "w", "x", "y", "z" });

            }
            return ans;
        }
    }
}