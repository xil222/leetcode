class Solution {
    //O(nlog(n)) time complexity
    //O(n) space complexity
    public int networkDelayTime(int[][] times, int N, int K) {
        //this problem needs bfs to expand from the
        //beginning node, while requires dijikstra algorithm

        //key: node, val: (key: node, val: distance)
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < times.length; i++) {
            if (!map.containsKey(times[i][0])) {
                map.put(times[i][0], new HashMap<>());
            }
            map.get(times[i][0]).put(times[i][1], times[i][2]);
        }

        //algorithm sort by distance nlog(n) time complexity
        //keep track of the totalDistance, only update when
        //this node has been expanded
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        pq.add(new int[]{0, K});
        int res = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int currDis = cur[0];
            int node = cur[1];
            if (visited[node]) continue;
            visited[node] = true;
            N--;
            res = currDis;
            if (map.containsKey(node)) {
                for (Integer next: map.get(node).keySet()) {
                    pq.add(new int[]{currDis + map.get(node).get(next), next});
                }
            }
        }

        return N == 0? res: -1;
    }
}