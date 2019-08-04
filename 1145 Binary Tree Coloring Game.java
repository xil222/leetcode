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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        //the smartest play is choose root
        //so there are two conditions:
        //case 1: one --> enemy choose root, so I just count left/right branch, nodes of one branch * 2 > n then win
        if (root.val == x) {
            int leftNodes = countNodes(root.left);
            int rightNodes = countNodes(root.right);
            if (leftNodes * 2 > n || rightNodes * 2 > n) {
                return true;
            }
            return false;
        } else {  //case 2: two --> enemy choose node,
            //then I choose either its leftchild, rightchild or parent
            TreeNode[] node = new TreeNode[]{new TreeNode(0)};
            TreeNode[] parent = new TreeNode[]{new TreeNode(0)};
            searchNode(root, x, node);
            //go with children
            int leftNodes = countNodes(node[0].left);
            int rightNodes = countNodes(node[0].right);

            if (Math.max(leftNodes, rightNodes) * 2 > n) {
                return true;
            }

            //go with parent
            return 2 * countNodes(node[0]) >= n? false: true;
        }
    }

    private void searchNode(TreeNode root, int x, TreeNode[] node) {
        if (root == null) {
            return;
        } else if (root.val == x) {
            node[0] = root;
            return;
        }

        searchNode(root.left, x, node);
        searchNode(root.right, x, node);
    }

    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}