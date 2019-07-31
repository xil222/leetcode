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
    class Node {
        int x, y, val;
        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    //O(nlogn) time complexity, O(n) space complexity
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //this problem is sorting each list based on x, y, and val
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                if (a.x < b.x) return -1;
                if (a.x > b.x) return 1;
                if (a.y > b.y) return -1;
                if (a.y < b.y) return 1;
                return a.val - b.val;
            }
        });

        helper(root, 0, 0, pq);
        Node prev = null;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            if (prev != null && tmp.x != prev.x) {
                result.add(list);
                list = new ArrayList<>();
            }
            list.add(tmp.val);
            prev = tmp;
        }

        //by comparing each element with its previous x to decide whether in the same array
        if (list.size() > 0) {
            result.add(list);
        }

        return result;
    }

    private void helper(TreeNode node, int x, int y, PriorityQueue<Node> pq) {
        if (node == null) {
            return;
        }
        pq.offer(new Node(x,y,node.val));
        helper(node.left, x-1, y-1, pq);
        helper(node.right, x+1, y-1, pq);
    }

}