/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode slow, ListNode fast) {
        ListNode dummy = new ListNode(0);

        ListNode head = dummy;
        while (slow != null && fast != null) {
            if (slow.val < fast.val) {
                head.next = slow;
                slow = slow.next;
            } else {
                head.next = fast;
                fast = fast.next;
            }
            head = head.next;
        }

        if (slow != null) {
            head.next = slow;
        }

        if (fast != null) {
            head.next = fast;
        }

        return dummy.next;
    }

}