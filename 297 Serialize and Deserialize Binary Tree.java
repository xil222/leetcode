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
    //goal is to represent all the nodes including the null
    //from a top down level
    //b/c we need those nodes to represent children

    //to convert from string to tree
    //from top to bot, the easiest way to construct
    //the forward index is the parent of child index
    //which is at the latter index
    //which is preOrder traversal constructing the string
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
    //use preOrder method to construct strings
    //and reconstruct, encode for the tree
    //time complexity is O(n)

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        return Integer.toString(root.val) + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //construct tree based on the data
        String[] vals = data.split(",");
        int[] idx = new int[]{0};
        return buildBST(vals, idx);
    }

    //construct the tree index by index
    private TreeNode buildBST(String[] vals, int[] idx) {
        if (vals[idx[0]].equals("#")) {
            idx[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(vals[idx[0]++]));
        root.left = buildBST(vals, idx);
        root.right = buildBST(vals, idx);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));