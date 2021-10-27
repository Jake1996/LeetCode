public class FlattenBinaryTreeToLinkedList {
    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list
    class Solution {
        TreeNode cur;

        public void flatten(TreeNode root) {
            recurse(root);
        }

        public TreeNode recurse(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode right = recurse(root.right);
            TreeNode left = recurse(root.left);
            if (left == null) {
                root.right = right;
                root.left = null;
            } else if (right == null) {
                root.left = null;
                root.right = left;
            } else {
                TreeNode a = left;
                while (a.right != null) {
                    a = a.right;
                }
                a.right = right;
                root.right = left;
                root.left = null;
            }
            return root;
        }
    }
}
