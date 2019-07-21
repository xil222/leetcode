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
    public int maxPathSum(TreeNode root) {
        int[] maxVal = new int[]{Integer.MIN_VALUE};
        helper(root, maxVal);
        return maxVal[0];
    }

    private int helper(TreeNode root, int[] maxVal) {
        //base case
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            maxVal[0] = Math.max(maxVal[0], root.val);
            return Math.max(0, root.val);
        }

        int left = helper(root.left, maxVal);
        int right = helper(root.right, maxVal);

        int currSum = left + right + root.val;
        maxVal[0] = Math.max(currSum, maxVal[0]);

        //return maxPath, but not maxSum
        int maxPath = Math.max(left + root.val, right + root.val);
        maxPath = Math.max(maxPath, 0);

        //return a maxPath value no less than 0
        return maxPath;
    }
}