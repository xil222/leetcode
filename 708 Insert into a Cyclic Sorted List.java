
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    // The normal case
    //case 1: curr.val <= insertVal <= curr.next.val

    // Since ascending, reaches the end
    //case 2: curr.val > curr.next.val && (insertVal <= curr.next.val || insertVal >= curr.val)

    // All points iterated, they are all same value
    //case 3:
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
        } else {
            Node curr = head;
            while (!(insertVal >= curr.val && insertVal <= curr.next.val) &&
                    !(curr.val > curr.next.val && (insertVal <= curr.next.val || insertVal >= curr.val)) &&
                    curr.next != head) {
                curr = curr.next;
            }
            Node node = new Node(insertVal, curr.next);
            curr.next = node;
        }

        return head;
    }
}