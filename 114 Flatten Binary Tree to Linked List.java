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
    //This problem, the sequence of iteration of traversing the tree is a preOrder
    //which is the right, left, mid
    //we use reverse postOrder to realize that the key is that, the prev can
    //always correctly represent the position
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        //right by left
        flatten(root.right);
        flatten(root.left);

        //because we set to the right side, 3 steps of moving pointer
        root.left = null;
        root.right = prev;
        prev = root;
    }

}