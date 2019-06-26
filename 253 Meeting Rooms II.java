class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //whether there exists overlap is dependent on the next.start < prev.end
        if (intervals.length <= 1) {
            return intervals.length;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] s1, int[] s2) {
                return s1[0] - s2[0];
            }
        });


        //if initialize pq with a certain size, remember the interval length can't be 0
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(intervals.length, new Comparator<int[]>() {
            public int compare(int[] s1, int[] s2) {
                return s1[1] - s2[1];
            }
        });

        pq.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = pq.poll();
            if (intervals[i][0] < interval[1]) { //if time conflict exists
                pq.offer(intervals[i]);
            } else { //if there no time conflict, just merge
                interval[1] = intervals[i][1];
            }
            pq.offer(interval);
        }

        return pq.size();
    }
}