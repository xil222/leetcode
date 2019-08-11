class Solution {
    //O(nmk) time complexity, O(nk) space complexity
    private final long MOD = 1000000007;
    public int numRollsToTarget(int d, int f, int target) {
        long[][] dp = new long[d + 1][target + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= d; i++) {
            for (int j = 0; j <= target; j++) {
                long sum = 0;
                for (int k = Math.max(0, j-f); k < j; k++) {
                    sum += dp[i-1][k];
                }
                dp[i][j] = sum % MOD;
            }
        }

        return (int)(dp[d][target]);
    }
}