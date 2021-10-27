import java.util.HashMap;

public class BTFromInPostOrder {

    public static void main(String[] args) {
        System.out.print((new Solution()).buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 }));
    }

    // https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
    static class Solution {
        HashMap<Integer, Integer> hm;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.hm = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                hm.put(inorder[i], i);
            }
            return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        }

        public TreeNode helper(int[] inorder, int[] postorder, int Istart, int Iend, int Pstart, int Pend) {
            int n = inorder.length;
            if (Iend < Istart || Pend < Pstart || Iend >= n || Pend >= n)
                return null;
            TreeNode root = new TreeNode();
            root.val = postorder[Pend];
            if (Istart == Iend)
                return root;
            int IIndex = this.hm.get(root.val);
            int leftL = IIndex - Istart - 1;
            TreeNode left = helper(inorder, postorder, Istart, IIndex - 1, Pstart, Pstart + leftL);
            TreeNode right = helper(inorder, postorder, IIndex + 1, Iend, Pstart + leftL + 1, Pend - 1);
            root.left = left;
            root.right = right;
            return root;
        }
    }
}