/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        //key: preSum, val: ListNode
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummyHead);
        int preSum = 0;

        while (head != null) {
            // System.out.println("preSum " + preSum);
            preSum += head.val;
            if (map.containsKey(preSum)) {
                ListNode start = map.get(preSum);
                remove(map, preSum, start.next, head);
                start.next = head.next;
            } else {
                map.put(preSum, head);
            }
            head = head.next;
        }

        return dummyHead.next;
    }

    private void remove(Map<Integer, ListNode> map, int preSum, ListNode start, ListNode end) {
        System.out.println("startVal " + start.val);
        while (start != end) {
            preSum += start.val;
            // System.out.println("removeVal " + start.val);
            map.remove(preSum);
            start = start.next;
        }
    }
}