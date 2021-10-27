public class BTMaxPath {
    // https://leetcode.com/problems/binary-tree-maximum-path-sum
    class Solution {
        int max = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            helper(root);
            return this.max;
        }
        public int helper(TreeNode root) {
            if(root == null) return Integer.MIN_VALUE;
            int left = root.left != null ? helper(root.left) : 0;
            int right = root.right != null ?  helper(root.right) : 0;
            this.max = Math.max(this.max,left+right+root.val);
            this.max = Math.max(this.max,root.val);
            this.max = Math.max(this.max,root.val+Math.max(right,left));
            return Math.max(root.val,root.val+Math.max(right,left));
        }
    }
}
