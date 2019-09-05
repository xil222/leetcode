//This problem is looking for the minMax
class Solution {
    public int splitArray(int[] nums, int m) {

        //dp[i][j] represents the minMax
        //of nums with size j and (i+1) splits
        int[][] dp = new int[m][nums.length];

        dp[0][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = dp[0][i-1] + nums[i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = i; j < nums.length; j++ ) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < j; k++) {
                    //find the max comparing between using i-1 stack min, with the position k~j, compare with the previous minMax
                    min = Math.min(min, Math.max(dp[0][j] - dp[0][k], dp[i-1][k]));
                }
                dp[i][j] = min;
            }
        }

        return dp[m-1][nums.length-1];
    }
}

//binary search approach
//this is very nice solution time complexity depending on the totalSum and length of array
//assume average val is n, length is m
//Then total time complexity is: log(nm) * m
class Solution {
    public int splitArray(int[] nums, int m) {
        //the result is between the maxVal and the sum
        int maxVal = Integer.MIN_VALUE;
        long sum = 0;
        for (int num: nums) {
            maxVal = Math.max(num, maxVal);
            sum += num;
        }

        if (m == 1) {
            return (int)sum;
        }

        long left = maxVal;
        long right = sum;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (isValid(mid, nums, m)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int)left;
    }

    //each part no more than val and as large as possible
    private boolean isValid(long val, int[] nums, int m) {
        int cnt = 0;
        long preSum = 0;
        for (int num: nums) {
            preSum += num;
            if (preSum > val) {
                cnt++;
                preSum = num;
            }
            if (cnt == m) {
                return false;
            }
        }
        return true;

    }
}

//dp approach
//use 2 dimensional array, dp[i][j] represents the
//smallest of the greatest of i+1 piles j+1 number
//time complexity: O(n^2 * m)
class Solution {
    public int splitArray(int[] nums, int m) {
        int[][] dp = new int[m][nums.length];

        //base case
        dp[0][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = dp[0][i-1] + nums[i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = i; j < nums.length; j++) {
                //because each i there is at least one
                int min = Integer.MAX_VALUE; //count the min of max
                //try difference split at position k to get the min of max
                for (int k = 0; k < j; k++) {
                    //max inside get the max, outside get the min
                    min = Math.min(min, Math.max(dp[0][j] - dp[0][k], dp[i-1][k]));
                }
                dp[i][j] = min;
            }
        }
        return dp[m-1][nums.length-1];
    }
}