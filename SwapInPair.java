public class SwapInPair {
    // https://leetcode.com/problems/swap-nodes-in-pairs/
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next ==null) return head ;
            ListNode newNext = swapPairs(head.next.next);
            if(newNext != null) {
                head.next.next = newNext;
            }
            ListNode next = head.next;
            ListNode later = head.next.next;
            head.next = later;
            next.next = head;
            return next;
        }
    }
}