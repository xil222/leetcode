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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //use inOrder traversal, recording the prev val and current val
        if (root == null) {
            return null;
        }
        TreeNode prev = null;
        while (root != null) {
            if (root.val > p.val) {
                prev = root;
                root = root.left;
            } else { //go right if <= target
                root = root.right;
            }
        }
        return prev;
    }
}