
public class ValidBST {
    // https://leetcode.com/problems/validate-binary-search-tree/
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return validHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean validHelper(TreeNode root, long left, long right) {
            if (root == null)
                return true;
            if (root.val <= left || root.val >= right)
                return false;
            return validHelper(root.left, left, root.val) && validHelper(root.right, root.val, right);
        }
    }
}