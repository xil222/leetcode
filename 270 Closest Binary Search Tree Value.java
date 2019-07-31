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
    //time complexity O(logn) space O(logn)
    public int closestValue(TreeNode root, double target) {
        double minVal = Math.abs(root.val - target);
        int[] res = new int[]{root.val};
        dfs(root, target, minVal, res);
        return res[0];
    }

    private void dfs(TreeNode root, double target, double minVal, int[] res) {
        if (root == null) {
            return;
        }

        if (Math.abs(root.val - target) < minVal) {
            res[0] = root.val;
            minVal = Math.abs(root.val - target);
        }

        if (root.val > target) {
            dfs(root.left, target, minVal, res);
        } else {
            dfs(root.right, target, minVal, res);
        }
    }
}