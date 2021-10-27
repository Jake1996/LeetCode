public class SecondMinimumNodeBT {
    // https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
    class Solution {
        int min1;
        long ans = Long.MAX_VALUE;

        public int findSecondMinimumValue(TreeNode root) {
            min1 = root.val;
            dfs(root);
            return ans < Long.MAX_VALUE ? (int) ans : -1;
        }

        public void dfs(TreeNode root) {
            if (root != null) {
                if (min1 < root.val && root.val < ans) {
                    ans = root.val;
                } else if (min1 == root.val) {
                    dfs(root.left);
                    dfs(root.right);
                }
            }
        }
    }
}
