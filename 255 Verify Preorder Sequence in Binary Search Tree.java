class Solution {
    public boolean verifyPreorder(int[] preorder) {
        //binary search tree is for each node
        //all nodes in its left subtree smaller than it
        //all nodes in its right subtree greater than it

        //with a preOrder sequence, we just need to check
        //preOrder following mid, left, right

        //whether we traverse through right subtree
        //we need to maintain the val of root as the threshold
        //that we cannot exceed

        int minVal = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();

        for (int val: preorder) {
            if (val < minVal) {
                return false;
            }

            while (!stack.isEmpty() && val > stack.peek()) {
                minVal = stack.pop();
            }
            stack.push(val);
        }

        return true;
    }
}

//O(1) space
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        //everytime to check
        //find the root of subtree
        //and check the value of root of subtree
        //use array, index to replace stack
        int minVal = Integer.MIN_VALUE;
        int i = -1;

        for (int val: preorder) {
            if (val < minVal)
                return false;

            while (i >= 0 && val > preorder[i]) {
                minVal = preorder[i--];
            }
            preorder[++i] = val;
        }

        return true;
    }
}