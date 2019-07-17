/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string. Time beats 87%, Space beats 37.88%
    // O(n) time for serializing the tree
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        return Integer.toString(root.val) + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    // Same Time Complexity for the deserialize
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int[] idx = new int[]{0};
        return helper(arr, idx);
    }

    private TreeNode helper(String[] arr, int[] idx) {
        if (arr[idx[0]].equals("#")) {
            idx[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(arr[idx[0]++]));
        root.left = helper(arr, idx);
        root.right = helper(arr, idx);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));