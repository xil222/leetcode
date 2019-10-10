class Solution {
    public int maxProfit(int[] prices) {

        if (prices.length <= 1) return 0;
        int maxProfit = 0;
        int min = prices[0];

        //two cases, if current price > prev, update maxProfit
        //else just update min
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) maxProfit = Math.max(maxProfit, prices[i] - min);
            else {
                min = prices[i];
            }
        }
        return maxProfit;

    }
}