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
    //key thing
    //for this problem is recursively add
    //we want delete nodes from bottom, --> each time
    //we delete one node, append left, right subtree to result list
    //and assune left, right branch as null
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int val: to_delete) {
            set.add(val);
        }

        List<TreeNode> res = new ArrayList<>();
        root = delete(root, res, set);
        if (root != null) {
            res.add(root);
        }
        return res;
    }

    private TreeNode delete(TreeNode root, List<TreeNode> res, Set<Integer> set) {
        if (root == null) return null;

        root.left = delete(root.left, res, set);
        root.right = delete(root.right, res, set);

        if (set.contains(root.val)) {
            if (root.left != null) res.add(root.left);
            if (root.right != null) res.add(root.right);
            return null;
        }

        return root;
    }
}