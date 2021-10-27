public class Merge2SortedList {
    // https://leetcode.com/problems/merge-two-sorted-lists
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode root = null;
            if (l1 == null)
                return l2;
            if (l2 == null)
                return l1;
            if (l2.val < l1.val) {
                root = l2;
                l2 = l2.next;
            } else {
                root = l1;
                l1 = l1.next;
            }
            ListNode cur = root;
            while (l1 != null && l2 != null) {
                if (l2.val < l1.val) {
                    cur.next = l2;
                    l2 = l2.next;
                } else {
                    cur.next = l1;
                    l1 = l1.next;
                }
                cur = cur.next;
            }
            while (l1 != null) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }
            while (l2 != null) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
            return root;
        }
    }
}
