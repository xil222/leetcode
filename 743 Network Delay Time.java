class Solution {
    //Time: O(V + E)
    //Space: O(V + E)
    //The goal of this problem is be able to iterate all the nodes
    //according to a global time ascending sequence

    public int networkDelayTime(int[][] times, int N, int K) {

        //key: source node
        //val: <key: target node, val: delay time>
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time: times) {
            if (!map.containsKey(time[0])) {
                map.put(time[0], new HashMap<Integer, Integer>());
            }
            map.get(time[0]).put(time[1], time[2]);
        }

        //put visited node and time
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int count = N; //to check whether all nodes been visited
        int time = 0;
        boolean[] expanded = new boolean[N+1];
        pq.offer(new int[]{K, 0});

        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            if (expanded[tmp[0]]) continue;
            expanded[tmp[0]] = true;
            time = tmp[1];
            count--;
            if (map.containsKey(tmp[0])) {
                Map<Integer, Integer> target = map.get(tmp[0]);
                for (Integer d: target.keySet()) {
                    pq.offer(new int[]{d, target.get(d) + time});
                }
            }
        }

        return count == 0? time: -1;
    }
}