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
    //O(n) time complexity
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    //just dfs right, then left.
    private void dfs(TreeNode root, List<Integer> result, int depth) {
        if (root == null) {
            return;
        }

        if (depth == result.size()) {
            result.add(root.val);
        }

        dfs(root.right, result, depth+1);
        dfs(root.left, result, depth+1);
    }
}