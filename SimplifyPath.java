import java.util.Stack;

public class SimplifyPath {
    // https://leetcode.com/problems/simplify-path/
    class Solution {
        public String simplifyPath(String path) {
            String[] arr = path.split("/");
            Stack<String> st = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                switch (arr[i]) {
                    case ".":
                    case "":
                        break;
                    case "..":
                        if (!st.empty())
                            st.pop();
                        break;
                    default:
                        st.push(arr[i]);
                }
            }
            if (st.empty())
                return "/";
            String ans = "";
            while (!st.empty()) {
                ans = st.pop() + "/" + ans;
            }
            return "/" + ans.substring(0, ans.length() - 1);
        }
    }
}
