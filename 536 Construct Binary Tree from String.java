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
    //O(n) time complexity
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0, j = i; i < s.length(); i++, j = i) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '-') {
                while (i+1 < s.length() && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9') i++;
                TreeNode newNode = new TreeNode(Integer.valueOf(s.substring(j, i+1)));
                if (!stack.isEmpty()) {
                    TreeNode prev = stack.peek();
                    if (prev.left == null) {
                        prev.left = newNode;
                    } else {
                        prev.right = newNode;
                    }
                }
                stack.push(newNode);
            } else if (s.charAt(i) == ')') {
                stack.pop();
            }
        }
        return stack.peek() == null? null: stack.peek();
    }
}