
//binary search on number of buckets
//the key thing is that for counts[k], counts[k+1]
//the randomed item in within a range
//therefore this approach

class Solution {
    Random random;
    int[] counts;

    public Solution(int[] w) {
        random = new Random();
        counts = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            counts[i] = sum;
        }
    }

    public int pickIndex() {
        int len = counts.length;
        int idx = random.nextInt(counts[len-1]) + 1;
        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (counts[mid] == idx) {
                return mid;
            } else if (counts[mid] < idx) {
                left = mid + 1; //meaning the result is at least next bucket
            } else {
                right = mid; //meaning the result is in one pre bucket
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */