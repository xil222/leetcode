class Solution {
    //using dfs takes polynomial time complexity which is too much
    //so we use dynamic programming
    //use dp[i] represents the min number of coins we need for amount i
    //assume amount is m, there are n coins
    //time complexity is O(mn)
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.sort(coins);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE? -1: dp[amount];
    }
}

class Solution {
    //Assume amount is k, there are n coins,
    //Time Complexity: upper bound O(n^k)
    public int coinChange(int[] coins, int amount) {
        //the goal of this problem is finding the minimum
        //number of coins in composing the total amount
        //we have the assumption of coins are different
        //in order to find the mininum number of coins
        //we need to keep track of total number of coins
        //amount at this moment
        //we can use dfs to implement this goal

        int[] minVal = {Integer.MAX_VALUE};
        Arrays.sort(coins);
        dfs(coins, amount, 0, 0, minVal);
        return minVal[0] == Integer.MAX_VALUE? -1: minVal[0];
    }

    private void dfs(int[] coins, int amount, int count, int idx, int[] minVal) {
        if (amount == 0) {
            minVal[0] = Math.min(count, minVal[0]);
            return;
        }

        for (int i = idx; i < coins.length; i++) {
            for (int j = 0; j * coins[i] <= amount; j++) {
                dfs(coins, amount - j * coins[i], count + j, idx + 1, minVal);
            }
        }
    }
}