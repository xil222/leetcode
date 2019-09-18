//Time Complexity: O(nlogn)
class Solution {
    public int findMinDifference(List<String> timePoints) {
        //for each pair of two timestamp
        //the minDiff is (L - S) vs (S + 1day - L)
        int minVal = 720;
        int n = timePoints.size();
        //nlogn --> sort

        int[] timestamp = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            timestamp[i] = convertToTs(timePoints.get(i));
        }

        Arrays.sort(timestamp);
        for (int i = 0; i < timestamp.length-1; i++) {
            minVal = Math.min(minVal, timestamp[i+1] - timestamp[i]);
        }

        minVal = Math.min(minVal, timestamp[0] + 1440 - timestamp[n-1]);
        return minVal;
    }

    private int convertToTs(String time) {
        String[] ss = time.split(":");
        return Integer.valueOf(ss[0]) * 60 + Integer.valueOf(ss[1]);
    }
}

//Approach 2: when dealing with sort, number of vals >> number of indexes, use bucket sort
class Solution {
    public int findMinDifference(List<String> timePoints) {
        //for each pair of two timestamp
        //the minDiff is (L - S) vs (S + 1day - L)
        int minVal = 720;
        int n = timePoints.size();
        int firstTime = 0;

        boolean[] timestamp = new boolean[1440];
        for (int i = 0; i < timePoints.size(); i++) {
            int t = convertToTs(timePoints.get(i));
            if (timestamp[t]) return 0;
            else timestamp[t] = true;
        }

        while (!timestamp[firstTime]) {
            firstTime++;
        }

        int prev = firstTime;

        for (int i = firstTime + 1; i < timestamp.length; i++) {
            if (timestamp[i]) {
                minVal = Math.min(minVal, i - prev);
                prev = i;
            }
        }

        minVal = Math.min(minVal, firstTime + 1440 - prev);
        return minVal;
    }

    private int convertToTs(String time) {
        String[] ss = time.split(":");
        return Integer.valueOf(ss[0]) * 60 + Integer.valueOf(ss[1]);
    }

}