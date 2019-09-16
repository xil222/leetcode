/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//recursion
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    private boolean dfs(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else if (node1.val != node2.val) {
            return false;
        }

        //go to next layer
        return dfs(node1.left, node2.right) && dfs(node1.right, node2.left);
    }
}

//iterative
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        //do it iteratively queue store
        //symmetric nodes next to each other
        //stack can contain null
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root.left != null) {
            if (root.right == null) return false;
            queue.offer(root.left);
            queue.offer(root.right);
        } else if (root.right != null) {
            return false;
        }

        while (!queue.isEmpty()) {
            if (queue.size() % 2 != 0) return false;

            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            //left, right are not null

            if (left.val != right.val) return false;

            if (left.left != null) {
                if (right.right == null) return false;
                queue.offer(left.left);
                queue.offer(right.right);
            } else if (right.right != null) {
                return false;
            }

            if (left.right != null) {
                if (right.left == null) return false;
                queue.offer(left.right);
                queue.offer(right.left);
            } else if (right.left != null) {
                return false;
            }
        }
        return true;
    }
}