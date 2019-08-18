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
    //time complexity O(N)
    public int maxLevelSum(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        bfs(root, res, 0);
        int maxVal = Integer.MIN_VALUE;
        int maxLevel = -1;
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) > maxVal) {
                maxVal = res.get(i);
                maxLevel = i + 1;
            }
        }
        return maxLevel;
    }

    private void bfs(TreeNode node, List<Integer> res, int level) {
        if (node == null) {
            return;
        }
        if (res.size() == level) {
            res.add(node.val);
        } else {
            int val = res.get(level);
            res.set(level, val + node.val);
        }

        bfs(node.left, res, level + 1);
        bfs(node.right, res, level + 1);
    }
}