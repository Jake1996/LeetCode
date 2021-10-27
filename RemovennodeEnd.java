public class RemovennodeEnd {

    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head.next == null) {
                return null;
            }
            int totalHeight = shouldRemove(head, n);
            if (n == totalHeight)
                return head.next;

            return head;

        }

        public int shouldRemove(ListNode head, int n) {
            if (head.next == null) {
                return 1;
            }
            int height = shouldRemove(head.next, n);
            if (height == (n)) {
                ListNode next = head.next;
                head.next = next.next;
            }
            return height + 1;
        }
    }
}