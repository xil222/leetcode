/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//approach 1
//This approach takes O(nlogn) time
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        //the idea should be create root, then insert node one by one
        if (preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insertNode(root, preorder[i]);
        }
        return root;
    }

    private void insertNode(TreeNode node, int val) {
        if (val < node.val) {
            if (node.left != null) {
                insertNode(node.left, val);
            } else {
                node.left = new TreeNode(val);
                return;
            }
        } else {
            if (node.right != null) {
                insertNode(node.right, val);
            } else {
                node.right = new TreeNode(val);
                return;
            }
        }
    }
}

//approach 2
//for smaller val, just append as the left branch of peek
//for greater val, keep track of the second last node
//how? assign it to the pop, in the loop
//in outer condition, just check with peek
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        //the idea should be create root, then insert node one by one
        if (preorder.length == 0) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        //idea is iterating the preorder list
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (stack.peek().val > node.val) {
                stack.peek().left = node;
            } else {
                TreeNode tmp = stack.peek();
                while (!stack.isEmpty() && node.val > stack.peek().val) {
                    tmp = stack.pop();
                }
                tmp.right = node;
            }
            stack.push(node);
        }

        return root;
    }
}