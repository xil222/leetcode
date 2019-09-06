public class Codec {
    // since this is a BST, just make sure when construct the tree, its layer by layer
    // Encodes a tree to a single string.
    // The idea of the problem is consistently rebuilding on the same tree.
    // Time complexity is O(nlogn)
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append(root.val).append(",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        TreeNode root = null;
        String[] arr = data.split(",");

        for (String str: arr) {
            root = buildBST(root, Integer.valueOf(str));
        }
        return root;
    }

    private TreeNode buildBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            root.right = buildBST(root.right, val);
        } else {
            root.left = buildBST(root.left, val);
        }
        return root;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//use dfs, save length of code, most naive way, preOrder
//in the deserialize phase, it just normally maps all parts
//time beats 70%, memory saves 100%
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null)
            return "#";
        return String.valueOf(root.val) + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return deserialize(arr , new int[]{0}); //use a parameter to record the index pos
    }

    //use array to globally control the index, use index, mid + left + right
    private TreeNode deserialize(String[] arr, int[] idx) {
        //have to return, keep adding if #
        if (arr[idx[0]].equals("#")) {
            idx[0]++;
            return null;
        }

        //this works as left go first
        TreeNode root = new TreeNode(Integer.parseInt(arr[idx[0]++]));
        root.left = deserialize(arr, idx);
        root.right = deserialize(arr, idx);
        return root;
    }
}

//use deep search, the characteristic of BST
//time beats 80% memory beats 100%
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val + ",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }

        String[] arr = data.split(",");
        TreeNode root = null;
        for (String s: arr) {
            root = buildBST(root, Integer.parseInt(s));
        }
        return root;
    }

    private TreeNode buildBST(TreeNode root, int v) {
        if (root == null) return new TreeNode(v);
        if (v < root.val) {
            root.left = buildBST(root.left, v);
        } else {
            root.right = buildBST(root.right, v);
        }
        return root;
    }
}




