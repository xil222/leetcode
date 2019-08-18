//different from last problem which is a greedy one
//seeking the optimal (bike, worker) pair
//this one is searching overall optimal
//brute force O(mn)

//notice: 1 <= workers.length <= bikes.length <= 10
//so brutal force, dfs,
//O(n * m!) time complexity
class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int[] minVal = new int[]{Integer.MAX_VALUE};
        dfs(workers, bikes, 0, new boolean[bikes.length], minVal, 0);
        return minVal[0];
    }

    private void dfs(int[][] workers, int[][] bikes, int wIdx, boolean[] visited, int[] minVal, int distance) {
        if (wIdx == workers.length) {
            minVal[0] = Math.min(minVal[0], distance);
            return;
        }

        //pruning
        if (distance > minVal[0]) {
            return;
        }

        for (int i = 0; i < bikes.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int dis = calcDis(workers[wIdx], bikes[i]);
            dfs(workers, bikes, wIdx+1, visited, minVal, distance + dis);
            visited[i] = false;
        }

    }

    private int calcDis(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}