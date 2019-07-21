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
    public int sumNumbers(TreeNode root) {
        int[] totalSum = new int[]{0};
        dfs(root, 0, totalSum);
        return totalSum[0];
    }

    private void dfs(TreeNode root, int preSum, int[] totalSum) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            totalSum[0] += preSum * 10 + root.val;
        }

        dfs(root.left, preSum * 10 + root.val, totalSum);
        dfs(root.right, preSum * 10 + root.val, totalSum);
    }

}