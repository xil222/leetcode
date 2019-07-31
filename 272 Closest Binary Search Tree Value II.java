/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//31.42%, 97.54% no prune yet
class Solution {
    class Cell {
        double gap;
        int val;
        public Cell(double gap, int val) {
            this.gap = gap;
            this.val = val;
        }
    }

    //to pq to store all k closest, O(nlogk)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Cell> gaps = new PriorityQueue<Cell>(k, new Comparator<Cell>(){ //descending
            @Override
            public int compare(Cell a, Cell b) { //use this way to simulate double
                if (b.gap < a.gap) {
                    return -1;
                }
                return 1;
            }
        });

        dfs(gaps, root, target, k);
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = gaps.poll().val;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(res[i]);
        }

        return result;
    }

    private void dfs(PriorityQueue<Cell> gaps, TreeNode root, double target, int k) {
        if (root == null) {
            return;
        }

        if (gaps.size() < k) {
            gaps.offer(new Cell(Math.abs(root.val - target), root.val));
        } else {
            if (Math.abs(root.val - target) < gaps.peek().gap) {
                gaps.poll();
                gaps.offer(new Cell(Math.abs(root.val - target), root.val));
            }
        }
        dfs(gaps, root.left, target, k);
        dfs(gaps, root.right, target, k);

    }
}

//adding the pruning part
//if (Math.abs(root.val - target) < gaps.peek().gap) {
//    gaps.poll();
//    gaps.offer(new Cell(Math.abs(root.val - target), root.val));
//    dfs(gaps, root.left, target, k);
//    dfs(gaps, root.right, target, k);
//} else if (root.val < target) {
//    dfs(gaps, root.right, target, k);
//} else {
//    dfs(gaps, root.left, target, k);
//}


//Approach 2 , use inOrder traversal O(n) time, beats 67%
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        Deque<Integer> dq = new ArrayDeque<>();
        dfs(root, dq);
        while (dq.size() > k) {
            if (Math.abs(target - dq.peekFirst()) < Math.abs(target - dq.peekLast())) {
                dq.removeLast();
            } else {
                dq.removeFirst();
            }
        }

        return new ArrayList<Integer>(dq);
    }

    private void dfs(TreeNode root, Deque<Integer> dq) {
        if (root == null) {
            return;
        }
        dfs(root.left, dq);
        dq.addFirst(root.val);
        dfs(root.right, dq);
    }
}