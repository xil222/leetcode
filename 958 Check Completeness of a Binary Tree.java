/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//To verify a binary tree is a complete binary tree, when iterating through a tree using BFS,
//we stop at first null
//then remove all nulls inside a tree to see till terminate to see if there is any nodes left
//O(n) time complexity O(logn) space complexity
//catch the case of not complete which there is null between treeNodes during level order iteration
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }

        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        return queue.isEmpty();
    }
}


class Solution {
    public boolean isCompleteTree(TreeNode root) {
        //to note here! Queue -> can put null into offer(null) is valid, but Deque is not valid here
        //time complexity is O(n), n stands for number of nodes
        //this problem is making use of the property of completeness of tree, which using BFS to iterate
        //the tree, you stop at the first null, then check if there is any nodes left
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }

        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }

        return queue.isEmpty();
    }
}