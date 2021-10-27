public class AddTwoNumbers {
	// https://leetcode.com/problems/add-two-numbers
	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode sum = new ListNode();
			ListNode ref = sum;
			int carry = 0;
			while (l1 != null && l2 != null) {
				if (ref.next == null) {
					ref.next = new ListNode();
					ref = ref.next;
				}
				ref.val = (l1.val + l2.val + carry) % 10;
				carry = (l1.val + l2.val + carry) / 10;
				l1 = l1.next;
				l2 = l2.next;

			}
			while (l1 != null) {
				if (ref.next == null) {
					ref.next = new ListNode();
					ref = ref.next;
				}
				ref.val = (l1.val + carry) % 10;
				carry = (l1.val + carry) / 10;
				l1 = l1.next;

			}
			while (l2 != null) {
				if (ref.next == null) {
					ref.next = new ListNode();
					ref = ref.next;
				}
				ref.val = (l2.val + carry) % 10;
				carry = (l2.val + carry) / 10;
				l2 = l2.next;

			}
			if (carry > 0) {
				if (ref.next == null) {
					ref.next = new ListNode();
					ref = ref.next;
				}
				ref.val = carry;
			}
			return sum.next;

		}
	}

}
