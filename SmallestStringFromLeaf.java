public class SmallestStringFromLeaf {
    // https://leetcode.com/problems/smallest-string-starting-from-leaf
    class Solution {
        String small;
        public String smallestFromLeaf(TreeNode root) {
            helper(root,"");
            return small == null ? "" : small;
        }
        public void helper(TreeNode root, String cur) {
            if(root == null) return;
            cur =  (char)(root.val+'a') + cur;
            boolean isLeaf = root.left == null && root.right == null;
            if(isLeaf && (small!=null && cur.compareTo(small) < 0 || small==null)) {
                small = cur;
            }
            helper(root.left,cur);
            helper(root.right,cur);
        }
    }
}
