//when can treat this problem as subset sum
//however, can we use dfs?
//the answer is dfs will cause too much time complexity
//nums of size n, its complexity is 2^(n/2)
//so here we use dp, backpack problem to work on this
//if totalSum is k, number of elements in nums is n
//both time and space complexity is O(nk)
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        if (totalSum % 2 == 1) {
            return false;
        }

        //let's convert this to a backpack problem, use dp to solve
        //which dp[i] represents a price of (i-1) can be calculated
        //from combination of values in nums.
        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            //go from large to small because each value can only be used once
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[target];
    }
}