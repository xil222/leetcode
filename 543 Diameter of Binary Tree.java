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
    //similar to get max depth, but need to keep a global variable , O(n) time, beat 100%
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int[] maxPath = new int[]{0};
        getEdge(root, maxPath);
        return maxPath[0];
    }

    private int getEdge(TreeNode root, int[] maxPath) {
        //base case
        if (root == null) {
            return 0;
        }

        //get depth
        int left = getEdge(root.left, maxPath);
        int right = getEdge(root.right, maxPath);

        maxPath[0] = Math.max(left + right, maxPath[0]);

        return Math.max(left, right) + 1;
    }
}