/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//2nd time --> diameter of a tree is calculated as the left branch length + right branch length
//The time complexity is O(n), space complexity is O(logn)
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxPath = new int[]{0};
        getEdge(root, maxPath);
        return maxPath[0];
    }

    private int getEdge(TreeNode root, int[] maxDia) {
        //base case
        if (root == null) {
            return 0;
        }

        //what to do in the middle
        int left = getEdge(root.left, maxDia);
        int right = getEdge(root.right, maxDia);

        //update maxDis
        maxDia[0] = Math.max(maxDia[0], left + right);

        //return the longest branch
        return Math.max(left, right) + 1;
    }
}


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