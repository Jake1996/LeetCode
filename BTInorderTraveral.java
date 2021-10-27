import java.util.ArrayList;
import java.util.List;

public class BTInorderTraveral {
    // https://leetcode.com/problems/binary-tree-inorder-traversal
    class Solution {
        List<Integer> ans;

        public List<Integer> inorderTraversal(TreeNode root) {
            ans = new ArrayList<Integer>();
            helper(root);
            return ans;
        }

        public void helper(TreeNode root) {
            if (root == null)
                return;
            helper(root.left);
            this.ans.add(root.val);
            helper(root.right);
        }
    }
}
