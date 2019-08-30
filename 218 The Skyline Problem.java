class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        //idea is finding the critical point,
        //the highest point that is different from
        //the previous one, need the information
        //of starting point, end point of each of the
        //building and their heights
        //using the size of the pq to control how many
        //elements left in the array

        List<List<Integer>> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b: buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }

        //at the same position, drop the previous buildings, then add new buildings
        //b/c only when update new building we want to update the maxHeight
        Collections.sort(height, (a, b) -> (a[0] == b[0] ? a[1] - b[1]: a[0] - b[0]));

        //descending
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int preMax = 0;

        for (int[] h: height) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }

            int curMax = pq.peek();
            if (curMax != preMax) {
                List<Integer> list = new ArrayList<>();
                list.add(h[0]);
                list.add(curMax);
                res.add(list);
                preMax = curMax;
            }
        }
        return res;
    }
}