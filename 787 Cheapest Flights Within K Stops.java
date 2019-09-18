//Time Complexity: O(V + E)
class Solution {
    class Stop {
        int idx;
        int cost;
        int stop;
        public Stop(int idx, int cost, int stop) {
            this.idx = idx;
            this.cost = cost;
            this.stop = stop;
        }
    }

    //The key of this problem is that we cannot only consider the cost
    //because there exists cases of for options at stop, lower cost & higher stops vs higher cost & lower stops
    //both can be candidates to be minDist due to the K
    //therefore each time we update pq, we update cases that satisfy at least one of two options above
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //The goal of this problem is to find the lowest
        //cost from source to target
        //since here are all edges that is weighted
        //its better to use djkstra
        //we use PriorityQueue to store node idx, distance from beginning, ith stop

        //because of the limitation of max K stops, therefore
        //we have cases of broad nodeA at lowest cost but not lowest stop doesnt work
        //using PriorityQueue, idea is sorting with price ascending
        PriorityQueue<Stop> pq = new PriorityQueue<>(new Comparator<Stop>() {
            @Override
            public int compare(Stop a, Stop b) {
                return a.cost - b.cost;
            }
        });

        int minDst = Integer.MAX_VALUE;

        //since we are given n cities, we can use 2-d array to store all costs
        //costs[i][j] represents cost from i to j
        int[][] costs = new int[n][n];
        //each node can only broadcast once

        int[] dstCost = new int[n];
        int[] stop = new int[n];
        Arrays.fill(dstCost, Integer.MAX_VALUE);
        Arrays.fill(stop, Integer.MAX_VALUE);

        //the condition to add new element into pq is stop stop < k
        for (int i = 0; i < flights.length; i++) {
            costs[flights[i][0]][flights[i][1]] = flights[i][2];
        }

        //idx, cost, stop
        pq.offer(new Stop(src, 0, 0));
        while (!pq.isEmpty()) {
            Stop tmp = pq.poll();
            if (tmp.idx == dst) minDst = Math.min(minDst, tmp.cost);
            if (tmp.stop == K + 1) continue;

            for (int i = 0; i < n; i++) {
                if (costs[tmp.idx][i] == 0) {
                    continue;
                }
                int newCost = tmp.cost + costs[tmp.idx][i];
                int newStop = tmp.stop + 1;
                if (newCost < dstCost[i]) {
                    pq.offer(new Stop(i, newCost, newStop));
                    dstCost[i] = newCost;
                    stop[i] = Math.min(stop[i], newStop);
                } else if (newStop < stop[i]) {
                    pq.offer(new Stop(i, newCost, newStop));
                    stop[i] = newStop;
                }
            }
        }

        return minDst == Integer.MAX_VALUE? -1: minDst;
    }
}