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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        helper(root, sum, temp, result);
        return result;
    }

    private void helper(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        temp.add(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new ArrayList(temp));
        } else {
            helper(root.left, sum - root.val, temp, result);
            helper(root.right, sum - root.val, temp, result);
        }

        temp.remove(temp.size()-1);
    }
}


//second time
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(root, sum, temp, result);
        return result;
    }

    private void dfs(TreeNode node, int sum, List<Integer> temp, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        temp.add(node.val);
        if (node.left == null && node.right == null && sum == node.val) {
            result.add(new ArrayList(temp));
        } else {
            dfs(node.left, sum - node.val, temp, result);
            dfs(node.right, sum - node.val, temp, result);
        }
        temp.remove(temp.size()-1);
    }
}