import java.util.HashMap;

public class BTFromInPreOrder {
    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
    class Solution {
        HashMap<Integer,Integer>  hm;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.hm = new HashMap<>();
            for(int i=0;i<inorder.length;i++) {
                hm.put(inorder[i],i);
            }
            return helper(inorder,preorder,0,inorder.length-1,0,preorder.length-1);
        }
        public TreeNode helper(int[] inorder, int[] preorder, int Istart, int Iend,int Pstart,int Pend) {
            int n = inorder.length;
            if(Iend<Istart || Pend < Pstart || Iend>= n || Pend >= n) return null;
            TreeNode root = new TreeNode();
            root.val = preorder[Pstart];
            if(Istart==Iend) return root;
            int IIndex = this.hm.get(root.val);
            int leftL = IIndex-Istart-1;
            TreeNode left = helper(inorder, preorder, Istart,IIndex-1,Pstart+1,Pstart+leftL+1);
            TreeNode right = helper(inorder, preorder, IIndex+1,Iend,Pstart+leftL+2,Pend);
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
