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
        return deserialize(strs, new int[]{0}); //use a parameter to record the index pos
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


//This approach is wrong, because it does not provide '#' to separate
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                result.append(Integer.toString(curr.val));
                result.append(",");
                curr = curr.right;
            }
        }

        while (result.charAt(result.length()-1) == ',')
            result.removeCharAt(result.length()-1);

        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }

        String[] numSet = data.split(',');
        TreeNode root = new TreeNode(Integer.valueOf(numSet[0]));
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        for (int i = 1; i < numSet.length; i++) {
            int val = Integer.valueOf(numSet[i]);
            TreeNode node = new TreeNode(val);
            if (val < stack.peek().val) {
                stack.peek().left = node;
                stack.push(node);
            } else {
                TreeNode prev = stack.pop();
                while (prev.val < val) {
                    prev = stack.pop();
                }
                prev.right = node;
                stack.push(node);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


