//first approach naive solution,
//put every worker, bike pair into pq
//assume m worker, n bike
//time complexity is mnlog(mn), space complexity is nm
//which is not desirable

class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {

        //set up pq, sorting order using distance asd, worker idx asd, bike idx asd
        //use int[]{manhattan distance, worker idx, bike idx}

        //this can be optimized to one lines:
        //Queue<int[]> q = new PriorityQueue<int[]>((a, b)->(a[0] == b[0] ? (a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]) : a[0] - b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0] && a[1] == b[1]) {
                    return a[2] - b[2];
                } else if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });

        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int distance = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                pq.offer(new int[]{distance, i, j});
            }
        }

        Set<Integer> bikeUsed = new HashSet<>();
        int[] res = new int[workers.length];
        Arrays.fill(res, -1);

        int count = 0;
        while (count < res.length) {
            int[] tmp = pq.poll();
            if (res[tmp[1]] == -1 && !bikeUsed.contains(tmp[2])) {
                res[tmp[1]] = tmp[2];
                bikeUsed.add(tmp[2]);
                count++;
            }
        }
        return res;
    }
}

//second approach, bucket sort because distance and index is not much
//2000 is just like constant, therefore time complexity is O(mn)
class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] workerIdx = new int[workers.length];
        boolean[] bikeIdx = new boolean[bikes.length];

        Arrays.fill(workerIdx, -1);
        int count = 0;
        //****list-array structure
        List<int[]>[] buckets = new ArrayList[2001];

        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int dis = calcDis(workers[i], bikes[j]);
                if (buckets[dis] == null) {
                    buckets[dis] = new ArrayList<int[]>();
                }
                buckets[dis].add(new int[] {i ,j});
            }
        }

        for (int i = 0; i <= 2000; i++) {
            if (buckets[i] == null)
                continue;

            for (int j = 0; j < buckets[i].size(); j++) {
                int bIdx = buckets[i].get(j)[1];
                int wIdx = buckets[i].get(j)[0];
                if (!bikeIdx[bIdx] && workerIdx[wIdx] == -1) {
                    workerIdx[wIdx] = bIdx;
                    bikeIdx[bIdx] = true;
                    count++;
                }
            }
        }

        return workerIdx;
    }

    private int calcDis(int[] a, int[] b) {
        return Math.abs(a[0]-b[0]) + Math.abs(a[1] - b[1]);
    }
}
