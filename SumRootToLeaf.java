public class SumRootToLeaf {
    // https://leetcode.com/problems/sum-root-to-leaf-numbers
    class Solution {
        int total;
        public int sumNumbers(TreeNode root) {
            total = 0;
            helper(root,0);
            return total;
        }
        public void helper(TreeNode root,int cur) {
            if(root == null) {
                return;
            }
            cur*=10;
            cur+=root.val;
            boolean isLeaf = root.left == null && root.right == null;
            if(isLeaf) {
                total+=cur;
                return;
            }
            helper(root.left,cur);
            helper(root.right,cur);
        }
    }
}
