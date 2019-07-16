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
    //preOrder is mid, left, right
    //inOrder is left, mid, right
    //speed beats 97%, time O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //map the item in inOrder array to the position in preOrder
        //assume there is no repetitive number in preOrder and inOrder array

        //the idea of this problem, is continuely splitting the tree in half
        //which given each element, find the pos in inOrder

        //key: inOrder element
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return helper(0, preorder.length-1, 0, inorder.length-1, preorder, inorder, hashMap);
    }

    //in each iteration, we take the first element in preorder as the new center to split the tree.
    private TreeNode helper(int preLeft, int preRight, int inLeft, int inRight, int[] preorder, int[] inorder, Map<Integer, Integer> hashMap) {
        if (preLeft > preRight) {
            return null;
        }

        int midVal = preorder[preLeft];
        TreeNode root = new TreeNode(midVal);
        int mid = hashMap.get(midVal);
        int leftSize = mid - inLeft;
        root.left = helper(preLeft + 1, preLeft + leftSize, inLeft, mid - 1, preorder, inorder, hashMap);
        root.right = helper(preLeft + leftSize + 1, preRight, mid + 1, inRight, preorder, inorder, hashMap);
        return root;
    }
}