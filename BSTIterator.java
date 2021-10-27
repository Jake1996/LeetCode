import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        TreeNode cur = root;
        st = new Stack<>();
        while(cur!=null) {
            st.push(cur);
            cur = cur.left;
        }
    }
    
    public int next() {
        TreeNode element = st.pop();
        TreeNode cur = element.right;
        while(cur!=null) {
            st.push(cur);
            cur = cur.left;
        }
        return element.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}