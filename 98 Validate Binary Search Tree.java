/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//for below two methods, the theoritical time is always O(n)
//method 1, using bfs beats 75%
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Long minVal = Long.MIN_VALUE;
        Long maxVal = Long.MAX_VALUE;
        return isValid(root.left, minVal, root.val) && isValid(root.right, root.val, maxVal);
    }

    private boolean isValid(TreeNode node, long low, long high) {
        if (node == null) {
            return true;
        }

        if (node.val <= low || node.val >= high) {
            return false;
        }

        return isValid(node.left, low, node.val) && isValid(node.right, node.val, high);
    }
}


//method 2, using inorder traversal slower, b/c there always node that are empty
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;

        //two conditions to maintain for this while loop
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                if (prev != null && prev.val >= node.val) {
                    return false;
                }
                prev = node;
                cur = node.right;
            }
        }
        return true;
    }
}


//second time, use bfs range critique
class Solution{
    public boolean isvalidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Long minVal = Long.MIN_VALUE;
        Long maxVal = Long.MAX_VALUE;
        return isValid(root.left, minVal, root.val) && isValid(root.left, root.val, maxVal);
    }

    private boolean isValid(TreeNode node, int minVal, int maxVal) {
        if (node == null) {
            return true;
        }

        if (node.val >= maxVal || node.val <= minVal) {
            return false;
        }

        return isValid(node.left, minVal, node.val) && isValid(node.right, node.val, maxVal);
    }
}


//use inOrder iteration
class Solution {
    public boolean isvalidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                if (prev != null && prev.val >= node.val) {
                    return false;
                }
                prev = node;
                curr = node.right;
            }
        }
        return true;
    }
}

