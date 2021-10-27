import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DeleteNodeForest {

    // https://leetcode.com/problems/delete-nodes-and-return-forest/
    class Solution {
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            List<TreeNode> list = new ArrayList<>();
            HashSet<Integer> hs = new HashSet<Integer>();
            for (int i : to_delete)
                hs.add(i);
            if (!hs.contains(root.val)) {
                list.add(root);
            }
            delHelp(root, list, hs);

            return list;
        }

        public void delHelp(TreeNode root, List<TreeNode> list, HashSet<Integer> hs) {
            if (root == null)
                return;
            if (hs.contains(root.val)) {
                if (root.right != null) {
                    if (!hs.contains(root.right.val)) {
                        list.add(root.right);
                    }
                    delHelp(root.right, list, hs);
                    root.right = null;
                }
                if (root.left != null) {
                    if (!hs.contains(root.left.val)) {
                        list.add(root.left);
                    }
                    delHelp(root.left, list, hs);
                    root.left = null;
                }
            } else {
                delHelp(root.right, list, hs);
                delHelp(root.left, list, hs);
                if (root.right != null && hs.contains(root.right.val)) {
                    root.right = null;
                }
                if (root.left != null && hs.contains(root.left.val)) {
                    root.left = null;
                }

            }

        }
    }
}