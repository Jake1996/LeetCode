import java.util.Stack;

public class KSmallestBST {
    // https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            Stack<TreeNode> st = new Stack<>();
            int visitCount = 0;
            TreeNode cur = root;
            while(!st.empty() || cur!=null) {
                while(cur!=null) {
                    st.push(cur);
                    cur = cur.left;
                }
                cur = st.pop();
                visitCount++;
                if(visitCount == k) return cur.val;
                cur = cur.right;
            }
            return 0;
        }
    }
}
