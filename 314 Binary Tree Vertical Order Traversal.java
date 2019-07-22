/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//beats 96%
class Solution {
    //use hashMap as the data structure to store index and corresponding arrays
    //use another hashMap to store the index position of TreeNode
    //use bfs to iterate through the entire tree
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        //key: position val: val
        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        //key: TreeNode val: position
        Map<TreeNode, Integer> posMap = new HashMap<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        posMap.put(root, 0);

        int leftMost = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int pos = posMap.get(node);
                if (!hashMap.containsKey(pos)) {
                    hashMap.put(pos, new ArrayList<Integer>());
                }

                List<Integer> tmp = hashMap.get(pos);
                tmp.add(node.val);
                hashMap.put(pos, tmp);


                if (node.left != null) {
                    int newPos = pos - 1;
                    leftMost = Math.min(leftMost, newPos);
                    queue.offer(node.left);
                    posMap.put(node.left, newPos);
                }

                if (node.right != null) {
                    int newPos = pos + 1;
                    queue.offer(node.right);
                    posMap.put(node.right, newPos);
                }
            }
        }

        for (int i = leftMost; i < leftMost + hashMap.size(); i++) {
            result.add(hashMap.get(i));
        }

        return result;
    }
}

//implementation 2
// instead of using two hashMap
// using 2 queue, one storing node, one storing position
// this can save space