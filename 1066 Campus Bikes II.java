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


class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int[] minDis = new int[]{Integer.MAX_VALUE};
        dfs(workers, bikes, 0, minDis, new boolean[bikes.length], 0);
        return minDis[0];
    }

    private void dfs(int[][] workers, int[][] bikes, int idx, int[] minDis, boolean[] visited, int dis) {
        if (idx == workers.length) {
            minDis[0] = Math.min(minDis[0], dis);
            return;
        }

        for (int i = 0; i < bikes.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            int dd = calDis(workers[idx], bikes[i]);
            dfs(workers, bikes, idx + 1, minDis, visited, dis + dd);
            visited[i] = false;
        }
    }

    private int calDis(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

}