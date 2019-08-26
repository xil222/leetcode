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
    // The idea of this problem is comparing left height with right height
    // since this is complete binary
    //
    // Time Complexity both O(logn) * O(logn)
    // Space Complexity is O(logn)

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = countLeftHeight(root);
        int rightHeight = countRightHeight(root);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    private int countLeftHeight(TreeNode node) {
        int height = 1;
        while (node.left != null) {
            node = node.left;
            height++;
        }
        return height;
    }

    private int countRightHeight(TreeNode node) {
        int height = 1;
        while (node.right != null) {
            node = node.right;
            height++;
        }
        return height;
    }
}
//sol 2
class Solution {

    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
                height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
                        : (1 << h-1) + countNodes(root.left);
    }
}

