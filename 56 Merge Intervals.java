class Solution {
    //total time complexity O(nlogn)
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] prevInterval = intervals[0];

        //use interval represents the latter interval
        for (int[] interval: intervals) {
            if (interval[0] <= prevInterval[1]) {
                prevInterval[1] = Math.max(interval[1], prevInterval[1]);
            } else {
                result.add(prevInterval);
                prevInterval = interval;
            }
        }

        result.add(prevInterval);

        return result.toArray(new int[result.size()][]);
    }
}

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Integer> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval: intervals) {
            if (interval.start <= end) {
                end = Math.max(interval.end, end);
            }
            else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }

        }
        result.add(new Interval(start, end));
        return result;
    }
}

