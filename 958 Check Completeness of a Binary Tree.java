/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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