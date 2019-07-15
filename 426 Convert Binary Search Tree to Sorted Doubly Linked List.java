/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

//Naive method, use inOrder iteration to traverse through the tree
// beats 24.5% memort beats 5%
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        Node prev = null;
        Node head = null;
        Node curr = root;
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        //use head to record the first node
        //prev will represent the tail (last node)
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (head == null) {
                    head = curr;
                }
                if (prev != null) {
                    prev.right = curr;
                }
                curr.left = prev;
                prev = curr;
                curr = curr.right;
            }
        }

        //connect the head and tail
        head.left = prev;
        prev.right = head;

        return head;
    }
}

// Same as above, use inOrder iteration to traverse through the tree O(n)
// use nested while loop
// beats 24.5% memort beats 23.5%
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        Node prev = null;
        Node head = null;
        Node curr = root;
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        //use head to record the first node
        //prev will represent the tail (last node)
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (head == null) {
                head = curr;
            }
            if (prev != null) {
                prev.right = curr;
            }
            curr.left = prev;
            prev = curr;
            curr = curr.right;
        }

        //connect the head and tail
        head.left = prev;
        prev.right = head;

        return head;
    }
}

//Use recursion, beats 100% time O(n)
//helper function is inOrder
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node dummy = new Node(0, null, null);
        Node prev = dummy;
        prev = helper(root, prev);
        //connect head with tail
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }

    private Node helper(Node node, Node prev) {
        //base case
        if (node == null) return prev;
        //for left,
        prev = helper(node.left, prev);
        prev.right = node;
        node.left = prev;
        //for right, return current node
        prev = helper(node.right, node);
        return prev;
    }
}