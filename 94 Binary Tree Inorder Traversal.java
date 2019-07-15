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
    //in-order traversal, time complexity O(n)
    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<Integer>();
        }

        TreeNode curr = root;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);
                curr = node.right;
            }
        }

        return result;
    }
}

//Looks nicer:
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
    //in-order traversal
    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<Integer>();
        }

        TreeNode curr = root;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;
    }
}