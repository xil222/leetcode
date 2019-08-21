class Solution {
    //O(n) time complexity
    public double new21Game(int N, int K, int W) {
        //use dp[i] represents possibility of i

        //base case
        if (K == 0 || N >= K + W) {
            return 1.0;
        }

        //dp[i] is average of last W dps
        double[] dp = new double[N+1];
        dp[0] = 1.0;
        double preSum = 1.0;
        double res = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = preSum / W;
            if (i < K) {
                preSum += dp[i];
            } else { //for K <= i <= N
                res += dp[i];
            }

            if (i >= W) {
                preSum -= dp[i-W];
            }
        }
        return res;
    }
}