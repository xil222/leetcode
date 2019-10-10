class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) return 0;

        //for this problem, we got state of
        //maxProfit we can generate keep changing
        //this is dp problem we are maintaining states

        //for this problem, when updating the max Revenue
        //One situation we might run into is that
        //we already buy & sell a stock however,
        //we can sell the bought one at a higher totalRev
        //Therefore, we need to maintain the optimal Prev
        //Revenue and the price for stock we bought

        //the optimal prev is coming from the totalMaxProfit
        //as we are doing dp, and to keep the optimal substantial
        //preMax, we maintain a preMax parameter which means
        //the max Revenue after we bought one stock

        long totalProfit = 0;
        long preMax = Integer.MIN_VALUE; //potential maxProfit preparing of changing state

        for (int price: prices) {
            long preProfit = totalProfit; //previous max totalProfit
            totalProfit = Math.max(totalProfit, preMax + price - fee); //update totalProfit, sell current then pay for
            preMax = Math.max(preMax, preProfit - price); //bought current stock
        }

        return (int)totalProfit;
    }
}