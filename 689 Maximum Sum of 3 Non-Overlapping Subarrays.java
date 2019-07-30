class Solution {
    //time complexity O(n) + O(4n) --> well O(n)
    //space complexity O(n)
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

        int[] sum = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }

        //dp[i][j] represents maxVal of using i subArray
        //at ends at position j

        //pos[i][j] represents the last used index
        //which has the greatest value using i subarray
        //end at position j-1
        int[][] pos = new int[4][nums.length + 1];
        int[][] dp = new int[4][nums.length + 1];

        for (int i = 1; i <= 3; i++) {
            for (int j = k * i; j <= nums.length; j++) {
                int currSum = sum[j] - sum[j-k] + dp[i-1][j-k];
                if (currSum > dp[i][j-1]) {
                    dp[i][j] = currSum;
                    pos[i][j] = j-k;
                } else {
                    dp[i][j] = dp[i][j-1];
                    pos[i][j] = pos[i][j-1];
                }
            }
        }

        int[] res = new int[3];
        int idx = nums.length;
        for (int i = 2; i >= 0; i--) {
            res[i] = pos[i+1][idx];
            idx = res[i];
        }
        return res;

    }
}