import java.util.Stack;

public class ValidParenthisis {
    // https://leetcode.com/problems/valid-parentheses/
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case '(':
                    case '{':
                    case '[':
                        st.push(s.charAt(i));
                        break;
                    case ')':
                    case ']':
                    case '}':
                        if (!st.empty() && st.peek() == getOpen(s.charAt(i))) {
                            st.pop();
                        } else {
                            return false;
                        }
                }
            }
            if (st.empty())
                return true;
            return false;
        }

        public char getOpen(char c) {
            if (c == ')')
                return '(';
            if (c == ']')
                return '[';
            if (c == '}')
                return '{';
            return c;
        }
    }
}