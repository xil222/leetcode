class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length <= 1) {
            return true;
        }

        Arrays.sort(intervals, (s1, s2) -> Integer.compare(s1.start, s2.start));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i+1].start) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] s1, int[] s2) {
                return s1[0] - s2[0];
            }
        });

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }
        return true;
    }
}