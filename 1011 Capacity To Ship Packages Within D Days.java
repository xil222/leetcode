//assume n elements, average m
//time complexity log(mn) * n
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        //this is finding the binary search problem
        //it is find the min max of split
        //the result is between the max and and sum
        long sum = 0;
        int maxVal = Integer.MIN_VALUE;
        for (int item: weights) {
            maxVal = Math.max(maxVal, item);
            sum += item;
        }

        if (D == 1) {
            return (int)sum;
        }

        long start = maxVal;
        long end = sum;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (!isValid(mid, weights, D)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int)start;
    }

    private boolean isValid(long mid, int[] weights, int D) {
        int count = 0;
        long sum = 0;
        for (int item: weights) {
            sum += item;
            if (sum > mid) {
                count++;
                sum = item;
            }
            if (count == D) {
                return false;
            }
        }
        return true;
    }
}