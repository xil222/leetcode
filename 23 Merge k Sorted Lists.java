/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//only beats 5% why? merge --> well use PriorityQueue
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //assume k items in the lists, average length in m
        //total length is O(km)
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        int count = 0;
        while (count < lists.length) {
            int minIdx = -1;
            ListNode next = null;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && (next == null || lists[i].val < next.val)) {
                    next = lists[i];
                    minIdx = i;
                }
            }

            if (next != null) {
                curr.next = lists[minIdx];
                curr = curr.next;
                lists[minIdx] = lists[minIdx].next;
            }
            if (next == null) count++;
        }

        return dummyHead.next;
    }
}

//use pq to store all the listnode O(k) space, O(nlogk) time
//beats 75% runtime, and 45% memory
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        while (!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            curr.next = tmp;
            curr = curr.next;
            if (tmp.next != null) {
                tmp = tmp.next;
                pq.offer(tmp);
            }
        }

        return dummyHead.next;
    }
}