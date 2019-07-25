/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
//beats 51.83%, but this method doesn't make use of both sides connection
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        //start from one node do bfs to find more nodes
        Node curr = new Node(node.val, new ArrayList<Node>());

        //key: old node, val: new node
        Map<Node, Node> map = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();

        //use bfs to do the search
        queue.offer(node);
        map.put(node, curr);

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            for (Node nei: tmp.neighbors) {
                //each node in original map only iterate once
                if (!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val, new ArrayList<Node>()));
                    queue.offer(nei);
                }
                map.get(tmp).neighbors.add(map.get(nei));
            }
        }

        return curr;
    }
}