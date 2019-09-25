class Solution {
    //Assume there are totalof n days
    //Time/Space complexity is all O(n)
    public int mincostTickets(int[] days, int[] costs) {
        //The goal of this problem is maintain a data structure
        //storing minCost at each specific day
        int[] dp = new int[days[days.length-1] + 1];
        Set<Integer> set = new HashSet<>();

        for (int day: days) {
            set.add(day);
        }

        for (int i = 1; i < dp.length; i++) {
            if (!set.contains(i)) {
                dp[i] = dp[i-1];
            } else {
                int minVal = dp[i-1] + costs[0];
                minVal = Math.min(minVal, dp[Math.max(0, i-7)] + costs[1]);
                minVal = Math.min(minVal, dp[Math.max(0, i-30)] + costs[2]);
                dp[i] = minVal;
            }
        }

        return dp[days[days.length-1]];
    }
}

//optimize using array given problem conditions
class Solution {
    //Assume there are totalof n days
    //Time/Space complexity is all O(n)
    public int mincostTickets(int[] days, int[] costs) {
        //The goal of this problem is maintain a data structure
        //storing minCost at each specific day
        int lastDay = days[days.length-1];
        int[] dp = new int[lastDay + 1];
        boolean[] pass = new boolean[lastDay + 1];

        for (int day: days) {
            pass[day] = true;;
        }

        for (int i = 1; i <= lastDay; i++) {
            if (!pass[i]) {
                dp[i] = dp[i-1];
                continue;
            }

            int minVal = dp[i-1] + costs[0];
            minVal = Math.min(minVal, dp[Math.max(0, i-7)] + costs[1]);
            minVal = Math.min(minVal, dp[Math.max(0, i-30)] + costs[2]);
            dp[i] = minVal;
        }

        return dp[lastDay];
    }
}