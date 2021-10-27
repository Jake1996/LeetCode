public class LongestUnivaluePath {
    // https://leetcode.com/problems/longest-univalue-path/
    class Solution {
        int max = 0;
        public int longestUnivaluePath(TreeNode root) {
            if(root==null) return 0;
            helper(root);
            return this.max-1;
        }
        public int helper(TreeNode root) {
            if(root==null) return 0;
            int left = 0,right = 0;
            if(root.left!=null && root.left.val == root.val) {
                left = helper(root.left);
            }else {
                helper(root.left);
            }
            
            if(root.right!=null && root.right.val == root.val) {
                right = helper(root.right);
            }else {
                helper(root.right);
            }
            this.max = Math.max(this.max,left+right+1);
            return Math.max(left,right)+1;
        }
    }
}
