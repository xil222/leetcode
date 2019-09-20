/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//1st step reverse each ListNode
//2nd step adding together
//3rd reverse it back
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode next = null;
        ListNode prev1 = null;
        while (l1 != null) {
            next = l1.next;
            l1.next = prev1;
            prev1 = l1;
            l1 = next;
        }
        ListNode prev2 = null;
        while (l2 != null) {
            next = l2.next;
            l2.next = prev2;
            prev2 = l2;
            l2 = next;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int nextVal = 0;
        while (prev1 != null && prev2 != null) {
            int val = prev1.val + prev2.val + nextVal;
            nextVal = val / 10;
            val = val % 10;
            curr.next = new ListNode(val);
            prev1 = prev1.next;
            prev2 = prev2.next;
            curr = curr.next;
        }

        while (prev1 != null) {
            int val = prev1.val + nextVal;
            nextVal = val / 10;
            val = val % 10;
            curr.next = new ListNode(val);
            prev1 = prev1.next;
            curr = curr.next;
        }

        while (prev2 != null) {
            int val = prev2.val + nextVal;
            nextVal = val / 10;
            val = val % 10;
            curr.next = new ListNode(val);
            prev2 = prev2.next;
            curr = curr.next;
        }

        if (nextVal == 1) {
            curr.next = new ListNode(1);
        }

        ListNode prev = null;
        ListNode newCur = dummyHead.next;

        while (newCur != null) {
            next = newCur.next;
            newCur.next = prev;
            prev = newCur;
            newCur = next;
        }

        return prev;
    }
}