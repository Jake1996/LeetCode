import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
    // https://leetcode.com/problems/find-duplicate-subtrees/
    public static class Solution {
    HashMap<String,Boolean> map;
    List<TreeNode> list;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        list = new ArrayList<>();
        inOrder(root);
        return list;
    }
    public String inOrder(TreeNode root) {
        if(root == null) return "";
        String answer = "("+inOrder(root.left)+")(" + root.val +")("+inOrder(root.right)+")";
        Boolean t = this.map.get(answer);
        if(t==null) {
             this.map.put(answer,false);
        }else if(t==false) {
            this.list.add(root);
            this.map.put(answer,true);
        }
        return answer;
    }
}
}
