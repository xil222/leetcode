class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;

        int totalProfit = 0;
        int prev = prices[0];

        //two cases, if current price > prev, just sell, and update prev to be current
        //else just update prev to be current
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prev) totalProfit += prices[i] - prev;
            prev = prices[i];
        }
        return totalProfit;
    }
}