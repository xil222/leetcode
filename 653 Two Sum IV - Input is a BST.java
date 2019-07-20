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
    //this is actually slow only beats 9% b.c O(n^2)
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        return helper(root, root.left, k) || helper(root, root.right, k);
    }

    private boolean helper(TreeNode node1, TreeNode node2, int target) {
        if (node1 == null || node2 == null) {
            return false;
        } else if (node1 == node2) {
            return helper(node1.left, node1, target) || helper(node1, node1.right, target);
        } else if (node1.val + node2.val == target) {
            return true;
        }

        if (node1.val + node2.val < target) {
            return helper(node1.right, node2, target) || helper(node1, node2.right, target);
        } else {
            return helper(node1.left, node2, target) || helper(node1, node2.left, target);
        }

    }
}


class Solution {
    //Time Complexity: 69.2%, Memory: 73.69%
    //use HashSet to record all nodes, work for both BST and not
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> hashSet = new HashSet<Integer>();
        return dfs(root, hashSet, k);
    }

    private boolean dfs(TreeNode root, Set<Integer> hashSet, int k) {
        if (root == null) return false;
        if (hashSet.contains(k - root.val)) return true;
        hashSet.add(root.val);
        return dfs(root.left, hashSet, k) || dfs(root.right, hashSet, k);
    }
}