public class FlattenMultilevelDLL {
    // https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
    class Solution {
        public Node flatten(Node head) {
            helper(head);
            return head;
        }
        public Node helper(Node head) {
            if(head == null) return null;
            Node cur = head;
            while(true) {
                if(cur.child!=null) {
                    Node newNext = helper(cur.child);
                    newNext.next = cur.next;
                    if(newNext.next != null)
                        newNext.next.prev = newNext;
                    cur.next = cur.child;
                    cur.next.prev = cur;
                    cur.child = null;
                    cur = newNext;
                }
                if(cur.next ==null) return cur;
                cur = cur.next;
            }
        }
    }
}
