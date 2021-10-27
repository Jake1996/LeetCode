import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        System.out.print((new Solution()).removeInvalidParentheses(")("));
    }

    static class Solution {
        Set<String> ans;

        public List<String> removeInvalidParentheses(String s) {
            ans = new HashSet<String>();
            int left = 0, right = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    left++;
                } else if (c == ')') {
                    right = left == 0 ? right + 1 : right;
                    left = left > 0 ? left - 1 : left;
                }
            }
            helper(s, 0, 0, 0, left, right, new StringBuilder());
            return new ArrayList<String>(ans);
        }

        public void helper(String s, int i, int open, int close, int or, int cr, StringBuilder sb) {
            if (i == s.length()) {
                if (or == 0 && cr == 0) {
                    ans.add(sb.toString());
                }
                return;
            }
            char c = s.charAt(i);
            int j = sb.length();
            if ((c == '(' && or > 0) || (c == ')' && cr > 0))
                helper(s, i + 1, open, close, or - (c == '(' ? 1 : 0), cr - (c == ')' ? 1 : 0), sb);
            sb.append(c);
            if (c != '(' && c != ')')
                helper(s, i + 1, open, close, or, cr, sb);
            else if (c == '(') {
                helper(s, i + 1, open + 1, close, or, cr, sb);
            } else if (c == ')' && open > close) {
                helper(s, i + 1, open, close + 1, or, cr, sb);
            }
            sb.deleteCharAt(j);
        }
    }
}
