/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node() {}
    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
//Approach one: stack solution, time complexity is total number of nodes
class Solution {
    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node newNode = head;

        while (newNode != null) {
            if (newNode.child != null) {
                if (newNode.next != null) {
                    stack.push(newNode.next);
                }
                newNode.next = newNode.child;
                if (newNode.next != null) {
                    newNode.next.prev = newNode;
                }

                newNode.child = null;
            } else if (newNode.next == null && !stack.isEmpty()) {
                newNode.next = stack.pop();
                newNode.next.prev = newNode;
            }
            newNode = newNode.next;
        }
        return head;
    }
}

//Approach two:
class Solution {
    //this is a flatten head function
    public Node flatten(Node head) {
        Node n = head;

        while (n != null) {
            if (n.child != null) {
                Node r = n.next;

                n.next = flatten(n.child);
                n.next.prev = n;
                n.child = null;

                while (n.next != null) n = n.next;

                if (r != null) {
                    n.next = r;
                    n.next.prev = n;
                }
            }
            n = n.next;
        }
        return head;
    }
}